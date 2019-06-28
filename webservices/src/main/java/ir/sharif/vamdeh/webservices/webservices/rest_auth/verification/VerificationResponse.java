package ir.sharif.vamdeh.webservices.webservices.rest_auth.verification;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseResponse;

public class VerificationResponse extends BaseResponse {

    @SerializedName("token")
    private String token;
    @SerializedName("registered_user")
    private boolean registeredUser;

    VerificationResponse(String token, boolean registeredUser){
        this.token = token;
        this.registeredUser = registeredUser;
    }

    public String getToken() {
        return token;
    }

    public boolean isRegisteredUser() {
        return registeredUser;
    }
}
