//todo category entry
//{
//    val keywords = arrayOf(" як ", " чому ", " що ", " що таке ")
//    val responses = arrayOf(
//        "Звідки мені це знати?",
//        "Ти завжди ставиш стільки питань?",
//        "Я не знаю.",
//        "Я знав, але забув."
//    )
//    val ce: Bot.CategoryEntry = Bot.CategoryEntry(keywords, responses)
//    database.get(index++) = ce
//}

//todo selective entry

//{
//    val keywords = arrayOf(" я не можу .{3,} ", " я не в змозі .{3,} ")
//    val responses = arrayOf(
//        "Чому ні?", "Ти впевнений?",
//        "Чому ти не можеш " + Bot.CONDITION_STRING
//    )
//    val ce: Bot.SelectiveEntry = Bot.SelectiveEntry(keywords, responses)
//    database.get(index++) = ce
//}

//todo special entry

//{
//    val keywords = arrayOf(" мені потрібно ", " я вимагаю ")
//    val responses = arrayOf(
//        "Чому тобі потрібно " + Bot.CONDITION_STRING,
//        "Для чого тобі потрібно " + Bot.CONDITION_STRING
//    )
//    val ce: Bot.SpecialEntry = Bot.SpecialEntry(keywords, responses)
//    database.get(index++) = ce
//}

//todo noConditionResponse

//{
//    val keywords = arrayOf(" як тебе звати", "твоє ім’я")
//    val responses = arrayOf(
//        "Мене звати Фотя :) Я знаю, що тебе звати "
//                + Bot.CONDITION_STRING, "Мене звати Фотя, як тебе звати "
//                + Bot.CONDITION_STRING
//    )
//    val noConditionResponses = arrayOf("Мене звати Фотя :).")
//    val ce: Bot.UserAnswerEntry = Bot.UserAnswerEntry(
//        keywords, responses,
//        noConditionResponses, nameCE
//    )
//    database.get(index++) = ce
//}

//todo userAnswerEntry

//{
//    val keywords = arrayOf(" як мене звати ", " ти знаєш моє ім’я ")
//    val responses = arrayOf(
//        "Тебе звати " + Bot.CONDITION_STRING, "Звісно, ти казав, що твоє ім’я — "
//                + Bot.CONDITION_STRING,
//        "Ти щойно сказв, що тебе звати " + Bot.CONDITION_STRING
//    )
//    val noConditionResponses = arrayOf(
//        "Я не знаю, ти не казав.",
//        "Звідки мені знати, ти ніколи не казав.",
//        "Я не знаю, а як тебе звати?"
//    )
//    val ce: Bot.UserAnswerEntry = Bot.UserAnswerEntry(
//        keywords, responses,
//        noConditionResponses, nameCE
//    )
//    database.get(index++) = ce
//}

//todo conditionEntry

//{
//    val keywords = arrayOf("мене звати ", " моє ім’я")
//    val responses = arrayOf(
//        "Приємно познайомитись!", "Гарне ім’я.",
//        "Дуже радий знайомству :)."
//    )
//    val conditionResponses = arrayOf(
//        "Ти вже казав мені своє  ім’я, "
//                + Bot.CONDITION_STRING,
//        "Я знаю як тебе звати " + Bot.CONDITION_STRING,
//        "Я знаю " + Bot.CONDITION_STRING + ", ти казав раніше."
//    )
//    nameCE = Bot.ConditionEntry(keywords, responses, conditionResponses)
//    database.get(index++) = nameCE
//}