package ir.sharif.vamdeh.webservices.webservices.user.get_my_user_info;

import java.io.IOException;

import retrofit2.Call;
import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class GetMyUserInfoProcess extends BaseProcess {

    @Override
    public GetMyUserInfoResponse process() throws IOException, WebserviceException {
        Call<GetMyUserInfoResponse> myUserInfo = MyRetrofit.getInstance().getWebserviceUrls().getMyUserInfo();
        return send(myUserInfo);
    }
}
