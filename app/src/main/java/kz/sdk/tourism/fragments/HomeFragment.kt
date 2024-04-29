package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.model.LatLng
import kz.sdk.tourism.R
import kz.sdk.tourism.adapters.PlaceAdapter
import kz.sdk.tourism.adapters.ProductAdapter
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentHomeBinding
import kz.sdk.tourism.models.Place
import kz.sdk.tourism.models.Product

class HomeFragment: BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        val adapter1 = PlaceAdapter()
        val adapter2 = ProductAdapter()
        with(binding){
            recycler1.adapter =adapter1
            recycler1.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

            recycler2.adapter = adapter2
            recycler2.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter1.submitList(getPlaces())
            adapter2.submitList(getProducts())
            searchBtn.setOnClickListener {
                findNavController().navigate(
                    R.id.action_homeFragment_to_searchFragment
                )
            }
        }
        adapter1.itemClick = {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToPlaceDetailsFragment(it))
        }
        adapter2.itemClick = {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToProductDetailsFragment(it))
        }
    }

    fun getPlaces():List<Place>{
        return listOf(
            Place(1, "МАРҚАКӨЛ КӨЛІ", 4.5, "Шығыс Қазақстан облысы", getString(R.string.p1), R.drawable.p1, LatLng(48.74195068839869, 85.76325780568155)),
            Place(2, "АЛТАЙ МЕМЛЕКЕТТІК ТАБИҒИ ҚОРЫҒЫ", 5.0, "Шығыс Қазақстан облысы", getString(R.string.p2), R.drawable.p2, LatLng(50.36802819172949, 83.94807935980842)),
            Place(3, "ҚОЗЫ КӨРПЕШ – БАЯН СҰЛУ МАЗАРЫ", 4.0, "Шығыс Қазақстан облысы", getString(R.string.p3), R.drawable.p3, LatLng(47.29464141297105, 79.70475430697985)),
            Place(4, "КАТОНҚАРАҒАЙ ҰЛТТЫҚ ПАРКІ", 5.0, "Шығыс Қазақстан облысы", getString(R.string.p4), R.drawable.p4, LatLng(49.17563339163241, 85.60487080688823)),
            Place(5, "АЛАКӨЛ", 5.0, "Шығыс Қазақстан облысы", getString(R.string.p5), R.drawable.p5, LatLng(46.24771161811047, 81.56326600858941)),
        )
    }
    fun getProducts():List<Product>{
        return listOf(
            Product(1, "Юрта ручная работа", R.drawable.pr1, 500.0f, " Юрта из войлока выполнена из экологически чистого 100% войлока, она станет прекрасным дополнением к Вашему интерьеру или игрушкой для детей. Войлок помогает развивать у детей тактильные ощущения. Изделия из войлока не вызывают раздражения и аллергии. Юрта украшены вышивкой, выполнена в национальном стиле." ),
            Product(2, "Панно ручная работа", R.drawable.pr2, 1500.0f, "Многие тысячелетия натуральная кожа цениться за свои уникальные качества и ни один другой материал не сравним с ней. Изделия из натуральной кожи являются идеальным вариантом для пошива одежды, обуви и аксессуаров. Они обладают такими особенностями как прочность, эластичность, практичность, долговечность и устойчивость к разным повреждениям. В современном мире натуральная кожа – это ценный материал, область применения которого очень широк и разнообразен."),
            Product(3, "Картина \"Эне\"", R.drawable.pr3, 2500.0f, "Оригинальная и необычная картина из кожи, с нанесенным на нее изображением высокогорного Жайлоо и семьи: женщины и ребенка - это замечательный памятный подарок, содержащий в себе частичку Кыргызстана. Изображение, нанесено с помощью специальной технологии, которая делает картину объемной. Рама выполнена из дерева.\n" +
                    "Такая картина станет прекрасным украшением гостиной или кабинета."),
            Product(4, "Монета сувенирная ", R.drawable.pr4, 1500.0f, "Коллекционировать монеты люди начали еще с момента их появления. Для кого-то это стало  настоящей страстью, любимым делом. Для людей коллекционирующих монеты нет лучше подарка чем красивая, необычная, редкая монета."),


        )
    }

}