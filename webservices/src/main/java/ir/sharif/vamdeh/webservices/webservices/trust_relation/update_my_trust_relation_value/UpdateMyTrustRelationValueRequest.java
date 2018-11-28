package ir.sharif.vamdeh.webservices.webservices.trust_relation.update_my_trust_relation_value;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class UpdateMyTrustRelationValueRequest extends BaseRequest {

    @SerializedName("id")
    private int id;
    @SerializedName("active_trust_value")
    private int activeTrustValue;

    public UpdateMyTrustRelationValueRequest(int id, int activeTrustValue) {
        this.id = id;
        this.activeTrustValue = activeTrustValue;
    }
}
