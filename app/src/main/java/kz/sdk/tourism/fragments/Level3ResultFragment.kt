package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentLevel3ResultBinding

class Level3ResultFragment:BaseFragment<FragmentLevel3ResultBinding>(FragmentLevel3ResultBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_level3ResultFragment_to_questFragment)
        }
    }
}