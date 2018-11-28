package ir.sharif.vamdeh.webservices.webservices.loan_request.accept_loan_request;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class AcceptLoanRequest extends BaseRequest {


    @SerializedName("loan_request_id")
    private int loanRequestID;

    public AcceptLoanRequest(int loanRequestID) {
        this.loanRequestID = loanRequestID;
    }
}
