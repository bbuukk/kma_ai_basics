package interchanges

import ChatBot.Companion.priorResponse

class С(
     val inputs: List<String>,
     val answers: List<String>
) : Answerable {

    private fun match(input: String): String? {
        var match: String? = null
        for (kw in inputs) {
            if (input.contains(kw)) {
                match = input
                    .substring(input.indexOf(kw) + kw.length)
                    .trim()
            }
        }
        return match
    }

    override fun answer(input: String): String? {
        val match: String? = match(input)
        return if (match != null)
            answers
                .shuffled()
                .first { it != priorResponse }
                .replace(Answerable.condition, match)
        else null
    }
}

//package handlers.interchanges
//
//class C(val keywords : List<String>, val responses : List<String>) : Answerable{
//
//    private fun match(userInput: String): String {
//        var result : String = ""
//        for (kw in this.keywords) {
//            if (userInput.contains(kw)){
//                lastMatch = userInput
//                    .substring(userInput.indexOf(kw) + kw.length)
//                    .trim { it <= ' '}
//                result = kw
//            }
//        }
//        return result
//    }
//
//    override fun answer(priorResponse: String): String {
//        var response: String
//        do {
//            val i = responses.indices.random()
//            response = responses[i].replace(Answerable.condition, lastMatch)
//        } while (response == priorResponse)
//        return response
//    }
//}
