package ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trust_requests_as_acceptor;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class GetTrustRequestsAsAcceptorProcess extends BaseProcess {
    @Override
    public GetTrustRequestsAsAcceptorResponse[] process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().getTrustRequestsAsAcceptor());
    }
}
