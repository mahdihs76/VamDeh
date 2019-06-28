package ir.sharif.vamdeh.task.events

/**
 * Created by mahdihs76 on 11/22/18.
 */
class SendVerificationEvent(val phone: String, val code: String)

class SendVerificationErrorEvent(val error: String)