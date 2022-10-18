package db.dbIn

import interchanges.Answerable
import interchanges.E

class DBicE {

    companion object {
        fun getInterchanges(): MutableList<Answerable> {
            val interchanges = mutableListOf<Answerable>()

            interchanges.add(
                E(
                    listOf(
                        " комп'ютери ", " люблю "),
                    listOf(
                        "Ви маєте здібності до техніки.",
                        "Що ви ще любите?",
                    )
                )
            )

            interchanges.add(
                E(
                    listOf(
                        " автівку ", " купити "),
                    listOf(
                        "Авто є необхідністю.",
                        "А гроші у тебе на то є?",
                    )
                )
            )

            interchanges.add(
                E(
                    listOf(
                        " мур ", " мяу "),
                    listOf(
                        " Любите котів, та?",
                        " Дуже любите котів.",
                    )
                )
            )

            interchanges.add(
                E(
                    listOf(
                        " гроші ", " мав би "),
                    listOf(
                        "Заробити можна всюди, тяжка праця тіко ще треба",
                        "Мав би! Ото так казати будеш, ніколи не матимеш!",
                    )
                )
            )

            return interchanges
        }
    }
}