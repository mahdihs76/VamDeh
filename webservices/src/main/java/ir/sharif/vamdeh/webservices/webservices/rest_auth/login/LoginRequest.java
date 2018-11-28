package ir.sharif.vamdeh.webservices.webservices.rest_auth.login;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class LoginRequest extends BaseRequest {
    @SerializedName("username")
    private String userName;
    @SerializedName("password")
    private String password;

    public LoginRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
