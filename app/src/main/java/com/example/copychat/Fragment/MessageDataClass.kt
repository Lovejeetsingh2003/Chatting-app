package com.example.copychat.Fragment

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.SimpleTimeZone

data class MessageDataClass(
    var message : String ?= null,
    var type : Int ?= 1,
    var time : String ?= SimpleDateFormat("dd/MMM/yyyy").format(Calendar.getInstance().time)
)
