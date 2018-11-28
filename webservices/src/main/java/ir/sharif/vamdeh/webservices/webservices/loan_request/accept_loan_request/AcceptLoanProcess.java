package ir.sharif.vamdeh.webservices.webservices.loan_request.accept_loan_request;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class AcceptLoanProcess extends BaseProcess {
    private AcceptLoanRequest request;

    public AcceptLoanProcess(int loanRequestID) {
        request = new AcceptLoanRequest(loanRequestID);
    }

    @Override
    public AcceptLoanResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().acceptLoan(request));
    }
}
