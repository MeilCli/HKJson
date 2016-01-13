package com.twitter.meil_mitu.kjson

import com.twitter.meil_mitu.hkjson.HKJson
import com.twitter.meil_mitu.hkjson.IJson
import com.twitter.meil_mitu.hkjson.IJsonArray
import org.json.JSONObject

class StringData : IJson {

    override val hkjson = HKJson()

    val testStringValKey = "test_string_val"
    val testStringVal: String by jsonString(testStringValKey)
    val testStringVarKey = "test_string_var"
    var testStringVar: String by jsonString(testStringVarKey)
    val testOptionalStringValKey = "test_optional_string_val"
    val testOptionalStringVal: String? by jsonOptionalString(testOptionalStringValKey)
    val testOptionalStringVarKey = "test_optional_string_var"
    var testOptionalStringVar: String? by jsonOptionalString(testOptionalStringVarKey)

    constructor() {
    }

    constructor(json: JSONObject) {
        hkjson.parse(json)
    }

    companion object : IJsonArray<StringData> {

        override fun arrayCreator(): (Int) -> Array<StringData> {
            return { i -> Array(i, { i -> StringData() }) }
        }

    }
}