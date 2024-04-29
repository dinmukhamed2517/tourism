package kz.sdk.tourism.fragments

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentQuestBinding

class QuestFragment : BaseFragment<FragmentQuestBinding>(FragmentQuestBinding::inflate) {

    override fun onBindView() {
        super.onBindView()

        with(binding) {
            lvl1.setOnClickListener {
                findNavController().navigate(R.id.action_questFragment_to_level1Fragment)
                lvl1.backgroundTintList = ColorStateList.valueOf(Color.GREEN)
            }
            lvl2.setOnClickListener {
                findNavController().navigate(R.id.action_questFragment_to_level2Fragment)
                lvl2.backgroundTintList = ColorStateList.valueOf(Color.GREEN)

            }
            lvl3.setOnClickListener {
                findNavController().navigate(R.id.action_questFragment_to_level3Fragment)
                lvl3.backgroundTintList = ColorStateList.valueOf(Color.GREEN)

            }
            lvl4.setOnClickListener {
                findNavController().navigate(R.id.action_questFragment_to_level4FirstFragment)
                lvl4.backgroundTintList = ColorStateList.valueOf(Color.GREEN)

            }
        }
    }


}
