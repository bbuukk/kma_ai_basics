package interchanges

import ChatBot.Companion.priorResponse

class A(
     val inputs: List<String>,
     val answers: List<String>
    ) : Answerable
{

    private fun match(input: String): Boolean {
        var isMatch = false
        for (kw in inputs) {
            if (input.contains(kw)) {
                isMatch = true
                break
            }
        }
        return isMatch
    }

    override fun answer(input: String): String? {
        return try {
            if (match(input))
                answers.shuffled().first { it != priorResponse }
            else null
        }catch (noSuchElementException : NoSuchElementException){
            priorResponse
        }
    }
}