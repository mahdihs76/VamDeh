package ir.sharif.vamdeh.webservices.webservices.rest_auth.send_verification_code;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;
import retrofit2.Call;

public class SendVerificationCodeProcess extends BaseProcess {
    private SendVerificationCodeRequest request;

    public SendVerificationCodeProcess(String username, String code) {
        this.request = new SendVerificationCodeRequest(username, code);
    }

    @Override
    public SendVerificationCodeResponse process() throws IOException, WebserviceException {
        Call<SendVerificationCodeResponse> verification = MyRetrofit.getInstance().getWebserviceUrls().sendVerificationCode(request);
        return send(verification);
    }
}
