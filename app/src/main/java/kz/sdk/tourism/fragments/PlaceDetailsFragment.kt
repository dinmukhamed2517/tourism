package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentPlaceDetailsBinding
import kz.sdk.tourism.fragments.PlaceDetailsFragmentArgs
import kz.sdk.tourism.models.Place


class PlaceDetailsFragment:BaseFragment<FragmentPlaceDetailsBinding>(FragmentPlaceDetailsBinding::inflate) {

    private val args: PlaceDetailsFragmentArgs by navArgs()
    override fun onBindView() {
        super.onBindView()
        val place = args.place
        with(binding){
            title.text = place.name
            rating.text = place.rating.toString()
            img.setImageResource(place?.img!!)
            description.text = place.description
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }
        }

    }
}