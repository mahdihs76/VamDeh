package ir.sharif.vamdeh.webservices.webservices.rest_auth.get_my_scores


import com.google.gson.annotations.SerializedName
import ir.sharif.vamdeh.webservices.base.BaseResponse

class GetMyScoresResponse(@field:SerializedName("id") val id: Int,
                          @field:SerializedName("value") val value: Int,
                          @field:SerializedName("user") val user: Int,
                          @field:SerializedName("s_type") val sType: Int) : BaseResponse()
