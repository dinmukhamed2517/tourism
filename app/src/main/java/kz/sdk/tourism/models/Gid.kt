package kz.sdk.tourism.models

import androidx.annotation.DrawableRes

data class Gid(
    var id:Int,
    var name:String,
    @DrawableRes
    var img:Int,
    var description:String,
    var price:Double,
)