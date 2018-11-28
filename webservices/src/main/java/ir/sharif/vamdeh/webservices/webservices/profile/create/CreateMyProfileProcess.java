package ir.sharif.vamdeh.webservices.webservices.profile.create;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class CreateMyProfileProcess extends BaseProcess {
    CreateMyProfileRequest request;

    public CreateMyProfileProcess(String userId, String mobilePhoneNo, String nationalID, String bankCardNo, String shebaNo) {
        this.request = new CreateMyProfileRequest(userId, mobilePhoneNo, nationalID, bankCardNo, shebaNo);
    }

    @Override
    public CreateMyProfileResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().createMyProfile(request));
    }
}
