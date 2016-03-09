package com.twitter.meil_mitu.hkjson.example

import com.twitter.meil_mitu.hkjson.HKJson
import com.twitter.meil_mitu.hkjson.IJson
import com.twitter.meil_mitu.hkjson.objects.BooleanJson
import com.twitter.meil_mitu.hkjson.objects.Json
import com.twitter.meil_mitu.hkjson.objects.StringJson
import org.json.JSONObject

class Parent(json: JSONObject? = null) : IJson by HKJson(json) {
    // to Object : parseJson(JSONObject)
    // get JSONObject : makeJson()

    var name: String by StringJson.json("name")
    var hasChild: Boolean by BooleanJson.json("has_child")
    var children: Array<Child>? by Child.jsonOptionalArray("children")
    var firstChild: Child? by Child.jsonOptionalObject("first_child")
    // for not implemented Object
    var secondChild: Child? by Json.jsonOptional("second_child", { Child() })
    // for malformation json
    var liveIn: String by Json.jsonCustom(
            "live_in", { json, key -> json.getString(key) }, { json, key, value -> json.put(key, value) })

}