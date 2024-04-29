package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentLevel1Binding

class Level1Fragment:BaseFragment<FragmentLevel1Binding>(FragmentLevel1Binding::inflate) {
    override fun onBindView() {
        super.onBindView()
        with(binding){
            answerA.setOnClickListener{
                showCustomCancelDialog("Неправильно", "Попробуйте снова")
            }
            answerB.setOnClickListener {
                findNavController().navigate(R.id.action_level1Fragment_to_level1ResultFragment)
            }
            answerC.setOnClickListener {
                showCustomCancelDialog("Неправильно", "Попробуйте снова")
            }
        }
    }

}