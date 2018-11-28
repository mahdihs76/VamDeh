package ir.sharif.vamdeh.webservices.webservices.rest_auth.registration;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseResponse;

public class RegistrationResponse extends BaseResponse {
    @SerializedName("key")
    private String key;

    public RegistrationResponse(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
