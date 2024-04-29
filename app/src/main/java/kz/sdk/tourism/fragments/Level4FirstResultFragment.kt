package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentLevel4FirstResultBinding

class Level4FirstResultFragment:BaseFragment<FragmentLevel4FirstResultBinding>(FragmentLevel4FirstResultBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_level4FirstResultFragment_to_level4SecondFragment)
        }
    }

}