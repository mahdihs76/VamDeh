package ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trust_requests_as_requeser;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class GetTrustRequestsAsRequesterProcess extends BaseProcess {
    @Override
    public GetTrustRequestsAsRequesterResponse[] process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().getTrustRequestsAsRequeser());
    }
}
