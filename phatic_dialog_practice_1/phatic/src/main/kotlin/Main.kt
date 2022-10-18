import db.dbIn.DBicA
import db.dbIn.DBicB
import interchanges.Answerable

var DEBUG : Boolean = false

fun main() {

    println("Ну скажи щось")

    if (DEBUG) {
        val testInputs : List<String> =
            listOf("Слава Україні!", "Як сямаєш?",
                "А у мене гаразд усе", "Вже давно мрію автівку купити",
                "Немає", "Де б це заробити гроші?",
                "Ото мав би, то вже давно жив у розкоші", "Видко, занадто ти розумний",
                "Піду на природу, прогуляюсь", "Бувай")

        println("==================================================")
        val test = ChatBot()
        for (input in testInputs) {
            println("INPUT ---> $input")
            println("OUTPUT ----> ${test.answerTo(input)}")
            println("==================================================")

        }
}

    if(!DEBUG) {
        var answer: String = ""
        val dzhuls = ChatBot()

        while (dzhuls.toBeContinued) {
            answer = dzhuls.answerTo(readLine())
            println(answer)
        }
    }
    return

}