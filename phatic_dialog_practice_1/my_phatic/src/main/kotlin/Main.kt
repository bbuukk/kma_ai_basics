import handlers.ChatBot
import handlers.TestException

fun main() {

    //todo wait for five sec without trigger, then spit out "Say smth, cmon"
    println("Say someting, cmon")

    val dzhuls : ChatBot = ChatBot()
    var answer : String = ""

    while(dzhuls.toBeContinued){
        try{

            answer = dzhuls.answerTo(readLine())
            println(answer)

        }catch (exception : TestException){
            println(exception.message)
        }
    }

    println()
    println("*You ran away*")
}