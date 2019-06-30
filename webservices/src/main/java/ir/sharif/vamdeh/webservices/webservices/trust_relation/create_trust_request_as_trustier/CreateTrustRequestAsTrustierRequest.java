package ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust_request_as_trustier;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.BaseRequest;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class CreateTrustRequestAsTrustierRequest extends BaseRequest {
    @SerializedName("trusted_mobile_number")
    private String phoneNumber;
    @SerializedName("active_trust_value")
    private int trustValue;

    CreateTrustRequestAsTrustierRequest(String phoneNumber, int trustValue) {
        this.phoneNumber = phoneNumber;
        this.trustValue = trustValue;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getTrustValue() {
        return trustValue;
    }
}
