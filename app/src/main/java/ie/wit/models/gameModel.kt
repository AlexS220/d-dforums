package ie.wit.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class gameModel(var id: Long=0,
                    var title: String = "",
                     var day: String = "",
                     var time: String = "",
                    var description: String = "",
                    var system: String ="") : Parcelable