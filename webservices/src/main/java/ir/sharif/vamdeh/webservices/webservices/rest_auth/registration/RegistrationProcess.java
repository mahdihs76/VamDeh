package ir.sharif.vamdeh.webservices.webservices.rest_auth.registration;

import java.io.IOException;

import retrofit2.Call;
import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class RegistrationProcess extends BaseProcess {

    private RegistrationRequest request;

    public RegistrationProcess(String username, String password1, String password2, String email) {
        this.request = new RegistrationRequest(username, password1, password2, email);
    }

    @Override
    public RegistrationResponse process() throws IOException, WebserviceException {

        Call<RegistrationResponse> register = MyRetrofit.getInstance().getWebserviceUrls().register(request);
        return send(register);
    }
}
