package ir.sharif.vamdeh.webservices.webservices.rest_auth.registration;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;
import ir.sharif.vamdeh.webservices.base.WebserviceConstants;

public class RegistrationRequest extends BaseRequest {

    @SerializedName(WebserviceConstants.PHONE_NUMBER)
    private String userName;
    @SerializedName(WebserviceConstants.TOKEN)
    private String token;
    @SerializedName(WebserviceConstants.PASSWORD)
    private String password;

    public RegistrationRequest(String userName, String token, String password) {
        this.userName = userName;
        this.token = token;
        this.password = password;
    }
}
