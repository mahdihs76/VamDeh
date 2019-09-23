package ir.sharif.vamdeh.webservices.webservices.profile.create;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseResponse;

public class CreateMyProfileResponse extends BaseResponse {
  @SerializedName("id")  private String id;
  @SerializedName("mobile_phone_number")  private String mobilePhoneNumbe;
  @SerializedName("national_id")  private String nationalID;
  @SerializedName("bank_card_number")  private String bankCardNumber;
  @SerializedName("sheba_number")  private String shebaNumber;
  @SerializedName("profile")  private int user;

    public CreateMyProfileResponse(String id, String mobilePhoneNumbe, String nationalID, String bankCardNumber, String shebaNumber, int user) {
        this.id = id;
        this.mobilePhoneNumbe = mobilePhoneNumbe;
        this.nationalID = nationalID;
        this.bankCardNumber = bankCardNumber;
        this.shebaNumber = shebaNumber;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getMobilePhoneNumbe() {
        return mobilePhoneNumbe;
    }

    public String getNationalID() {
        return nationalID;
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public String getShebaNumber() {
        return shebaNumber;
    }

    public int getUser() {
        return user;
    }
}
