package com.ai.labs

import com.ai.labs.handlers.*

fun main() {

    var sentenceString = ""
    while(true) {
        sentenceString = readLine()!!
        if(sentenceString.toLowerCase().contains("bye")) {
            println("Bye:)")
            break
        }

        if(sentenceString != null && sentenceString.isNotBlank()) println(commonHandler(sentenceString))
    }
}
