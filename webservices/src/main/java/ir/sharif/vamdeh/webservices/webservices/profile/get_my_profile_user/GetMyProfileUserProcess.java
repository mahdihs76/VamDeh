package ir.sharif.vamdeh.webservices.webservices.profile.get_my_profile_user;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class GetMyProfileUserProcess extends BaseProcess {
    @Override
    public GetMyProfileUserResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().getMyProfileUser());
    }
}
