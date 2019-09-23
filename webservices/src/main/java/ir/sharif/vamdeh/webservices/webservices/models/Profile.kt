package ir.sharif.vamdeh.webservices.webservices.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Profile(@SerializedName("nickname") @Expose val nickName: String,
                   @SerializedName("avatar") @Expose var avatar: String? = null)