package net.meilcli.hkjson

import net.meilcli.hkjson.objects.HKJsonJson
import org.json.JSONObject

class JsonObjectData(json: JSONObject? = null) : IHKJson by HKJson(json) {


    val testJsonObjectVarKey = "test_json_object_var"
    var testJsonObjectVar: StringData by HKJsonJson.json(testJsonObjectVarKey, { StringData() })

}