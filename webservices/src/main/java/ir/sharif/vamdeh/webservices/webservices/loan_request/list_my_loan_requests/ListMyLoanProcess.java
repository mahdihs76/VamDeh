package ir.sharif.vamdeh.webservices.webservices.loan_request.list_my_loan_requests;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class ListMyLoanProcess extends BaseProcess {
    @Override
    public ListMyLoanResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().listMyLoan());
    }
}
