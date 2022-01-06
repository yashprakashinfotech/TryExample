package com.yash.tryexample

import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("createdAtString"        ) var createdAtString        : String? = null,
    @SerializedName("iconClass"              ) var iconClass              : String? = null,
    @SerializedName("professionalsFormatted" ) var professionalsFormatted : String? = null,
    @SerializedName("s3TempPath"             ) var s3TempPath             : String? = null,
    @SerializedName("sharedProfessionals"    ) var sharedProfessionals    : String? = null,
    @SerializedName("id"                     ) var id                     : String? = null,
    @SerializedName("userId"                 ) var userId                 : String? = null,
    @SerializedName("fileName"               ) var fileName               : String? = null,
    @SerializedName("displayName"            ) var displayName            : String? = null,
    @SerializedName("mime"                   ) var mime                   : String? = null,
    @SerializedName("size"                   ) var size                   : Int?    = null,
    @SerializedName("createdAt"              ) var createdAt              : String? = null


)
