package ir.sharif.vamdeh.task.events

/**
 * Created by mahdihs76 on 11/22/18.
 */
class VerificationEvent(val phone: String, val registeredUser: Boolean)

class VerificationErrorEvent(val error: String)