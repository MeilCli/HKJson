package net.meilcli.hkjson

import net.meilcli.hkjson.objects.Json
import org.json.JSONObject

class JsonObjectData(json: JSONObject? = null) : IJson by HKJson(json) {


    val testJsonObjectVarKey = "test_json_object_var"
    var testJsonObjectVar: StringData by Json.json(testJsonObjectVarKey, { StringData() })

}