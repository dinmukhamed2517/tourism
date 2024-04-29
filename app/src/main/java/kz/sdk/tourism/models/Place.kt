package kz.sdk.tourism.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.google.android.gms.maps.model.LatLng
import kotlinx.parcelize.Parcelize

@Parcelize
data class Place(
    val id:Int? = null,
    val name:String? = null,
    val rating:Double? = null,
    val address:String? = null,
    val description:String? = null,
    @DrawableRes
    val img:Int? = null,
    val latLng: LatLng,
    ):Parcelable
