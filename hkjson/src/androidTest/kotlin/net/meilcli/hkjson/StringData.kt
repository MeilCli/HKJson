package net.meilcli.hkjson

import net.meilcli.hkjson.objects.StringJson
import org.json.JSONObject

class StringData(json: JSONObject? = null) : IJson by HKJson(json) {

    val testStringValKey = "test_string_val"
    val testStringVal: String by StringJson.json(testStringValKey)
    val testStringVarKey = "test_string_var"
    var testStringVar by StringJson.json(testStringVarKey) // type is omitted
    val testOptionalStringValKey = "test_optional_string_val"
    val testOptionalStringVal: String? by StringJson.jsonOptional(testOptionalStringValKey)
    val testOptionalStringVarKey = "test_optional_string_var"
    var testOptionalStringVar by StringJson.jsonOptional(testOptionalStringVarKey)

    companion object : IJsonArray<StringData> {

        override fun arrayCreator(): (Int) -> Array<StringData> {
            return { i -> Array(i, { i -> StringData() }) }
        }

    }
}