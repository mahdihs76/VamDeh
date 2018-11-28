package ir.sharif.vamdeh.webservices.webservices.rest_auth.login;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseResponse;

public class LoginResponse extends BaseResponse {

    @SerializedName("key")
    private String key;

    public LoginResponse(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
