package com.ai.labs.handlers

import com.ai.labs.answerTemplates.greetings
import edu.stanford.nlp.simple.Sentence


fun commonHandler(str:String) : String {
    return when {
        contains(str.toLowerCase(), greetings) -> greetings.random()
        str.contains("?") -> questionHandler (str)
        contains(str, modalVerbs) -> modalHandler(str)
        else -> defineEntityGroupAndAnswer(Sentence(str))
    }
}

private fun contains(str:String, list:List<String>) : Boolean {
    for (word in list) {
        if(str.contains(word)) return true
    }
    return false
}