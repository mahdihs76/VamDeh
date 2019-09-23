package ir.sharif.vamdeh.webservices.webservices.profile.get_my_profile_user

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import ir.sharif.vamdeh.webservices.base.BaseResponse

class GetMyProfileUserResponse(@SerializedName("app_user") @Expose val phoneNumber: String,
                               @SerializedName("national_id") @Expose val nationalId: String,
                               @SerializedName("nickname") @Expose val nickName: String,
                               @SerializedName("bank_card_number") @Expose val cardNo: String,
                               @SerializedName("sheba_number") @Expose val shebaNo: String,
                               @SerializedName("account_number") @Expose val accountNo: String) : BaseResponse()
