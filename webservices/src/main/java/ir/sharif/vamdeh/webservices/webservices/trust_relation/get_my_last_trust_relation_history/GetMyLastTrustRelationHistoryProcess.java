package ir.sharif.vamdeh.webservices.webservices.trust_relation.get_my_last_trust_relation_history;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class GetMyLastTrustRelationHistoryProcess extends BaseProcess {
    @Override
    public GetMyLastTrustRelationHistoryResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().getMyLastTrustRelationHistory());
    }
}
