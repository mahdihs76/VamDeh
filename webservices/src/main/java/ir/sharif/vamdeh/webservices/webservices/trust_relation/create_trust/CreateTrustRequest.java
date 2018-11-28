package ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class CreateTrustRequest extends BaseRequest {
  @SerializedName("trustier")  private int trustier;

    public CreateTrustRequest(int trustier) {
        this.trustier = trustier;
    }
}
