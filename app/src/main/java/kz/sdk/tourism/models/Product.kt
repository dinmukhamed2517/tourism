package kz.sdk.tourism.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    var id:Int? = null,
    var title:String? = null,
    @DrawableRes
    var img:Int? = null,
    var price:Float,
    var description:String? = null,
): Parcelable