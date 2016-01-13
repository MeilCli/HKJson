package com.twitter.meil_mitu.hkjson

import com.twitter.meil_mitu.kjson.StringData
import org.json.JSONObject

class JsonObjectData : IJson {

    override val hkjson = HKJson()

    val testJsonObjectVarKey = "test_json_object_var"
    var testJsonObjectVar: StringData by jsonObject(testJsonObjectVarKey, { StringData() })

    constructor() {
    }

    constructor(json: JSONObject) {
        hkjson.parse(json)
    }
}