package ir.sharif.vamdeh.webservices.webservices.rest_auth.login;

import java.io.IOException;

import retrofit2.Call;
import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class LoginProcess extends BaseProcess {
    private LoginRequest request;

    public LoginProcess(String username, String password) {
        this.request = new LoginRequest(username, password);
    }

    @Override
    public LoginResponse process() throws IOException, WebserviceException {
        Call<LoginResponse> login = MyRetrofit.getInstance().getWebserviceUrls().login(request);
        return send(login);
    }
}
