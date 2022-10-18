import db.DB
import db.dbIn.DBd
import interchanges.Answerable

class ChatBot(val interchanges: MutableList<Answerable> = DB().getInterchanges()) {

    fun answerTo(userInput : String?) : String{

        return if (isValid(userInput))
            pickAnswer(" ${(removePunctuations(userInput!!)).lowercase()} ")
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
    var toBeContinued = true
        private set

    companion object{

        private val nullInputPhrases = DBd.getNullInputPhrases()
        private val nullOutputPhrases = DBd.getNullOutputPhrases()

        var priorResponse : String? = ""
            private set
    }
}

fun removePunctuations(source: String): String {
    return source.replace("[!\"#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~]".toRegex(), "")
}

