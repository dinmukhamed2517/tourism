package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentLevel3Binding

class Level3Fragment:BaseFragment<FragmentLevel3Binding>(FragmentLevel3Binding::inflate) {
    override fun onBindView() {
        super.onBindView()
        binding.answerA.setOnClickListener {
            showCustomCancelDialog("Неправильно", "Попробуйте снова")
        }
        binding.answerB.setOnClickListener {
            showCustomCancelDialog("Неправильно", "Попробуйте снова")

        }
        binding.answerC.setOnClickListener {
            findNavController().navigate(R.id.action_level3Fragment_to_level3ResultFragment)
        }
    }

}