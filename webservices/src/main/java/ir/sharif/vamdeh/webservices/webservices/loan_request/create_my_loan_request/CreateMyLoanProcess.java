package ir.sharif.vamdeh.webservices.webservices.loan_request.create_my_loan_request;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class CreateMyLoanProcess extends BaseProcess {
    private CreateMyLoanRequest request;

    public CreateMyLoanProcess(String status, int amount, int timeToReturnMoney, int requester, int id) {
        this.request = new CreateMyLoanRequest(status, amount, timeToReturnMoney, requester, id);
    }

    @Override
    public CreateMyLoanResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().createMyLoan(request));
    }
}
