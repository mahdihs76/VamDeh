package ir.sharif.vamdeh.webservices.webservices.rest_auth.registration;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;
import ir.sharif.vamdeh.webservices.base.WebserviceConstance;

public class RegistrationRequest extends BaseRequest {

    @SerializedName(WebserviceConstance.USERNAME)
    private String userName;
    @SerializedName(WebserviceConstance.PASSWORD1)
    private String password1;
    @SerializedName(WebserviceConstance.PASSWORD2)
    private String password2;
    @SerializedName(WebserviceConstance.EMAIL)
    private String email;

    public RegistrationRequest(String userName, String password1, String password2, String email) {
        this.userName = userName;
        this.password1 = password1;
        this.password2 = password2;
        this.email = email;
    }
}
