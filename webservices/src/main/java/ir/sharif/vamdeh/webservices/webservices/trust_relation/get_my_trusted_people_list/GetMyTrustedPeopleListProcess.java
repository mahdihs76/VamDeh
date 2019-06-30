package ir.sharif.vamdeh.webservices.webservices.trust_relation.get_my_trusted_people_list;

import java.io.IOException;
import java.util.List;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class GetMyTrustedPeopleListProcess extends BaseProcess {
    @Override
    public List<GetMyTrustedPeopleListResponse> process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().getMyTrustedPeopleList());
    }
}
