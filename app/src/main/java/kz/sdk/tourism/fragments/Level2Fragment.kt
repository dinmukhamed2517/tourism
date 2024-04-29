package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentLevel2Binding

class Level2Fragment:BaseFragment<FragmentLevel2Binding>(FragmentLevel2Binding::inflate) {
    override fun onBindView() {
        super.onBindView()
        binding.answerA.setOnClickListener {
            showCustomCancelDialog("Неправильно", "Попробуйте снова")


        }
        binding.answerB.setOnClickListener {
            showCustomCancelDialog("Неправильно", "Попробуйте снова")



        }
        binding.answerC.setOnClickListener {
            findNavController().navigate(R.id.action_level2Fragment_to_level2ResultFragment)
        }
    }

}