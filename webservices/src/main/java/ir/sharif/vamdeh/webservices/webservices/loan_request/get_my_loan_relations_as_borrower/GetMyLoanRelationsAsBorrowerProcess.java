package ir.sharif.vamdeh.webservices.webservices.loan_request.get_my_loan_relations_as_borrower;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class GetMyLoanRelationsAsBorrowerProcess extends BaseProcess {
    @Override
    public GetMyLoanRelationsAsBorrowerResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().getMyLoanRelationsAsBorrower());
    }
}
