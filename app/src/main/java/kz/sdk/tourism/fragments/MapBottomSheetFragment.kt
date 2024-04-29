package kz.sdk.tourism.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kz.sdk.tourism.databinding.FragmentMapBottomSheetBinding
import kz.sdk.tourism.models.Place

class MapBottomSheetFragment:BottomSheetDialogFragment() {
    private lateinit var binding: FragmentMapBottomSheetBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMapBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val location = arguments?.getParcelable<Place>("location")
        location?.let {
            binding.locationName.text = it.name
            binding.locationDescription.text = it.description
            it.img?.let { it1 -> binding.img.setImageResource(it1) }
        }
    }
}