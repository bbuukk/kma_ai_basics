package handlers

import handlers.interchanges.Answerable

class ChatBot() {

    fun answerTo(userInput : String?) : String{

        return if (isValid(userInput))
            pickAnswer(" ${removePunctuations(userInput!!)} ")
        else
            nullInputPhrases[nullInputCounter--]
    }

    private fun isValid(userInput: String?) : Boolean{
        var isValid = true;

        if (userInput.isNullOrBlank()) {
            if(nullInputCounter == 0)
                toBeContinued = false
            isValid = false
        }else{
            nullInputCounter = nullInputPhrases.size - 1
        }
        return isValid
    }

    private fun pickAnswer(userInput : String) : String{

        var answer : String = nullOutputPhrases.random()
        for (incs in interchanges) {
            answer = incs.answer(userInput) ?: continue
        }

        priorResponse = answer
        return answer
    }

    private var nullInputCounter = nullInputPhrases.size - 1
    var toBeContinued : Boolean = true
        private set

    companion object{

        private val nullInputPhrases = listOf(
                "English, mf! Do you speak it?",
                "What's a matter?",
                "Why are you mumbling, speak clearly!",
                "Hey, bud, you wanna say something?",
                "Hm, you said something?")

        private val nullOutputPhrases = listOf(
            "Let's talk about fighters jet",
            "DO you know, that f-35 helmets allow pilots to see through the plane?",
            "Can't catch on",
            "I just don't get it",
            "I can't get my head around it")

      val interchanges : List<Answerable> = listOf()
        var priorResponse : String? = ""
            private set
    }
}

fun removePunctuations(source: String): String {
    return source.replace("[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]".toRegex(), "")
}

