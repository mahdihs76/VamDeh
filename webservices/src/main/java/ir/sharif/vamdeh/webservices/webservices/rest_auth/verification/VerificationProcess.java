package ir.sharif.vamdeh.webservices.webservices.rest_auth.verification;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;
import retrofit2.Call;

public class VerificationProcess extends BaseProcess {
    private VerificationRequest request;

    public VerificationProcess(String phoneNumber) {
        this.request = new VerificationRequest(phoneNumber);
    }

    @Override
    public VerificationResponse process() throws IOException, WebserviceException {
        Call<VerificationResponse> verification = MyRetrofit.getInstance().getWebserviceUrls().verification(request);
        return send(verification);
    }
}
