package ir.sharif.vamdeh.webservices.webservices.rest_auth.send_verification_code;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class SendVerificationCodeRequest extends BaseRequest {
    @SerializedName("mobile_phone_number")
    private String phoneNumber;

    @SerializedName("token")
    private String code;

    public SendVerificationCodeRequest(String phoneNumber, String code) {
        this.phoneNumber = phoneNumber;
        this.code = code;
    }
}
