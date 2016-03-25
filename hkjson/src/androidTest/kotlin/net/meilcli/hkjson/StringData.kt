package net.meilcli.hkjson

import net.meilcli.hkjson.objects.StringJson
import org.json.JSONObject

class StringData(json: JSONObject? = null) : IHKJson by HKJson(json) {

    val testStringValKey = "test_string_val"
    val testStringVal: String by StringJson.json(testStringValKey)
    val testStringVarKey = "test_string_var"
    var testStringVar by string.json(testStringVarKey) // type is omitted
    val testOptionalStringValKey = "test_optional_string_val"
    val testOptionalStringVal: String? by string.optional.json(testOptionalStringValKey)
    val testOptionalStringVarKey = "test_optional_string_var"
    var testOptionalStringVar by string.optional.json(testOptionalStringVarKey)
    val testDefaultVal by string.json("test_default_value", "")

    companion object : IJsonArray<StringData> {

        override fun arrayCreator(): (Int) -> Array<StringData> {
            return { i -> Array(i, { i -> StringData() }) }
        }

    }
}