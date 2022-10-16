package com.ai.labs

class Configurations {

    companion object {
        private fun read(value: String): String? {
            return PropertyReader.get().readValue(value)
        }

        fun getPersonAnswerTemplates() : String? {
            return read("personAnswerTemplates")
        }
        fun getNumberAnswerTemplates(): String? {
            return read("numberAnswerTemplates")
        }
        fun getDateAnswerTemplates() : String? {
            return read("dateAnswerTemplates")
        }
        fun gerOrganizationAnswerTemplates() : String? {
            return read("organizationAnswerTemplates")
        }
        fun getCountryAnswerTemplates() : String? {
            return read("countryAnswerTemplates")
        }
        fun getCityAnswerTemplates() : String? {
            return read("cityAnswerTemplates")
        }
        fun getTimeAnswerTemplates() : String? {
            return read("timeAnswerTemplates")
        }
        fun getMoneyAnswerTemplates() : String? {
            return read("moneyAnswerTemplates")
        }
        fun getNationalityAnswerTemplates() : String? {
            return read("nationalityAnswerTemplates")
        }
    }
}