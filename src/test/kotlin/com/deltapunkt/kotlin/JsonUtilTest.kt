package com.deltapunkt.kotlin

import com.deltapunkt.kotlin.JsonUtil.toJson
import org.junit.jupiter.api.Test
import org.skyscreamer.jsonassert.JSONAssert.assertEquals

class JsonUtilTest {
    @Test
    fun testJsonFormatter() {
        val givenInput = mapOf(
            "l1-0-string" to "some string 0",
            "l1-1-map" to mapOf(
                "l2-1-list" to listOf(
                    mapOf(
                        "l3-1-string" to "some string 1",
                        "val2" to 1.369999999999,
                        "val3" to 2.6543,
                        "val4" to 3.12535,
                        "l3-5-string" to "some string 5",
                        "val6" to 0.02354,
                        "l3-7-string" to "some string 7",
                    )
                )
            ),
            "l1-2-map" to mapOf(
                "l2-0-string" to "some string 0",
                "val1" to 1.02354,
                "l2-2-string" to "some string 2",
                "val3" to 0.1234,
                "val4" to 0.3800000000000003
            ),
            "l1-3-string" to "some string 3",
            "val1" to 1.123456789E7
        )

        val expectedOutput = mapOf(
            "l1-0-string" to "some string 0",
            "l1-1-map" to mapOf(
                "l2-1-list" to listOf(
                    mapOf(
                        "l3-1-string" to "some string 1",
                        "val2" to 1.37,
                        "val3" to 2.65,
                        "val4" to 3.13,
                        "l3-5-string" to "some string 5",
                        "val6" to 0.024,
                        "l3-7-string" to "some string 7",
                    )
                )
            ),
            "l1-2-map" to mapOf(
                "l2-0-string" to "some string 0",
                "val1" to 1.02,
                "l2-2-string" to "some string 2",
                "val3" to 0.12,
                "val4" to 0.38
            ),
            "l1-3-string" to "some string 3",
            "val1" to 11234567.89
        )

        println(toJson(givenInput))

        assertEquals(
            toJson(expectedOutput),
            toJson(givenInput),
            false
        )
    }
}