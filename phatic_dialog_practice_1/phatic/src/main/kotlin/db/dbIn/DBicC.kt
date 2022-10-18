package db.dbIn

import interchanges.Answerable
import interchanges.С

class DBicC {

    companion object {
        fun getInterchanges(): MutableList<С> {
            val interchanges = mutableListOf<С>()

            interchanges.add(
                С(
                    listOf(" ти ", " ти дуже "," ти є "),
                    listOf( "То ти думаєш, що  я ${Answerable.condition}" ,
                        "Я не ${Answerable.condition}",
                        "Можливо, я ${Answerable.condition}"))
            )

            interchanges.add(
                С(
                    listOf(" я ", " я є "),
                    listOf( "Так, ти є ${Answerable.condition}"))
            )

            interchanges.add(
                С(
                    listOf(" мені подобається "),
                    listOf( "Так, тобі подобається  ${Answerable.condition}" ,
                        "Наскільки тобі подобається  ${Answerable.condition}",
                        "Чому тобі подобається ${Answerable.condition}"))
            )

            interchanges.add(
                С(
                    listOf(" я люблю "),
                    listOf( "Так ти любиш ${Answerable.condition}" ,
                        "Наскільки ти любиш ${Answerable.condition}",
                        "Чому ти любиш ${Answerable.condition}"))
            )

            return interchanges
        }
    }
}