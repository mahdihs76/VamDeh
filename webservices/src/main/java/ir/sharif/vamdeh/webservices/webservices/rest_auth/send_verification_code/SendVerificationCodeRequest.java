package ir.sharif.vamdeh.webservices.webservices.rest_auth.send_verification_code;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class SendVerificationCodeRequest extends BaseRequest {
    @SerializedName("username")
    private String userName;

    @SerializedName("code")
    private String code;

    public SendVerificationCodeRequest(String userName, String code) {
        this.userName = userName;
        this.code = code;
    }
}
