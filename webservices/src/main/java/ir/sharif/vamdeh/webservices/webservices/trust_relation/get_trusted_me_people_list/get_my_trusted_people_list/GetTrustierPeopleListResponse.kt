package ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trusted_me_people_list.get_my_trusted_people_list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import ir.sharif.vamdeh.webservices.base.BaseResponse
import ir.sharif.vamdeh.webservices.webservices.models.User

data class GetTrustierPeopleListResponse(@SerializedName("trustier") @Expose val trustierUser: User,
                                         @SerializedName("is_trust_request") @Expose val isTrustRequest: Boolean,
                                         @SerializedName("request_time") @Expose val requestTime: String) : BaseResponse()
