package ir.sharif.vamdeh.webservices.webservices.trust_relation.update_my_trust_relation_value;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class UpdateMyTrustRelationValueRequest extends BaseRequest {

    @SerializedName("trusted_mobile_number")
    private String phoneNumber;
    @SerializedName("active_trust_value")
    private int activeTrustValue;

    public UpdateMyTrustRelationValueRequest(String phoneNumber, int activeTrustValue) {
        this.phoneNumber = phoneNumber;
        this.activeTrustValue = activeTrustValue;
    }
}
