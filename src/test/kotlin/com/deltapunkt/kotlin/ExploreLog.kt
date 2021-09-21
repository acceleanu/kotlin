package com.deltapunkt.kotlin

import mu.KotlinLogging
import mu.withLoggingContext
import org.junit.jupiter.api.Test

class ExploreLog {
    private val Log = KotlinLogging.logger { }

    @Test
    fun exploreLog() {
        withLoggingContext("correlationId" to "cid_${System.nanoTime()}") {
            Log.info { "Inside logging context" }
            Log.debug { "This is DEBUG" }
            Log.warn { "This is WARN" }
            Log.info { "This is INFO" }
            Log.error { "This is ERROR" }
        }
        Log.info { "No more logging context after this line" }
        Log.warn { "This is WARN" }
        Log.info { "This is INFO" }
        Log.error { "This is ERROR" }
    }
}
