package handlers

//Strategy
interface Answer {
    fun answerTo(userInput : String)
}

class a() : Answer{
    override fun answerTo(userInput : String) {
        TODO("Not yet implemented")
    }
}