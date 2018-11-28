package ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trust_requests_as_acceptor;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.base.TrustObject;

public class GetTrustRequestsAsAcceptorResponse extends BaseResponse {
     @SerializedName("id")
        private String id;
        @SerializedName("trustier")
        private TrustObject trustier;
        @SerializedName("trusted")
        private TrustObject trusted;
        @SerializedName("is_trust_request")
        private boolean isTrustRequest;
        @SerializedName("status")
        private String status;
        @SerializedName("is_active")
        private boolean isActive;
        @SerializedName("active_trust_value")
        private int activeTrustValue;
        @SerializedName("description")
        private String description;
        @SerializedName("request_time")
        private String requestTime;
        @SerializedName("has_graph_edge")
        private boolean hasGraphEdge;


        public GetTrustRequestsAsAcceptorResponse(String id, TrustObject trustier, TrustObject trusted, boolean isTrustRequest, String status, boolean isActive, int activeTrustValue, String description, String requestTime, boolean hasGraphEdge) {
            this.id = id;
            this.trustier = trustier;
            this.trusted = trusted;
            this.isTrustRequest = isTrustRequest;
            this.status = status;
            this.isActive = isActive;
            this.activeTrustValue = activeTrustValue;
            this.description = description;
            this.requestTime = requestTime;
            this.hasGraphEdge = hasGraphEdge;
        }

        public String getId() {
            return id;
        }

        public TrustObject getTrustier() {
            return trustier;
        }

        public TrustObject getTrusted() {
            return trusted;
        }

        public boolean isTrustRequest() {
            return isTrustRequest;
        }

        public String getStatus() {
            return status;
        }

        public boolean isActive() {
            return isActive;
        }

        public int getActiveTrustValue() {
            return activeTrustValue;
        }

        public String getDescription() {
            return description;
        }

        public String getRequestTime() {
            return requestTime;
        }

        public boolean isHasGraphEdge() {
            return hasGraphEdge;
        }

}
