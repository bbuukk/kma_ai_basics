package interchanges

import ChatBot.Companion.priorResponse

class E(
    val inputs: List<String>,
    val answers: List<String>
) : Answerable
{

    private fun match(input: String, i: Int): Boolean {
        var isMatch = false

        if (input.contains(inputs[i])) {
            isMatch = true

        }
        return isMatch
    }


    override fun answer(input: String): String? {

        var answer: String = ""
        for (i in 0..inputs.size - 1) {
            if(match(input, i)){
                answer += answers[i]
            }
        }


        return if(!answer.isEmpty())
            answer.trim()
        else
            null
    }
}