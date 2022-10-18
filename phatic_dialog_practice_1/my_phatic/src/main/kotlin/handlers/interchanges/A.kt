package handlers.interchanges

import handlers.ChatBot.Companion.priorResponse

class A(
    private val inputs: List<String>,
    private val answers: List<String>
    ) : Answerable
{

    private fun match(input: String): Boolean {
        var isMatch = false
        for (kw in inputs) {
            if (input.contains(kw))
                isMatch = true
        }
        return isMatch
    }

    override fun answer(input: String): String? {
        return if (match(input))
            answers.shuffled().first { it != priorResponse }
        else null
    }
}