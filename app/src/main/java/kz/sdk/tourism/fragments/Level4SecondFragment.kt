package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentLevel4SecondBinding

class Level4SecondFragment:BaseFragment<FragmentLevel4SecondBinding>(FragmentLevel4SecondBinding::inflate) {
    override fun onBindView() {
        super.onBindView()
        super.onBindView()
        binding.answerA.setOnClickListener {
            showCustomCancelDialog("Неправильно", "Попробуйте снова")
        }
        binding.answerB.setOnClickListener {
            showCustomCancelDialog("Неправильно", "Попробуйте снова")

        }
        binding.answerC.setOnClickListener {
            findNavController().navigate(R.id.action_level4SecondFragment_to_level4SecondResultFragment)
        }
    }

}