package com.twitter.meil_mitu.hkjson.example

import com.twitter.meil_mitu.hkjson.HKJson
import com.twitter.meil_mitu.hkjson.IJson
import org.json.JSONObject

class Parent : IJson {
    // to Object : hkjson.parse(JSONObject)
    // get JSONObject : hkjson.make()
    override val hkjson = HKJson()

    var name: String by jsonString("name")
    var hasChild: Boolean by jsonBoolean("has_child")
    var children: Array<Child>? by Child.jsonOptionalArray("children")
    var firstChild: Child? by Child.jsonOptionalObject("first_child")
    // for not implemented Object
    var secondChild: Child? by jsonOptionalObject("second_child", { Child() })
    // for malformation json
    var liveIn: String by jsonCustom(
            "live_in", { json, key -> json.getString(key) }, { json, key, value -> json.put(key, value) })

    constructor(obj: JSONObject) {
        hkjson.parse(obj)
    }

}