package net.meilcli.hkjson

import org.json.JSONObject

class JsonArrayData(json: JSONObject? = null) : IHKJson by HKJson(json) {


    val testJsonArrayVarKey = "test_json_array_var"
    var testJsonArrayVar: Array<StringData> by StringData.array.json(testJsonArrayVarKey)

}