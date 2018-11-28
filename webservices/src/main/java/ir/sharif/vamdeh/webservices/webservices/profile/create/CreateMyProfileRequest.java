package ir.sharif.vamdeh.webservices.webservices.profile.create;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class CreateMyProfileRequest extends BaseRequest {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("mobile_phone_number")
    private String mobilePhoneNo;
    @SerializedName("national_id")
    private String nationalID;
    @SerializedName("bank_card_number")
    private String bankCardNo;
    @SerializedName("sheba_number")
    private String shebaNo;

    public CreateMyProfileRequest(String userId, String mobilePhoneNo, String nationalID, String bankCardNo, String shebaNo) {
        this.userId = userId;
        this.mobilePhoneNo = mobilePhoneNo;
        this.nationalID = nationalID;
        this.bankCardNo = bankCardNo;
        this.shebaNo = shebaNo;
    }
}
