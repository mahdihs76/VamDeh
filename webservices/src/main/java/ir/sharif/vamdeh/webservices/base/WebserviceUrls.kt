package ir.sharif.vamdeh.webservices.base

import com.google.gson.annotations.SerializedName
import ir.sharif.vamdeh.webservices.webservices.rest_auth.get_my_scores.GetMyScoresResponse
import ir.sharif.vamdeh.webservices.webservices.rest_auth.send_verification_code.SendVerificationCodeRequest
import ir.sharif.vamdeh.webservices.webservices.rest_auth.send_verification_code.SendVerificationCodeResponse
import ir.sharif.vamdeh.webservices.webservices.rest_auth.verification.VerificationRequest
import ir.sharif.vamdeh.webservices.webservices.rest_auth.verification.VerificationResponse
import ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust_request_as_trustier.CreateTrustRequestAsTrustierRequest
import ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust_request_as_trustier.CreateTrustRequestAsTrustierResponse
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_my_trusted_people_list.GetMyTrustedPeopleListResponse
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trusted_me_people_list.get_my_trusted_people_list.GetTrustierPeopleListResponse
import retrofit2.Call
import ir.sharif.vamdeh.webservices.webservices.loan_request.accept_loan_request.AcceptLoanRequest
import ir.sharif.vamdeh.webservices.webservices.loan_request.accept_loan_request.AcceptLoanResponse
import ir.sharif.vamdeh.webservices.webservices.loan_request.create_my_loan_request.CreateMyLoanRequest
import ir.sharif.vamdeh.webservices.webservices.loan_request.create_my_loan_request.CreateMyLoanResponse
import ir.sharif.vamdeh.webservices.webservices.loan_request.delete_my_loan_request.DeleteMyLoanRequest
import ir.sharif.vamdeh.webservices.webservices.loan_request.delete_my_loan_request.DeleteMyLoanResponse
import ir.sharif.vamdeh.webservices.webservices.loan_request.get_my_loan_relations_as_borrower.GetMyLoanRelationsAsBorrowerResponse
import ir.sharif.vamdeh.webservices.webservices.loan_request.get_my_loan_relations_as_lender.GetMyLoanRelationsAsLenderResponse
import ir.sharif.vamdeh.webservices.webservices.loan_request.list_my_loan_requests.ListMyLoanResponse
import ir.sharif.vamdeh.webservices.webservices.profile.create.CreateMyProfileRequest
import ir.sharif.vamdeh.webservices.webservices.profile.create.CreateMyProfileResponse
import ir.sharif.vamdeh.webservices.webservices.profile.get_my_profile_user.GetMyProfileUserResponse
import ir.sharif.vamdeh.webservices.webservices.repayment.get_my_give_transactions.GetMyGiveTransactionsResponse
import ir.sharif.vamdeh.webservices.webservices.repayment.get_my_repayments.GetMyRepaymentResponse
import ir.sharif.vamdeh.webservices.webservices.rest_auth.login.LoginRequest
import ir.sharif.vamdeh.webservices.webservices.rest_auth.login.LoginResponse
import ir.sharif.vamdeh.webservices.webservices.rest_auth.registration.RegistrationRequest
import ir.sharif.vamdeh.webservices.webservices.rest_auth.registration.RegistrationResponse
import ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust.CreateTrustRequestAsTrustedRequest
import ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust.CreateTrustResponse
import ir.sharif.vamdeh.webservices.webservices.trust_relation.evaluate_trust_relation.EvaluateTrustRelationRequest
import ir.sharif.vamdeh.webservices.webservices.trust_relation.evaluate_trust_relation.EvaluateTrustRelationResponse
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_my_last_trust_relation_history.GetMyLastTrustRelationHistoryResponse
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trust_requests_as_acceptor.GetTrustRequestsAsAcceptorResponse
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trust_requests_as_requeser.GetTrustRequestsAsRequesterResponse
import ir.sharif.vamdeh.webservices.webservices.trust_relation.update_my_trust_relation_value.UpdateMyTrustRelationValueRequest
import ir.sharif.vamdeh.webservices.webservices.trust_relation.update_my_trust_relation_value.UpdateMyTrustRelationValueResponse
import ir.sharif.vamdeh.webservices.webservices.user.get_my_user_info.GetMyUserInfoResponse
import retrofit2.Response
import retrofit2.http.*

interface WebserviceUrls {

    @get:GET(WebserviceAdresses.GET_MY_SCORES)
    val myScores: Call<List<GetMyScoresResponse>>

    @get:GET(WebserviceAdresses.GET_MY_TRUSTED_PEOPLE_LIST)
    val myTrustedPeopleList: Call<List<GetMyTrustedPeopleListResponse>>

    @GET(WebserviceAdresses.GET_TRUSTIER_PEOPLE_LIST)
    suspend fun getTrustierPeopleList(): Response<List<GetTrustierPeopleListResponse>>

    @get:GET(WebserviceAdresses.GET_MY_USER_INFO)
    val myUserInfo: Call<GetMyUserInfoResponse>

    @get:GET(WebserviceAdresses.GET_TRUST_REQUESTS_AS_ACCEPTOR)
    val trustRequestsAsAcceptor: Call<Array<GetTrustRequestsAsAcceptorResponse>>

    @get:GET(WebserviceAdresses.GET_TRUST_REQUESTS_AS_REQUESTER)
    val trustRequestsAsRequeser: Call<Array<GetTrustRequestsAsRequesterResponse>>

    @get:GET(WebserviceAdresses.GET_MY_LOAN_RELATIONS_AS_LENDER)
    val myLoanRelationsAsLender: Call<GetMyLoanRelationsAsLenderResponse>

    @get:GET(WebserviceAdresses.GET_MY_PROFILE_USER)
    val myProfileUser: Call<GetMyProfileUserResponse>

    @get:GET(WebserviceAdresses.GET_MY_GIVE_TRANSACTIONS)
    val myGiveTransactions: Call<GetMyGiveTransactionsResponse>

    @get:GET(WebserviceAdresses.GET_MY_REPAYMENTS)
    val myRepayment: Call<GetMyRepaymentResponse>

    @get:GET(WebserviceAdresses.GET_MY_LAST_TRUST_HISTORY)
    val myLastTrustRelationHistory: Call<GetMyLastTrustRelationHistoryResponse>

    @get:GET(WebserviceAdresses.GET_MY_LOAN_RELATIONS_AS_BORROWER)
    val myLoanRelationsAsBorrower: Call<GetMyLoanRelationsAsBorrowerResponse>

    @POST(WebserviceAdresses.VERIFICATION)
    fun verification(@Body request: VerificationRequest): Call<VerificationResponse>

    @POST(WebserviceAdresses.SEND_VERIFICATION_CODE)
    fun sendVerificationCode(@Body request: SendVerificationCodeRequest): Call<SendVerificationCodeResponse>

    @POST(WebserviceAdresses.CREATE_TRUST_REQUEST_AS_TRUSTIER)
     fun createTrustRequestAsTrustier(@Body request: CreateTrustRequestAsTrustierRequest): Call<CreateTrustRequestAsTrustierResponse>

    @POST(WebserviceAdresses.REGISTRATION)
    fun register(@Body request: RegistrationRequest): Call<RegistrationResponse>

    @POST(WebserviceAdresses.LOGIN)
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @POST(WebserviceAdresses.CREATE_PROFILE)
    fun createMyProfile(@Body request: CreateMyProfileRequest): Call<CreateMyProfileResponse>

    @FormUrlEncoded
    @POST(WebserviceAdresses.CREATE_TRUST_REQUEST)
    suspend fun createTrustRequest(@Field("trustier_mobile_number") phoneNumber: String): Response<CreateTrustResponse>

    @POST(WebserviceAdresses.EVALUATE_TRUST_REQUEST)
    fun evaluateTrustRelation(@Body request: EvaluateTrustRelationRequest): Call<EvaluateTrustRelationResponse>

    @POST(WebserviceAdresses.CREATE_MY_LOAN_REQUEST)
    fun createMyLoan(@Body request: CreateMyLoanRequest): Call<CreateMyLoanResponse>

    @POST(WebserviceAdresses.ACCEPT_LOAN_REQUEST)
    fun acceptLoan(@Body request: AcceptLoanRequest): Call<AcceptLoanResponse>

    @DELETE(WebserviceAdresses.DELETE_MY_LOAN_REQUEST)
    fun deleteMyLoan(@Body request: DeleteMyLoanRequest): Call<DeleteMyLoanResponse>

    @GET(WebserviceAdresses.LIST_MY_LOAN)
    fun listMyLoan(): Call<ListMyLoanResponse>

    @POST(WebserviceAdresses.UPDATE_MY_TRUST_RELATION_VALUE)
    fun updateMyTrustRelationValue(@Body request: UpdateMyTrustRelationValueRequest): Call<UpdateMyTrustRelationValueResponse>


}
