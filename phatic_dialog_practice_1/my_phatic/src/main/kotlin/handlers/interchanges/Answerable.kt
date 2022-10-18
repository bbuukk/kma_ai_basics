package handlers.interchanges

interface Answerable {

    companion object{
        const val condition : String = "|con|"
    }

    fun answer(input : String) : String?
}