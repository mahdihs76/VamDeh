package ir.sharif.vamdeh.webservices.webservices.trust_relation.get_my_trusted_people_list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import ir.sharif.vamdeh.webservices.base.BaseResponse
import ir.sharif.vamdeh.webservices.webservices.models.User

data class GetMyTrustedPeopleListResponse(@SerializedName("trusted") @Expose val user: User,
                                          @SerializedName("is_trust_request") @Expose val isTrustRequest: Boolean,
                                          @SerializedName("active_trust_value") @Expose val trustValue: Int,
                                          @SerializedName("description") @Expose val description: String,
                                          @SerializedName("status") @Expose val status: String,
                                          @SerializedName("request_time") @Expose val requestTime: String) : BaseResponse()
