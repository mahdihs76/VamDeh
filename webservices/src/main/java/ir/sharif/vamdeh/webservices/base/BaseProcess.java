package ir.sharif.vamdeh.webservices.base;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public abstract class BaseProcess {

    protected <T> T send(Call<T> call) throws IOException, WebserviceException {
        Response<T> execute = call.execute();
        if (execute.code() > 299 || execute.code() < 200) {
            throw new WebserviceException(execute.code(), execute.errorBody().string());
        }
        T body = execute.body();
        return body;
    }

    public abstract <T> T process() throws IOException, WebserviceException;

}
