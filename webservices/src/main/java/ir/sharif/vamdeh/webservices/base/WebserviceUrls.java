package ir.sharif.vamdeh.webservices.base;

import java.util.List;

import ir.sharif.vamdeh.webservices.webservices.rest_auth.get_my_scores.GetMyScoresResponse;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.send_verification_code.SendVerificationCodeRequest;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.send_verification_code.SendVerificationCodeResponse;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.verification.VerificationRequest;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.verification.VerificationResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust_request_as_trustier.CreateTrustRequestAsTrustierRequest;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust_request_as_trustier.CreateTrustRequestAsTrustierResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_my_trusted_people_list.GetMyTrustedPeopleListResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import ir.sharif.vamdeh.webservices.webservices.loan_request.accept_loan_request.AcceptLoanRequest;
import ir.sharif.vamdeh.webservices.webservices.loan_request.accept_loan_request.AcceptLoanResponse;
import ir.sharif.vamdeh.webservices.webservices.loan_request.create_my_loan_request.CreateMyLoanRequest;
import ir.sharif.vamdeh.webservices.webservices.loan_request.create_my_loan_request.CreateMyLoanResponse;
import ir.sharif.vamdeh.webservices.webservices.loan_request.delete_my_loan_request.DeleteMyLoanRequest;
import ir.sharif.vamdeh.webservices.webservices.loan_request.delete_my_loan_request.DeleteMyLoanResponse;
import ir.sharif.vamdeh.webservices.webservices.loan_request.get_my_loan_relations_as_borrower.GetMyLoanRelationsAsBorrowerResponse;
import ir.sharif.vamdeh.webservices.webservices.loan_request.get_my_loan_relations_as_lender.GetMyLoanRelationsAsLenderResponse;
import ir.sharif.vamdeh.webservices.webservices.loan_request.list_my_loan_requests.ListMyLoanResponse;
import ir.sharif.vamdeh.webservices.webservices.profile.create.CreateMyProfileRequest;
import ir.sharif.vamdeh.webservices.webservices.profile.create.CreateMyProfileResponse;
import ir.sharif.vamdeh.webservices.webservices.profile.get_my_profile_user.GetMyProfileUserResponse;
import ir.sharif.vamdeh.webservices.webservices.repayment.get_my_give_transactions.GetMyGiveTransactionsResponse;
import ir.sharif.vamdeh.webservices.webservices.repayment.get_my_repayments.GetMyRepaymentResponse;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.login.LoginRequest;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.login.LoginResponse;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.registration.RegistrationRequest;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.registration.RegistrationResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust.CreateTrustRequest;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust.CreateTrustResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.evaluate_trust_relation.EvaluateTrustRelationRequest;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.evaluate_trust_relation.EvaluateTrustRelationResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_my_last_trust_relation_history.GetMyLastTrustRelationHistoryResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trust_requests_as_acceptor.GetTrustRequestsAsAcceptorResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trust_requests_as_requeser.GetTrustRequestsAsRequesterResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.update_my_trust_relation_value.UpdateMyTrustRelationValueRequest;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.update_my_trust_relation_value.UpdateMyTrustRelationValueResponse;
import ir.sharif.vamdeh.webservices.webservices.user.get_my_user_info.GetMyUserInfoResponse;

public interface WebserviceUrls {

    @POST(WebserviceAdresses.VERIFICATION)
    Call<VerificationResponse> verification(@Body VerificationRequest request);

    @POST(WebserviceAdresses.SEND_VERIFICATION_CODE)
    Call<SendVerificationCodeResponse> sendVerificationCode(@Body SendVerificationCodeRequest request);

    @GET(WebserviceAdresses.GET_MY_SCORES)
    Call<List<GetMyScoresResponse>> getMyScores();

    @GET(WebserviceAdresses.GET_MY_TRUSTED_PEOPLE_LIST)
    Call<List<GetMyTrustedPeopleListResponse>> getMyTrustedPeopleList();

    @POST(WebserviceAdresses.CREATE_TRUST_REQUEST_AS_TRUSTIER)
    Call<CreateTrustRequestAsTrustierResponse> createTrustRequestAsTrustier(@Body CreateTrustRequestAsTrustierRequest request);

    @POST(WebserviceAdresses.REGISTRATION)
    Call<RegistrationResponse> register(@Body RegistrationRequest request);

    @POST(WebserviceAdresses.LOGIN)
    Call<LoginResponse> login(@Body LoginRequest request);

    @GET(WebserviceAdresses.GET_MY_USER_INFO)
    Call<GetMyUserInfoResponse> getMyUserInfo();

    @POST(WebserviceAdresses.CREATE_PROFILE)
    Call<CreateMyProfileResponse> createMyProfile(@Body CreateMyProfileRequest request);

    @POST(WebserviceAdresses.CREATE_TRUST_REQUEST)
    Call<CreateTrustResponse> createTrustRequest(@Body CreateTrustRequest request);

    @GET(WebserviceAdresses.GET_TRUST_REQUESTS_AS_ACCEPTOR)
    Call<GetTrustRequestsAsAcceptorResponse[]> getTrustRequestsAsAcceptor();

    @GET(WebserviceAdresses.GET_TRUST_REQUESTS_AS_REQUESTER)
    Call<GetTrustRequestsAsRequesterResponse[]> getTrustRequestsAsRequeser();

    @POST(WebserviceAdresses.EVALUATE_TRUST_REQUEST)
    Call<EvaluateTrustRelationResponse> evaluateTrustRelation(@Body EvaluateTrustRelationRequest request);

    @POST(WebserviceAdresses.CREATE_MY_LOAN_REQUEST)
    Call<CreateMyLoanResponse> createMyLoan(@Body CreateMyLoanRequest request);

    @POST(WebserviceAdresses.ACCEPT_LOAN_REQUEST)
    Call<AcceptLoanResponse> acceptLoan(@Body AcceptLoanRequest request);

    @DELETE(WebserviceAdresses.DELETE_MY_LOAN_REQUEST)
    Call<DeleteMyLoanResponse> deleteMyLoan(@Body DeleteMyLoanRequest request);

    @GET(WebserviceAdresses.GET_MY_LOAN_RELATIONS_AS_LENDER)
    Call<GetMyLoanRelationsAsLenderResponse> getMyLoanRelationsAsLender();

    @GET(WebserviceAdresses.GET_MY_PROFILE_USER)
    Call<GetMyProfileUserResponse> getMyProfileUser();

    @GET(WebserviceAdresses.GET_MY_GIVE_TRANSACTIONS)
    Call<GetMyGiveTransactionsResponse> getMyGiveTransactions();

    @GET(WebserviceAdresses.GET_MY_REPAYMENTS)
    Call<GetMyRepaymentResponse> getMyRepayment();

    @GET(WebserviceAdresses.GET_MY_LAST_TRUST_HISTORY)
    Call<GetMyLastTrustRelationHistoryResponse> getMyLastTrustRelationHistory();

    @GET(WebserviceAdresses.GET_MY_LOAN_RELATIONS_AS_BORROWER)
    Call<GetMyLoanRelationsAsBorrowerResponse> getMyLoanRelationsAsBorrower();

    @GET(WebserviceAdresses.LIST_MY_LOAN)
    Call<ListMyLoanResponse> listMyLoan();

    @POST(WebserviceAdresses.UPDATE_MY_TRUST_RELATION_VALUE)
    Call<UpdateMyTrustRelationValueResponse> updateMyTrustRelationValue(@Body UpdateMyTrustRelationValueRequest request);


}
