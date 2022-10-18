//package handlers.interchanges
//
//private class Condition(
//    val keywords           : List<String>,
//    val responses          : List<String>,
//    val conditionResponses : List<String>)
//    : Answerable {
//
//    var condition: String = ""
//        private set
//    private var trigger = false
//
//    override fun match(userInput: String): String {
//        for (k in keywords) {
//            if (userInput.contains(k)) {
//                if (condition == null) {
//                    condition = userInput
//                        .substring(userInput.indexOf(k) + k.length)
//                        .trim { it <= ' ' }
//                    condition = if (condition!!.indexOf(" ") != -1) condition!!
//                        .substring(0, condition!!.indexOf(" ")) else condition
//                }
//                return k
//            }
//        }
//        return ""
//    }
//
//    override fun getResponse(priorResponse: String): String {
//        var response: String = ""
//        do {
//            if (trigger) {
//                response = conditionResponses[conditionResponses.indices.random()]
//                    .apply {
//                        replace(Answerable.condition, condition)
//                    }
//            }
//            }while (response == priorResponse)
//                trigger = true
//            return response
//
//    }
//}
//
