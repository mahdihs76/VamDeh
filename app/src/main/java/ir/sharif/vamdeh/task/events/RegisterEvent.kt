package ir.sharif.vamdeh.task.events

/**
 * Created by mahdihs76 on 11/22/18.
 */
class RegisterEvent(val password: String)

class RegisterErrorEvent(val error: String)
