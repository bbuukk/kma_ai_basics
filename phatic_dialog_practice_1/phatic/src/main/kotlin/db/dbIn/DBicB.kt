package db.dbIn

import interchanges.A
import interchanges.Answerable
import interchanges.B
import interchanges.С

class DBicB {

    companion object {
        fun getInterchanges(): MutableList<B> {
            val interchanges = mutableListOf<B>()

            interchanges.add(
                B(
                    listOf(" яблука "),
                    listOf(
                        "Я люблю саме червоні яблука.",
                        "Червоні яблука найкращі",
                        "Іноді я можу з\'їсти зелене," +
                                " але люблю червоні яблука"
                    )
                )
            )

            interchanges.add(
                B(
                    listOf(
                        " бувай ", " пока ",
                        " до побачення ", " будь здоров "
                    ),
                    listOf(
                        " Давай ", " Пока ",
                        " Бувай ", " Не хворай"
                    )
                )
            )

            interchanges.add(
                B(
                    listOf(" природу ", "природа"),
                    listOf(
                        "Люблю природу, особливо природу України",
                        "Розмовляючи про природу не можу не згадати " +
                                " мою відпустку в Грузії, ото природа",
                        "Іноді і мене тягне до природи," +
                                " до дерев, до трави, до зелені"
                    )
                )
            )

            return interchanges
        }
    }
}