package ir.sharif.vamdeh.webservices.webservices.loan_request.create_my_loan_request

import com.google.gson.annotations.SerializedName

import ir.sharif.vamdeh.webservices.base.BaseRequest

class CreateMyLoanRequest(@field:SerializedName("amount") private val amount: Int,
                          @field:SerializedName("time_to_return_money") private val timeToReturnMoney: Int,
                          @field:SerializedName("status") private val status: String) : BaseRequest()
