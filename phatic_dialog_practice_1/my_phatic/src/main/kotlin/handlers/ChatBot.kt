package handlers

class ChatBot() {

    fun answerTo(userInput : String?) : String{
        var answer = ""

        if (isValid(userInput)){
            pickAnswer(removePunctuations(userInput!!))
        }else{
            answer = nullInputPhrases[nullInputCounter--]
        }

        return answer;
    }

    fun pickAnswer(userInput : String){

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

    var toBeContinued : Boolean = true
        private set
    var nullInputCounter = nullInputPhrases.size - 1
        private set

    companion object{
        val nullInputPhrases =
            listOf<String>(
                "Eng, mf! Do you speak it?",
                "What's a matter?",
                "Why are you mumbling, speak clearly!",
                "Hey, bud, you wanna say something?",
                "Hm, you said something?")
    }
}

fun removePunctuations(source: String): String {
    var chatBot : ChatBot = ChatBot()
    chatBot.toBeContinued
    return source.replace("[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]".toRegex(), "")
}

class TestException(message:String): Exception(message)