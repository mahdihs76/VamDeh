package ir.sharif.vamdeh.webservices.webservices.trust_relation.get_my_trusted_people_list

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

import ir.sharif.vamdeh.webservices.base.BaseResponse
import ir.sharif.vamdeh.webservices.webservices.models.TrustedUser

data class GetMyTrustedPeopleListResponse(@SerializedName("trusted") @Expose val trustedUser: TrustedUser) : BaseResponse()