package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentLevel1ResultBinding

class Level1ResultFragment:BaseFragment<FragmentLevel1ResultBinding>(FragmentLevel1ResultBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_level1ResultFragment_to_questFragment)
        }
    }

}