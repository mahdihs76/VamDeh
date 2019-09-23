package ir.sharif.vamdeh.webservices.webservices.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(@SerializedName("mobile_phone_number") @Expose val mobilePhoneNumber: String,
                @SerializedName("profile") @Expose var profile: Profile? = null,
                @SerializedName("is_registered") @Expose val isRegistered: Boolean)