package ir.sharif.vamdeh.webservices.webservices.repayment.get_my_repayments;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class GetMyRepaymentProcess extends BaseProcess {
    @Override
    public GetMyRepaymentResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().getMyRepayment());
    }
}
