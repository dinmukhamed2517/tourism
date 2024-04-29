package kz.sdk.tourism.fragments

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import kz.sd.shop.firebase.UserDao
import kz.sdk.tourism.base.BaseFragment
import kz.sdk.tourism.databinding.FragmentProductDetailsBinding
import javax.inject.Inject


@AndroidEntryPoint
class ProductDetailsFragment:BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {
    private val args:ProductDetailsFragmentArgs by navArgs()

    @Inject
    lateinit var userDao: UserDao
    @Inject
    lateinit var firebaseAuth: FirebaseAuth
    private var totalBonus:Float?  = 0f
    override fun onBindView() {
        userDao.getData()
        super.onBindView()
        val product = args.product
        with(binding){
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }

            title.text = product.title
            product.img?.let { imageView3.setImageResource(it) }
            price.text = product.price.toString()+" KZT"
            description.text = product.description

            buyBtn.setOnClickListener {
                if(totalBonus!! >= product.price){
                    userDao.saveBonus(product.price - totalBonus!!)
                    showCustomDialog("Поздравляю", "Вы успешно купили")
                }
                else{
                    showCustomCancelDialog("Ошибка", "У вас недостаточно средтсв")
                }
            }
            userDao.getDataLiveData.observe(this@ProductDetailsFragment){
                totalBonus = it?.bonus
            }
        }
    }
}