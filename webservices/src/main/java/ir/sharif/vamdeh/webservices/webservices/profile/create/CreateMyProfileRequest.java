package ir.sharif.vamdeh.webservices.webservices.profile.create;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseRequest;

public class CreateMyProfileRequest extends BaseRequest {

    @SerializedName("nick_name")
    private String nickName;
    @SerializedName("national_id")
    private String nationalID;
    @Expose
    @SerializedName("bank_card_number")
    private String bankCardNo;
    @Expose
    @SerializedName("sheba_number")
    private String shebaNo;
    @Expose
    @SerializedName("account_number")
    private String accountNumber;

    public CreateMyProfileRequest(String nickName, String nationalID, String bankCardNo, String shebaNo, String accountNumber) {
        this.nickName = nickName;
        this.accountNumber = accountNumber;
        this.nationalID = nationalID;
        this.bankCardNo = bankCardNo;
        this.shebaNo = shebaNo;
    }
}
