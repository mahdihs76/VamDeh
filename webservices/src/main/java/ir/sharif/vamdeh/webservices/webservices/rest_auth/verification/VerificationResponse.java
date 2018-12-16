package ir.sharif.vamdeh.webservices.webservices.rest_auth.verification;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseResponse;

public class VerificationResponse extends BaseResponse {

    @SerializedName("key")
    private String key;

    public VerificationResponse(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }
}
