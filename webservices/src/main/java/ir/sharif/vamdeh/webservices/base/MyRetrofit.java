package ir.sharif.vamdeh.webservices.base;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ir.sharif.vamdeh.webservices.pref.WebservicePrefSetting;

import static ir.sharif.vamdeh.webservices.base.WebserviceAdresses.BASE_URL;

public class MyRetrofit {

    private static MyRetrofit instance;

    public static MyRetrofit getInstance() {
        if (instance == null) {
            instance = new MyRetrofit();
        }
        return instance;
    }

    WebserviceUrls urls;

    public WebserviceUrls getWebserviceUrls() {
        if (urls == null) {
            urls = getUrls();
        }

        return urls;
    }


    private WebserviceUrls getUrls() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .serializeNulls()
                .create();

        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        addLogginInterceptor(builder);
        if (WebservicePrefSetting.getInstanceWithoutContext().getToken() != null) {
            addAuthHeader(builder);
        }

        OkHttpClient client = builder.build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        return retrofit.create(WebserviceUrls.class);
    }

    private void addLogginInterceptor(OkHttpClient.Builder client) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client.addInterceptor(interceptor);
    }

    private void addAuthHeader(OkHttpClient.Builder client) {
        client.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();
                Request request = original.newBuilder()
                        .addHeader("Authorization", getToken())
                        .build();

                return chain.proceed(request);
            }
        });
    }

    private String getToken() {
        String key = WebservicePrefSetting.getInstanceWithoutContext().getToken();
        System.out.println("WSToken -> " + " token " + key);
        return "token " + key;
    }

}
