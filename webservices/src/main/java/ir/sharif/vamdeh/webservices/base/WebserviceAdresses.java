package ir.sharif.vamdeh.webservices.base;

public class WebserviceAdresses {
    public static final String BASE_URL = "https://biz-core2.herokuapp.com/";
    public static final String VERIFICATION = "v1/verification_code/send_verification_token/";
    public static final String SEND_VERIFICATION_CODE = "v1/verification_code/verified_token/";
    public static final String GET_MY_SCORES = "v1/score/get_my_scores/";
    public static final String LOGIN = "rest-auth/login/";
    public static final String CREATE_PROFILE = "v1/profile/create_my_profile/";
    public static final String GET_MY_USER_INFO = "v1/profile/get_my_user_info/";
    public static final String CREATE_TRUST_REQUEST = "v1/trust_relation/create_trust_request_as_trusted/";
    public static final String REGISTRATION = "v1/registration/registration/";
    public static final String GET_TRUST_REQUESTS_AS_REQUESTER = "v1/trust_relation/get_trust_requests_as_requester/";
    public static final String GET_TRUST_REQUESTS_AS_ACCEPTOR = "v1/trust_relation/get_trust_requests_as_acceptor/";
    public static final String EVALUATE_TRUST_REQUEST = "v1/trust_relation/evaluate_trust_request/";
    public static final String CREATE_MY_LOAN_REQUEST = "v1/loan_request/create_my_loan_request/";
    public static final String CREATE_DIRECT_REQUEST = "/v1/direct_loan/create_direct_loan/";
    public static final String DELETE_MY_LOAN_REQUEST = "v1/loan_request/delete_my_loan_request/";
    public static final String ACCEPT_LOAN_REQUEST = "v1/loan_relation/accept_loan_request/";
    public static final String GET_MY_REPAYMENTS = "v1/repayment/get_my_repayments/";
    public static final String GET_MY_GIVE_TRANSACTIONS = "v1/transaction/get_my_give_transactions/";
    public static final String UPDATE_MY_TRUST_RELATION_VALUE = "v1/trust_relation/update_my_trust_relation_value/";
    public static final String GET_MY_LAST_TRUST_HISTORY = "v1/trust_relation_history/get_my_last_trust_relation_history/";
    public static final String GET_MY_PROFILE_USER = "v1/profile/get_my_profile/";
    public static final String GET_MY_LOAN_RELATIONS_AS_LENDER = "v1/loan_relation/get_my_loan_relations_as_lender/";
    public static final String GET_MY_LOAN_RELATIONS_AS_BORROWER = "v1/loan_relation/get_my_loan_relations_as_borrower/";

    public static final String LIST_MY_LOAN = "v1/loan_request/list_my_loan_requests/";

    public static final String GET_MY_TRUSTED_PEOPLE_LIST = "v1/trust_relation/get_my_people_list_as_trustier/";
    public static final String GET_TRUSTIER_PEOPLE_LIST = "v1/trust_relation/get_my_people_list_as_trusted/";

    public static final String CREATE_TRUST_REQUEST_AS_TRUSTIER = "v1/trust_relation/create_trust_request_as_trustier/";
}
