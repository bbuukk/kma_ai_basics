package com.ai.labs.handlers

import com.ai.labs.Configurations
import com.ai.labs.answerTemplates.noAnswer
import edu.stanford.nlp.coref.data.CorefChain
import edu.stanford.nlp.ie.util.RelationTriple
import edu.stanford.nlp.pipeline.CoreDocument
import edu.stanford.nlp.pipeline.StanfordCoreNLP
import edu.stanford.nlp.simple.Sentence
import edu.stanford.nlp.trees.Tree
import java.util.*

fun entityHandler(sentence: Sentence, type : String, answersTemplate : String) : String {
    val nerTags = sentence.nerTags()
    if (nerTags.all { it == "0" }) return noAnswer.random()
    val entities = sentence.words().zip(nerTags).filter { it.second == type }.toMap().keys
    val answers = answersTemplate.replace("*", entities.random()).split(";").filter { !it.isBlank() || it.isNotEmpty() }
    return answers.random()
}

fun defineEntityGroupAndAnswer(sentence: Sentence) : String {
    return when {
        sentence.nerTags().contains("PERSON") -> entityHandler(sentence, "PERSON", Configurations.getPersonAnswerTemplates().toString())
        sentence.nerTags().contains("NUMBER") -> entityHandler(sentence, "NUMBER", Configurations.getNumberAnswerTemplates().toString())
        sentence.nerTags().contains("DATE") -> entityHandler(sentence, "DATE", Configurations.getDateAnswerTemplates().toString())
        sentence.nerTags().contains("ORGANIZATION") -> entityHandler(sentence, "ORGANIZATION", Configurations.gerOrganizationAnswerTemplates().toString())
        sentence.nerTags().contains("COUNTRY") -> entityHandler(sentence, "COUNTRY", Configurations.getCountryAnswerTemplates().toString())
        sentence.nerTags().contains("CITY") -> entityHandler(sentence, "CITY", Configurations.getCityAnswerTemplates().toString())
        sentence.nerTags().contains("TIME") -> entityHandler(sentence, "TIME", Configurations.getTimeAnswerTemplates().toString())
        sentence.nerTags().contains("NATIONALITY") -> entityHandler(sentence, "NATIONALITY", Configurations.getNationalityAnswerTemplates().toString())
        sentence.nerTags().contains("MONEY") -> entityHandler(sentence, "MONEY", Configurations.getMoneyAnswerTemplates().toString())
        else -> noAnswer.random()
    }
}


