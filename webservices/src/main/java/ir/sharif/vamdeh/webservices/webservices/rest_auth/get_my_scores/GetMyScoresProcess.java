package ir.sharif.vamdeh.webservices.webservices.rest_auth.get_my_scores;

import java.io.IOException;
import java.util.List;

import ir.sharif.vamdeh.webservices.base.BaseProcess;
import ir.sharif.vamdeh.webservices.base.MyRetrofit;
import ir.sharif.vamdeh.webservices.base.WebserviceException;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.verification.VerificationRequest;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.verification.VerificationResponse;
import retrofit2.Call;

public class GetMyScoresProcess extends BaseProcess {

    @Override
    public List<GetMyScoresResponse> process() throws IOException, WebserviceException {
        Call<List<GetMyScoresResponse>> getMyScores = MyRetrofit.getInstance().getWebserviceUrls().getMyScores();
        return send(getMyScores);
    }
}
