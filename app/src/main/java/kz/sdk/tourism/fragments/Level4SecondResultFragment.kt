package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kz.sd.shop.firebase.UserDao
import kz.sdk.tourism.R
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentLevel4SecondResultBinding
import javax.inject.Inject


@AndroidEntryPoint
class Level4SecondResultFragment:BaseFragment<FragmentLevel4SecondResultBinding>(FragmentLevel4SecondResultBinding::inflate) {
    @Inject
    lateinit var firebaseAuth: FirebaseAuth

    @Inject
    lateinit var userDao: UserDao
    override fun onBindView() {
        super.onBindView()
        binding.nextBtn.setOnClickListener {
            findNavController().navigate(R.id.action_level4SecondResultFragment_to_questFragment)
            showCustomDialog("Позравляю", "Вы получили 1000 бонусов")
            userDao.saveBonus(1000.0f)
        }
    }

}