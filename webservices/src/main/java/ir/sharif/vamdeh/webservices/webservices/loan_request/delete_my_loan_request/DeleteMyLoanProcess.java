package ir.sharif.vamdeh.webservices.webservices.loan_request.delete_my_loan_request;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class DeleteMyLoanProcess extends BaseProcess {
    DeleteMyLoanRequest request;

    public DeleteMyLoanProcess(int id) {
        this.request = new DeleteMyLoanRequest(id);
    }

    @Override
    public DeleteMyLoanResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().deleteMyLoan(request));
    }
}
