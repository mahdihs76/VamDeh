package ir.sharif.vamdeh.webservices.webservices.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class TrustedUser(@SerializedName("mobile_phone_number") @Expose val mobilePhoneNumber: String,
                       @SerializedName("user") @Expose val user: User,
                       @SerializedName("is_registered") @Expose val isRegistered: Boolean)