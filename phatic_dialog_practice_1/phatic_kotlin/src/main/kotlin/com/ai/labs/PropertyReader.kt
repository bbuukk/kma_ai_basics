package com.ai.labs

import java.io.File
import java.io.FileInputStream
import java.util.*

class PropertyReader private constructor() {
    @JvmOverloads
    fun readValue(key: String?, defaultValue: String? = null): String {
        return properties.getProperty(key, defaultValue)
    }

    private fun copyValues(source: Properties, overwrite: Boolean = false) {
        for (key in source.stringPropertyNames()) {
            if (overwrite || !properties.containsKey(key)) {
                properties.setProperty(key, source.getProperty(key))
            }
        }
    }

    private fun fromPath(path: String): Properties {
        val properties = Properties()
        val file: String
        try {
            file = Objects.requireNonNull(PropertyReader::class.java.classLoader.getResource(path)).file
            properties.load(FileInputStream(File(file)))
        } catch (e: Exception) {
            throw RuntimeException("Cannot find properties file: env.properties", e)
        }
        return properties
    }

    companion object {
        private val properties = Properties()
        private val INSTANCE = PropertyReader()
        fun get(): PropertyReader {
            return INSTANCE
        }
    }

    init {
        copyValues(fromPath("configurations.properties"), true)
    }
}
