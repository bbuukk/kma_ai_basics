import handlers.ChatBot

fun main() {

    //todo wait for five sec without trigger, then spit out "Say smth, cmon"
    println("Say someting, cmon")

    val dzhuls : ChatBot = ChatBot()
    var answer : String = ""

    while(dzhuls.toBeContinued){
            answer = dzhuls.answerTo(readLine())
            println(answer)
        return
    }
}