package com.ai.labs.handlers

val modalVerbs = listOf("need", "might", "may", "can", "could", "will", "would", "ought", "should", "must", "shall", "should", "have", "had", "dare","mayn’t", "mustn’t", "shouldn’t","won’t","shan’t","can’t")


fun modalHandler(sentence : String) : String {
    val clearSent = sentence.replace(".", "").replace(",", "").replace("  ", " ").toLowerCase()
    val listOfWords = clearSent.split(" ")
    var readyModal = findModal(listOfWords)
    return generateAnswer(readyModal)
}

fun findModal(splittedSentence:List<String>) : MutableList<String> {
    var result = mutableListOf<String>()
    for (i in modalVerbs.indices) {
        if(modalVerbs[i] in splittedSentence){

            if(splittedSentence[splittedSentence.indexOf(modalVerbs[i])+1]=="to"||splittedSentence[splittedSentence.indexOf(modalVerbs[i])+1]=="not" ){
                result.add(modalVerbs[i] +" " + splittedSentence[splittedSentence.indexOf(modalVerbs[i])+1])
                result.add(splittedSentence[splittedSentence.indexOf(modalVerbs[i])+2])
            } else{
                result.add(modalVerbs[i])
                result.add(splittedSentence[splittedSentence.indexOf(modalVerbs[i])+1])
            }

        }

    }
    return result
}

fun generateAnswer(modalsList : List<String>) : String {
    if(modalsList.size > 2){
        var result = mutableListOf<String>()
         for(i in modalsList.indices){
             if(i%2!=0){
                 result.add(formAnswer(modalsList[i-1],modalsList[i]))
             }
         }

        return result.random()
    }else {
         return formAnswer(modalsList[0],modalsList[1])
    }

}

fun formAnswer(modal : String,verb : String) : String {

    return listOf(
        "Are you sure that you $modal?",
        "Oh yeah you $modal $verb)",
        "Why do you $modal $verb?",
        "What's mean your \"$modal $verb\"?",
        "You really $modal $verb",
        "You want me to help you?",
        "I don't understand, you $modal $verb ${listOf<String>("me","this","that").random()}?"
    ).random()
}