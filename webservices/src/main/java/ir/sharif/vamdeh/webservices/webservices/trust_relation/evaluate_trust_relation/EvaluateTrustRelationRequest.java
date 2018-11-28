package ir.sharif.vamdeh.webservices.webservices.trust_relation.evaluate_trust_relation;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class EvaluateTrustRelationRequest extends BaseRequest {
    @SerializedName("trusted")
    private int trusted;
    @SerializedName("active_trust_value")
    private int activeTrustValue;
    @SerializedName("id")
    private int id;

    public EvaluateTrustRelationRequest(int trusted, int activeTrustValue, int id) {
        this.trusted = trusted;
        this.activeTrustValue = activeTrustValue;
        this.id = id;
    }
}
