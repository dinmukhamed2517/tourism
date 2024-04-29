package kz.sdk.tourism.fragments

import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.model.LatLng
import kz.sdk.tourism.R
import kz.sdk.tourism.adapters.PlaceAdapter
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentSearchBinding
import kz.sdk.tourism.models.Place

class SearchFragment:BaseFragment<FragmentSearchBinding>(FragmentSearchBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        val adapter = PlaceAdapter()
        binding.recycler.adapter =adapter

        adapter.itemClick = {
            findNavController().navigate(
                SearchFragmentDirections.actionSearchFragmentToPlaceDetailsFragment(it)
            )
        }
        binding.backBtn.setOnClickListener {
            findNavController().navigate(
                R.id.action_searchFragment_to_homeFragment
            )
        }
        binding.recycler.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.editText.setOnEditorActionListener(TextView.OnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH){
                if(binding.editText.text!!.isNotEmpty()){
                    adapter.submitList(searchProduct(binding.editText.text.toString()))
                }
                else{
                    Toast.makeText(requireContext(), "Введите название товара", Toast.LENGTH_SHORT).show()
                }
            }
            false
        })
    }

    fun searchProduct(input:String):List<Place>{
        val products = getList()
        return products.filter { product ->
            product.name!!.contains(input, ignoreCase = true)
        }
    }

    fun getList(): List<Place> {
        return listOf(
            Place(1, "МАРҚАКӨЛ КӨЛІ", 4.5, "Шығыс Қазақстан облысы", getString(R.string.p1), R.drawable.p1, LatLng(48.74195068839869, 85.76325780568155)),
            Place(2, "АЛТАЙ МЕМЛЕКЕТТІК ТАБИҒИ ҚОРЫҒЫ", 5.0, "Шығыс Қазақстан облысы", getString(R.string.p2), R.drawable.p2, LatLng(50.36802819172949, 83.94807935980842)),
            Place(3, "ҚОЗЫ КӨРПЕШ – БАЯН СҰЛУ МАЗАРЫ", 4.0, "Шығыс Қазақстан облысы", getString(R.string.p3), R.drawable.p3, LatLng(47.29464141297105, 79.70475430697985)),
            Place(4, "КАТОНҚАРАҒАЙ ҰЛТТЫҚ ПАРКІ", 5.0, "Шығыс Қазақстан облысы", getString(R.string.p4), R.drawable.p4, LatLng(49.17563339163241, 85.60487080688823)),
            Place(5, "АЛАКӨЛ", 5.0, "Шығыс Қазақстан облысы", getString(R.string.p5), R.drawable.p5, LatLng(46.24771161811047, 81.56326600858941)),
        )
    }
}