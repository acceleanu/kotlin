package com.deltapunkt.kotlin

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializerProvider
import com.fasterxml.jackson.databind.module.SimpleModule
import java.math.BigDecimal
import java.math.RoundingMode

class RoundingSerializer : JsonSerializer<Double?>() {
    override fun serialize(
        value: Double?,
        gen: JsonGenerator?,
        serializers: SerializerProvider?
    ) {
        value?.let {
            gen?.writeNumber(BigDecimal(it).setScale(2, RoundingMode.HALF_UP))
        }
    }
}

object JsonUtil {
    private val mapper = ObjectMapper().registerModule(
            SimpleModule()
                    .addSerializer(Double::class.javaObjectType, RoundingSerializer())
                    .addSerializer(Double::class.java, RoundingSerializer())
    )

    val fromJson: (String) -> List<Map<String, Any>> = {
        mapper
                .readValue(it, object : TypeReference<List<Map<String, Any>>>() {})
    }

    val fromJsonMap: (String) -> Map<String, Any> = {
        mapper
                .readValue(it, object : TypeReference<Map<String, Any>>() {})
    }

    val toJson: (Any) -> String = {
        mapper
                .writeValueAsString(it)
    }
}
