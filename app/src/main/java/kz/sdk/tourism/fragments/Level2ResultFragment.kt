package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentLevel2ResultBinding

class Level2ResultFragment:BaseFragment<FragmentLevel2ResultBinding>(FragmentLevel2ResultBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_level2ResultFragment_to_questFragment)
        }
    }
}