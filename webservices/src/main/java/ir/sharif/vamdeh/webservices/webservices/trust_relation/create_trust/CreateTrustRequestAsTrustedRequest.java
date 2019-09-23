package ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class CreateTrustRequestAsTrustedRequest extends BaseRequest {
  @SerializedName("trustier_mobile_number")  private String phoneNumber;

    public CreateTrustRequestAsTrustedRequest(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
