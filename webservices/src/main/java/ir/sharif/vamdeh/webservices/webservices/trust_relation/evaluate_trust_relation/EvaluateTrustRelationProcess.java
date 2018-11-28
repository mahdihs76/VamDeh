package ir.sharif.vamdeh.webservices.webservices.trust_relation.evaluate_trust_relation;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class EvaluateTrustRelationProcess extends BaseProcess {

    private EvaluateTrustRelationRequest request;

    public EvaluateTrustRelationProcess(int trusted, int activeTrustValue, int id) {
        this.request = new EvaluateTrustRelationRequest(trusted, activeTrustValue, id);
    }

    @Override
    public EvaluateTrustRelationResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().evaluateTrustRelation(request));
    }
}
