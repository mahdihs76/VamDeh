package ir.sharif.vamdeh.webservices.webservices.trust_relation.update_my_trust_relation_value;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class UpdateMyTrustRelationValueProcess extends BaseProcess {
    private UpdateMyTrustRelationValueRequest request;

    public UpdateMyTrustRelationValueProcess(int id, int activeTrustValue) {
        this.request = new UpdateMyTrustRelationValueRequest(id, activeTrustValue);
    }

    @Override
    public UpdateMyTrustRelationValueResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().updateMyTrustRelationValue(request));
    }
}
