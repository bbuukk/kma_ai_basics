package handlers.testing

////Strategy
//interface Platwo {
//    fun answerTo(userInput : String)
//}
//
////todo flyWithWings class
//class AnswerBehavior() : Answerable {
//    override fun answerTo(userInput: String) {
//        println("")
//    }
//}
//
//
////todo Duck class
//open class Answer(protected var answerBehavior : AnswerBehavior){
//    open fun performAnswer(){
//        answerBehavior.answerTo("")
//    }
//}
//
//// todo mallard duck
//class FirstTypeAnswer(answerBehavior: AnswerBehavior)
//    : Answer(answerBehavior) {
//
//    override fun performAnswer(){
//        answerBehavior.answerTo()
//    }

//Strategy
interface Platform {
    fun play()
}

class Music : Platform{
    override fun play() {
        println("playing music")
    }
}

class Video : Platform{
    override fun play() {
        println("playing video")
    }
}

class Player(){
    fun play(platform: Platform){
        platform.play()
    }
}

fun main() {
    val player = Player()
    player.play(Music())
}


val responses = listOf<String>(
    "greetings", "hi", "howdy", "welcome",
    "bonjour", "buenas noches", "buenos dias", "good day", "good morning",
    "hey", "hi-ya", "how are you", "how goes it", "howdy-do", "shalom",
    "what's happening", "Zdoroven`ki buly`"
)