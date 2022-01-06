package com.yash.tryexample

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class AttachmentData(
    @SerializedName("results"    ) var results    : ArrayList<Results> = arrayListOf(),
    @SerializedName("status"     ) var status     : Int?               = null,
    @SerializedName("message"    ) var message    : String?            = null,
    @SerializedName("dataString" ) var dataString : String?            = null
)