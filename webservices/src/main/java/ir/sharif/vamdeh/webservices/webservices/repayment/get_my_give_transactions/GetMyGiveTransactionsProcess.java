package ir.sharif.vamdeh.webservices.webservices.repayment.get_my_give_transactions;

import java.io.IOException;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;

public class GetMyGiveTransactionsProcess extends BaseProcess {
    @Override
    public GetMyGiveTransactionsResponse process() throws IOException, WebserviceException {
        return send(MyRetrofit.getInstance().getWebserviceUrls().getMyGiveTransactions());
    }
}
