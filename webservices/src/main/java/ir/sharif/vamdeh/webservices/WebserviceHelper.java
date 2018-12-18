package ir.sharif.vamdeh.webservices;

import android.content.Context;

import java.io.IOException;
import java.util.List;

import ir.sharif.vamdeh.webservices.base.WebserviceException;
import ir.sharif.vamdeh.webservices.pref.WebservicePrefSetting;
import ir.sharif.vamdeh.webservices.webservices.loan_request.accept_loan_request.AcceptLoanProcess;
import ir.sharif.vamdeh.webservices.webservices.loan_request.accept_loan_request.AcceptLoanResponse;
import ir.sharif.vamdeh.webservices.webservices.loan_request.create_my_loan_request.CreateMyLoanProcess;
import ir.sharif.vamdeh.webservices.webservices.loan_request.create_my_loan_request.CreateMyLoanResponse;
import ir.sharif.vamdeh.webservices.webservices.loan_request.delete_my_loan_request.DeleteMyLoanProcess;
import ir.sharif.vamdeh.webservices.webservices.loan_request.delete_my_loan_request.DeleteMyLoanResponse;
import ir.sharif.vamdeh.webservices.webservices.loan_request.get_my_loan_relations_as_borrower.GetMyLoanRelationsAsBorrowerProcess;
import ir.sharif.vamdeh.webservices.webservices.loan_request.get_my_loan_relations_as_borrower.GetMyLoanRelationsAsBorrowerResponse;
import ir.sharif.vamdeh.webservices.webservices.loan_request.get_my_loan_relations_as_lender.GetMyLoanRelationsAsLenderProcess;
import ir.sharif.vamdeh.webservices.webservices.loan_request.get_my_loan_relations_as_lender.GetMyLoanRelationsAsLenderResponse;
import ir.sharif.vamdeh.webservices.webservices.loan_request.list_my_loan_requests.ListMyLoanProcess;
import ir.sharif.vamdeh.webservices.webservices.loan_request.list_my_loan_requests.ListMyLoanResponse;
import ir.sharif.vamdeh.webservices.webservices.profile.create.CreateMyProfileProcess;
import ir.sharif.vamdeh.webservices.webservices.profile.create.CreateMyProfileResponse;
import ir.sharif.vamdeh.webservices.webservices.profile.get_my_profile_user.GetMyProfileUserProcess;
import ir.sharif.vamdeh.webservices.webservices.profile.get_my_profile_user.GetMyProfileUserResponse;
import ir.sharif.vamdeh.webservices.webservices.repayment.get_my_give_transactions.GetMyGiveTransactionsProcess;
import ir.sharif.vamdeh.webservices.webservices.repayment.get_my_give_transactions.GetMyGiveTransactionsResponse;
import ir.sharif.vamdeh.webservices.webservices.repayment.get_my_repayments.GetMyRepaymentProcess;
import ir.sharif.vamdeh.webservices.webservices.repayment.get_my_repayments.GetMyRepaymentResponse;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.get_my_scores.GetMyScoresProcess;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.get_my_scores.GetMyScoresResponse;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.login.LoginProcess;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.login.LoginResponse;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.registration.RegistrationProcess;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.registration.RegistrationResponse;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.send_verification_code.SendVerificationCodeProcess;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.send_verification_code.SendVerificationCodeResponse;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.verification.VerificationProcess;
import ir.sharif.vamdeh.webservices.webservices.rest_auth.verification.VerificationResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust.CreateTrustProcess;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.create_trust.CreateTrustResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.evaluate_trust_relation.EvaluateTrustRelationProcess;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.evaluate_trust_relation.EvaluateTrustRelationResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_my_last_trust_relation_history.GetMyLastTrustRelationHistoryProcess;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_my_last_trust_relation_history.GetMyLastTrustRelationHistoryResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trust_requests_as_acceptor.GetTrustRequestsAsAcceptorProcess;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trust_requests_as_acceptor.GetTrustRequestsAsAcceptorResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trust_requests_as_requeser.GetTrustRequestsAsRequesterProcess;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.get_trust_requests_as_requeser.GetTrustRequestsAsRequesterResponse;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.update_my_trust_relation_value.UpdateMyTrustRelationValueProcess;
import ir.sharif.vamdeh.webservices.webservices.trust_relation.update_my_trust_relation_value.UpdateMyTrustRelationValueResponse;
import ir.sharif.vamdeh.webservices.webservices.user.get_my_user_info.GetMyUserInfoProcess;
import ir.sharif.vamdeh.webservices.webservices.user.get_my_user_info.GetMyUserInfoResponse;

public class WebserviceHelper {

    public static VerificationResponse verification(String username) throws IOException, WebserviceException {
        VerificationProcess process = new VerificationProcess(username);
        return process.process();
    }

    public static SendVerificationCodeResponse sendVerificationCode(String username, String code) throws IOException, WebserviceException {
        SendVerificationCodeProcess process = new SendVerificationCodeProcess(username, code);
        return process.process();
    }

    public static List<GetMyScoresResponse> getMyScores() throws IOException, WebserviceException {
        GetMyScoresProcess process = new GetMyScoresProcess();
        return process.process();
    }

    public static RegistrationResponse register(Context context, String username, String password1, String password2) throws IOException, WebserviceException {
        RegistrationProcess process = new RegistrationProcess(username, password1, password2);
        RegistrationResponse response = process.process();
        WebservicePrefSetting.getInstance(context).saveToken(response.getKey());
        return response;
    }

    public static LoginResponse login(Context context, String phoneNumber, String password) throws IOException, WebserviceException {
        LoginProcess process = new LoginProcess(phoneNumber, password);
        LoginResponse response = process.process();
        WebservicePrefSetting.getInstance(context).saveToken(response.getKey());
        return response;
    }

    public static GetMyUserInfoResponse getMyUserInfo(Context context) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();
        GetMyUserInfoProcess process = new GetMyUserInfoProcess();
        return process.process();
    }

    public static CreateMyProfileResponse createMyProfile(Context context, String userId, String mobilePhoneNo, String nationalID, String bankCardNo, String shebaNo) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();

        CreateMyProfileProcess process = new CreateMyProfileProcess(userId, mobilePhoneNo, nationalID, bankCardNo, shebaNo);
        return process.process();
    }

    public static CreateTrustResponse createTrust(Context context, int trustier) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();

        CreateTrustProcess process = new CreateTrustProcess(trustier);
        return process.process();
    }

    public static GetTrustRequestsAsAcceptorResponse[] getTrustRequestsAsAcceptor(Context context) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();

        GetTrustRequestsAsAcceptorProcess process = new GetTrustRequestsAsAcceptorProcess();
        return process.process();
    }

    public static GetTrustRequestsAsRequesterResponse[] getTrustRequestsAsRequester(Context context) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();

        GetTrustRequestsAsRequesterProcess process = new GetTrustRequestsAsRequesterProcess();
        return process.process();
    }

    public static AcceptLoanResponse acceptLoan(Context context, int loanID) throws IOException, WebserviceException {
        AcceptLoanProcess process = new AcceptLoanProcess(loanID);
        return process.process();
    }

    public static CreateMyLoanResponse createMyLoan(int amount, int timeToReturnMoney, String status) throws IOException, WebserviceException {
        CreateMyLoanProcess process = new CreateMyLoanProcess(amount, timeToReturnMoney, status);
        return process.process();
    }

    public static DeleteMyLoanResponse deleteMyLoanProcess(Context context, int id) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();

        DeleteMyLoanProcess process = new DeleteMyLoanProcess(id);
        return process.process();
    }

    public static GetMyLoanRelationsAsBorrowerResponse getMyLoanRelationsAsBorrower(Context context, int id) throws IOException, WebserviceException {
        GetMyLoanRelationsAsBorrowerProcess process = new GetMyLoanRelationsAsBorrowerProcess();
        return process.process();
    }

    public static GetMyLoanRelationsAsLenderResponse getMyLoanRelationsAsLender(Context context) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();

        GetMyLoanRelationsAsLenderProcess process = new GetMyLoanRelationsAsLenderProcess();
        return process.process();
    }

    public static ListMyLoanResponse listMyLoan(Context context) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();
        ListMyLoanProcess process = new ListMyLoanProcess();
        return process.process();
    }

    public static GetMyProfileUserResponse getMyProfileUser(Context context) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();
        GetMyProfileUserProcess process = new GetMyProfileUserProcess();
        return process.process();
    }

    public static GetMyGiveTransactionsResponse getMyGiveTransations(Context context) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();
        GetMyGiveTransactionsProcess process = new GetMyGiveTransactionsProcess();
        return process.process();
    }

    public static GetMyRepaymentResponse getMyRepayment(Context context) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();
        GetMyRepaymentProcess process = new GetMyRepaymentProcess();
        return process.process();
    }

    public static EvaluateTrustRelationResponse evaluateTrustRelation(Context context, int trusted, int activeTrustValue, int id) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();
        EvaluateTrustRelationProcess process = new EvaluateTrustRelationProcess(trusted, activeTrustValue, id);
        return process.process();
    }

      public static GetMyLastTrustRelationHistoryResponse getMyLastTrustRelationHistory(Context context) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();
        GetMyLastTrustRelationHistoryProcess process = new GetMyLastTrustRelationHistoryProcess();
        return process.process();
    }

    public static UpdateMyTrustRelationValueResponse updateMyTrustRelationValueProcess(Context context, int id, int activeTrustValue) throws IOException, WebserviceException {
        WebservicePrefSetting.getInstance(context).isRegister();
        UpdateMyTrustRelationValueProcess process = new UpdateMyTrustRelationValueProcess(id, activeTrustValue);
        return process.process();
    }

}
