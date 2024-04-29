package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentLevel4FirstBinding

class Level4FirstFragment:BaseFragment<FragmentLevel4FirstBinding>(FragmentLevel4FirstBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        super.onBindView()
        binding.answerA.setOnClickListener {
            findNavController().navigate(R.id.action_level4FirstFragment_to_level4FirstResultFragment)

        }
        binding.answerB.setOnClickListener {
            showCustomCancelDialog("Неправильно", "Попробуйте снова")

        }
        binding.answerC.setOnClickListener {
            showCustomCancelDialog("Неправильно", "Попробуйте снова")
        }
    }

}