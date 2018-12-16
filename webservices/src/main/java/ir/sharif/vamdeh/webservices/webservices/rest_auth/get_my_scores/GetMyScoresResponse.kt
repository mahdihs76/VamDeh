package ir.sharif.vamdeh.webservices.webservices.rest_auth.get_my_scores

import com.google.gson.annotations.SerializedName

import ir.sharif.vamdeh.webservices.base.BaseResponse

class GetMyScoresResponse(@field:SerializedName("total_rate") val totalRate: Int,
                          @field:SerializedName("sweat_heart_rate") val sweatHeartRate: Int,
                          @field:SerializedName("loan_rate") val loanRate: Int) : BaseResponse()
