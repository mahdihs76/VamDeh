package ir.sharif.vamdeh.webservices.webservices.rest_auth.login;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class LoginRequest extends BaseRequest {
    @SerializedName("username")
    private String phoneNumber;
    @SerializedName("password")
    private String password;

    public LoginRequest(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
