package ir.sharif.vamdeh.webservices.webservices.rest_auth.send_verification_code;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseResponse;

public class SendVerificationCodeResponse extends BaseResponse {

    @SerializedName("token")
    private String token;
    @SerializedName("registered_user")
    private boolean registeredUser;

    public SendVerificationCodeResponse(String token) {
        this.token= token;
    }

    public String getToken() {
        return token;
    }

    public boolean isRegisteredUser() {
        return registeredUser;
    }
}
