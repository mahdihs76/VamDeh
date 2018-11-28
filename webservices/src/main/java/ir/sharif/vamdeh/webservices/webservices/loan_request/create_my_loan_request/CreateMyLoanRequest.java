package ir.sharif.vamdeh.webservices.webservices.loan_request.create_my_loan_request;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class CreateMyLoanRequest extends BaseRequest {
    @SerializedName("status")
    private String status;
    @SerializedName("amount")
    private int amount;
    @SerializedName("time_to_return_money")
    private int timeToReturnMoney;
    @SerializedName("requester")
    private int requester;
    @SerializedName("id")
    private int id;

    public CreateMyLoanRequest(String status, int amount, int timeToReturnMoney, int requester, int id) {
        this.status = status;
        this.amount = amount;
        this.timeToReturnMoney = timeToReturnMoney;
        this.requester = requester;
        this.id = id;
    }
}
