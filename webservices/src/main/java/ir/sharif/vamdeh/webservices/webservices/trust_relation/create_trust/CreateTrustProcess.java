package ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class CreateTrustProcess extends BaseProcess {
    private CreateTrustRequest request;

    public CreateTrustProcess(int trust) {
        this.request = new CreateTrustRequest(trust);
    }

    @Override
    public CreateTrustResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().createTrustRequest(request));
    }
}
