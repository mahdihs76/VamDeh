package ir.sharif.vamdeh.webservices.webservices.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(@SerializedName("first_name") @Expose val firstName: String,
                @SerializedName("last_name") @Expose val lastName: String,
                @SerializedName("email") @Expose val email: String)