package ir.sharif.vamdeh.webservices.webservices.rest_auth.verification;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class VerificationRequest extends BaseRequest {
    @SerializedName("mobile_phone_number")
    private String phoneNumber;

    public VerificationRequest(String userName) {
        this.phoneNumber = userName;
    }
}
