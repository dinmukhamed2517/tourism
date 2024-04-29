package kz.sdk.tourism.fragments

import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.google.android.gms.maps.model.RoundCap
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentMapBinding
import kz.sdk.tourism.models.Place

class MapFragment: BaseFragment<FragmentMapBinding>(FragmentMapBinding::inflate), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    private val locations = listOf(
        Place(1, "МАРҚАКӨЛ КӨЛІ", 4.5, "Шығыс Қазақстан облысы", "Шығыс Қазақстандағы өзінің керемет пейзаждарымен ерекшеленетін, әсіресе күн батқан немесе таң атқан кезде, таңғажайып әдемі орын - Марқакөл көлі. Туристердің арасында кристалды таза, мөлдір сулармен танымалдылыққа ие болды. Көл тұщы сулардың қатарында және бүгін күні аталмыш табиғат қорығының ең маңызды бөлігі болып табылады. Марқакөлдің көркем жағалау аймақтары бай флора мен фауна әлемін қамтиды. Жергілікті ландшафттарға 700-ден астам өсімдік түрлері өсітін шабындықтар, таулы ормандар, тайга жатады, ал фауна өкілдерінен қоңыр аюлар, қар барыстары, құнулар, жабайы қабандар, қасқырлар, бұғылар және басқа да ғажайып жануарлар бар. Көлдің қысы өте қатал, ал жаз мезгілдері әрдайым жылы әрі қолайлы.", R.drawable.p1, LatLng(48.74195068839869, 85.76325780568155)),
        Place(2, "АЛТАЙ МЕМЛЕКЕТТІК ТАБИҒИ ҚОРЫҒЫ", 5.0, "Шығыс Қазақстан облысы", "Риддер қаласының жанында 1992 жылы құрылған Батыс Алтайдың мемлекеттік табиғи қорығы орналасқан. Қорық аумағында төрт негізгі табиғи зоналар ерекшеленеді: тау шалғындары, тайга және тундра, сондай-ақ, кішігірім ормандар түріндегі олардың жапырақты нұсқалары. Әрбір аймақ өсімдік әлемінің өз түрлерімен сипатталады. Мысалы, қарағай мен балқарағай ормандары тайгаға тиесіл, ал жапырақты ағаштардан мұнда бұталар, теректер және шие қопалары өседі. Сонымен бірге, мұнда ғажайып жануарлар әлемінің әртүрлі өкілдерін кездестіру мүмкін: маралдарды, бұғыларды, еліктерді, ал құстардан - бүркітті, сұңқарды мен қара дегелек құсын кездестіре аласыз. Батыс Алтай мемлекеттік қорығының аумағында өздігінен немесе экскурсиялық топтың құрамында жетуге болатын мәдени-тарихи ескерткіштер бар. Қорық қызметкерлері биологиялық қорларды сақтауға және дамытуға ат салысуда, қызықты экскурсиялар өткізіп, келушілерді Шығыс Қазақстан табиғатымен таныстыруға тырысады.", R.drawable.p2, LatLng(50.36802819172949, 83.94807935980842)),
        Place(3, "ҚОЗЫ КӨРПЕШ – БАЯН СҰЛУ МАЗАРЫ", 4.0, "Шығыс Қазақстан облысы", "Қозы Көрпеш пен Баян сұлу мазары Қазақстанның жалпыұлттық киелі орындары тізіміне алғашқылардың бірі болып енгізілген. Көне түркі дәуірінен бастау алып, аңызға айналған бұл махаббат оқиғасы толассыз ғасырлар сынынан өтіп, халық жадында мәңгіге сақталмақ.", R.drawable.p3, LatLng(47.29464141297105, 79.70475430697985)),
        Place(4, "КАТОНҚАРАҒАЙ ҰЛТТЫҚ ПАРКІ", 5.0, "Шығыс Қазақстан облысы", "2001 жылы құрылған Катонқарағай ұлттық табиғи саябағы Қазақстанда ең үлкен табиғи саябақ атағына ие. Оның ауданы 640 мың гектардан асады, ал аумақта бар әртүрлі флора мен фауналар өкілдерінің арасында Қызыл кітапқа енгізілген түрлер де бар. Мемлекеттік ескерткіштерге айналған жергілікті көрікті орындар: Рахман бұлақтары, Мұзтау тауы, Көккөл сарқырамасы, Берел қорғандары. Саябақтың негізгі жұмыс бағыттары: биологиялық қор мен аймақтың алуантүрлілігін сақтау, табиғи үдерістер мен объектілерді зерттеу, экскурсиялық іс-шараларды ұйымдастыру, Шығыс Қазақстан облысының азаматтарын және қонақтарын экологиялық ағартушылыққа итермелеу.", R.drawable.p4, LatLng(49.17563339163241, 85.60487080688823)),
        Place(5, "АЛАКӨЛ", 5.0, "Шығыс Қазақстан облысы", "Бұл ағынсыз көл орта ғасырлардың өзінде жұртшылыққа жария болған. Ұлы Жібек жолының бір тармағы осы маңнан өткендіктен, саяхат қиындығынан қажыған жиһанкездер Алакөл жағасында аялдап, келер қашықтықты еңсермекке күш-қуат жинап алмай ары қарай аттанбаған. Ежелден-ақ көпшіліктің көзі жеткен көлдің кереметін кейінгінің ғалымдары зерттеулерімен дәлелдеп келеді. Алакөлдің оңтүстік бөлігінің суы тұщы, ал солтүстік бөлігі жерасты минералды су көздерімен қоректенетіндіктен, тұзды әрі шипалы болып келеді. Көл аралдарында Алакөл мемлекеттік қорығы ұйымдастырылған. Алакөлге ден мен жан саулығын қалыпқа келтіріп, қала қарбаласынан тыным тауып, даланың еркін желіне бой сергітпек жандар ұмтылады. Осынау ұмтылысты толықтай қанағаттандырарлық жағдай Алакөлде толықтай жасалған: түрлі қонақ үйлер мен демалыс орталықтары, жайлы жағажай, белсенді демалыс орындары жетерлік.\n" +
                "\n", R.drawable.p5, LatLng(46.24771161811047, 81.56326600858941)),
    )
    private var currentLocationIndex = 0

    override fun onBindView() {
        super.onBindView()
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.zoomIn.setOnClickListener {
            mMap.animateCamera(CameraUpdateFactory.zoomIn())
        }

        binding.zoomOut.setOnClickListener {
            mMap.animateCamera(CameraUpdateFactory.zoomOut())
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val zoomLevel = 11.0f

        locations.forEach { location ->
            val marker = mMap.addMarker(MarkerOptions().position(location.latLng).title(location.name))
            marker?.tag = location
        }

        mMap.setOnMarkerClickListener { marker ->
            val location = marker.tag as? Place
            location?.let {
                showBottomSheet(it)
            }
            true // Return true to indicate that we have consumed the event and no further processing is required.
        }

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(locations[0].latLng, zoomLevel))

        setupNavigationControls()
    }
    private fun showBottomSheet(location: Place) {
        val bottomSheetFragment = MapBottomSheetFragment().apply {
            arguments = Bundle().apply {
                putParcelable("location", location)
            }
        }
        bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
    }

    private fun setupNavigationControls() {
        binding.nextLocationButton.setOnClickListener {
            navigateToNextLocation()
        }
        binding.previousLocationButton.setOnClickListener {
            navigateToPreviousLocation()
        }
    }

    private fun navigateToPreviousLocation() {
        currentLocationIndex = if (currentLocationIndex > 0) currentLocationIndex - 1 else locations.size - 1
        moveCameraToLocationIndex(currentLocationIndex)
    }

    private fun navigateToNextLocation() {
        currentLocationIndex = (currentLocationIndex + 1) % locations.size
        moveCameraToLocationIndex(currentLocationIndex)
    }

    private fun moveCameraToLocationIndex(index: Int, zoomLevel: Float = 11.0f) {
        if (index in locations.indices) {
            val location = locations[index]
            val targetLatLng = location.latLng
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(targetLatLng, zoomLevel))
        } else {
            Log.e("MapFragment", "Index out of bounds: $index")
        }
    }
}