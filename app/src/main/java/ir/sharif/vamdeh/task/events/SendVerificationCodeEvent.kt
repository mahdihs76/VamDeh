package ir.sharif.vamdeh.task.events

/**
 * Created by mahdihs76 on 11/22/18.
 */
class SendVerificationCodeEvent(val phone: String, val code: String)

class SendVerificationCodeErrorEvent(val error: String)