package ir.sharif.vamdeh.webservices.webservices.loan_request.get_my_loan_relations_as_lender;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class GetMyLoanRelationsAsLenderProcess  extends BaseProcess {
    @Override
    public GetMyLoanRelationsAsLenderResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().getMyLoanRelationsAsLender());
    }
}
