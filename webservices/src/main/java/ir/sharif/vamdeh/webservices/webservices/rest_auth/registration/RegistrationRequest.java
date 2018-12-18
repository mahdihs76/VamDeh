package ir.sharif.vamdeh.webservices.webservices.rest_auth.registration;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;
import ir.sharif.vamdeh.webservices.base.WebserviceConstants;

public class RegistrationRequest extends BaseRequest {

    @SerializedName(WebserviceConstants.USERNAME)
    private String userName;
    @SerializedName(WebserviceConstants.PASSWORD1)
    private String password1;
    @SerializedName(WebserviceConstants.PASSWORD2)
    private String password2;

    public RegistrationRequest(String userName, String password1, String password2) {
        this.userName = userName;
        this.password1 = password1;
        this.password2 = password2;
    }
}
