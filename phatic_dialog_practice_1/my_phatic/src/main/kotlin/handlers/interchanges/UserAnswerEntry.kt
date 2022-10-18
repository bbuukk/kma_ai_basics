//package handlers.interchanges
//
//private class UserAnswerEntry(
//    keywords: Array<String?>?, responses: Array<String?>?,
//    noConditionResponses: Array<String>, ce: Bot.ConditionEntry
//) : Bot.CategoryEntry(keywords, responses) {
//    private val ce: Bot.ConditionEntry
//    private val noConditionResponses: Array<String>
//
//    init {
//        this.ce = ce
//        this.noConditionResponses = noConditionResponses
//    }
//
//    override fun getRandomResponse(prevResponse: String): String {
//        var response: String
//        val condition: String = ce.getCondition()
//        do {
//            if (condition != null) {
//                response = super.responses.get((Math.random() * super.responses.size).toInt())
//                response = response.replace(Bot.CONDITION_STRING, condition)
//                val lastChar = response[response.length - 1]
//                if (lastChar != '.' && lastChar != '!' && lastChar != '?') response += "."
//            } else response = noConditionResponses[(Math.random() * noConditionResponses.size).toInt()]
//        } while (response == prevResponse)
//        return response
//    }
//}