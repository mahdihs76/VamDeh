//package ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust;
//
//import java.io.IOException;
//
//import ir.sharif.vamdeh.webservices.base.BaseProcess;
//import ir.sharif.vamdeh.webservices.base.MyRetrofit;
//import ir.sharif.vamdeh.webservices.base.WebserviceException;
//
//public class CreateTrustRequestAsTrustedProcess extends BaseProcess {
//    private CreateTrustRequestAsTrustedRequest request;
//
//    public CreateTrustRequestAsTrustedProcess(String phoneNumber) {
//        this.request = new CreateTrustRequestAsTrustedRequest(phoneNumber);
//    }
//
//    @Override
//    public CreateTrustResponse process() throws IOException, WebserviceException {
//        return send(MyRetrofit.getInstance().getWebserviceUrls().createTrustRequest(request));
//    }
//}
