package ir.sharif.vamdeh.webservices.webservices.rest_auth.verification;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class VerificationRequest extends BaseRequest {
    @SerializedName("username")
    private String userName;

    public VerificationRequest(String userName) {
        this.userName = userName;
    }
}
