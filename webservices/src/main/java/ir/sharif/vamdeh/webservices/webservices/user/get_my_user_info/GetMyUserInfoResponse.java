package ir.sharif.vamdeh.webservices.webservices.user.get_my_user_info;

import com.google.gson.annotations.SerializedName;

import ir.sharif.vamdeh.webservices.base.BaseResponse;

public class GetMyUserInfoResponse extends BaseResponse {

    @SerializedName("id")
    private String id;
    @SerializedName("password")
    private String password;
    @SerializedName("last_login")
    private String lastLogin;
    @SerializedName("is_superuser")
    private boolean isSuperUser;
    @SerializedName("username")
    private String username;
    @SerializedName("first_name")
    private String firstName;
    @SerializedName("last_name")
    private String lastName;
    @SerializedName("email")
    private String email;
    @SerializedName("is_staff")
    private boolean isStaff;
    @SerializedName("is_active")
    private boolean isActive;
    @SerializedName("date_joined")
    private String dateJoin;
    @SerializedName("groups")
    private String[] groups;
    @SerializedName("user_permissions")
    private String[] userPermission;

    public GetMyUserInfoResponse(String id, String password, String lastLogin, boolean isSuperUser, String username, String firstName, String lastName, String email, boolean isStaff, boolean isActive, String dateJoin, String[] groups, String[] userPermission) {
        this.id = id;
        this.password = password;
        this.lastLogin = lastLogin;
        this.isSuperUser = isSuperUser;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isStaff = isStaff;
        this.isActive = isActive;
        this.dateJoin = dateJoin;
        this.groups = groups;
        this.userPermission = userPermission;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public boolean isSuperUser() {
        return isSuperUser;
    }

    public String getUsername() {
        return username;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public boolean isActive() {
        return isActive;
    }

    public String getDateJoin() {
        return dateJoin;
    }

    public String getFirstName() {
        return firstName;
    }

    public String[] getGroups() {
        return groups;
    }

    public String[] getUserPermission() {
        return userPermission;
    }
}
