package com.twitter.meil_mitu.hkjson

import com.twitter.meil_mitu.kjson.StringData
import org.json.JSONObject

class JsonArrayData : IJson {

    override val hkjson = HKJson()

    val testJsonArrayVarKey = "test_json_array_var"
    var testJsonArrayVar: Array<StringData> by StringData.jsonArray(testJsonArrayVarKey)

    constructor() {
    }

    constructor(json: JSONObject) {
        hkjson.parse(json)
    }
}