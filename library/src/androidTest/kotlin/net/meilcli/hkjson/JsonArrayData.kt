package net.meilcli.hkjson

import org.json.JSONObject

class JsonArrayData(json: JSONObject? = null) : IJson by HKJson(json) {


    val testJsonArrayVarKey = "test_json_array_var"
    var testJsonArrayVar: Array<StringData> by StringData.jsonArray(testJsonArrayVarKey)

}