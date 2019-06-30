package ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust_request_as_trustier;

import java.io.IOException;
import java.util.List;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class CreateTrustRequestAsTrustierProcess extends BaseProcess {
    private CreateTrustRequestAsTrustierRequest request;
    public CreateTrustRequestAsTrustierProcess(String phoneNumber, int trustValue) {
        request = new CreateTrustRequestAsTrustierRequest(phoneNumber, trustValue);
    }

    @Override
    public CreateTrustRequestAsTrustierResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().createTrustRequestAsTrustier(request));
    }
}
