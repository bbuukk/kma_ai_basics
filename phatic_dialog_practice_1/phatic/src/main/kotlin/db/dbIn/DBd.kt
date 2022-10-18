package db.dbIn

class DBd {

    companion object {
        fun getNullOutputPhrases(): List<String> {
            return listOf(
                "Я вас не дуже розумію",
                "Не будьте такими небагатослівними",
                "Для вас це має велике значення, чому?",
                "Що ви маєте на увазі?",
                "Мені нічого це не говорить, перефразуйте будь ласка"
            )
        }

        fun getNullInputPhrases(): List<String> {
            return listOf(
                "ало",
                "Дев'ять чи десять?",
                "Дев'ять?",
                "Десять?",
                "Баба не чує, глуха як тетеря")
        }
    }
}