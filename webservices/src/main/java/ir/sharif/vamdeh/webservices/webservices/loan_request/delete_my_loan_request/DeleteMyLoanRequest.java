package ir.sharif.vamdeh.webservices.webservices.loan_request.delete_my_loan_request;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class DeleteMyLoanRequest  extends BaseRequest {
    @SerializedName("id")
    private int id;

    public DeleteMyLoanRequest(int id) {
        this.id = id;
    }
}
