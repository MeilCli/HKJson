package net.meilcli.hkjson.example

import net.meilcli.hkjson.HKJson
import net.meilcli.hkjson.IJson
import net.meilcli.hkjson.objects.BooleanJson
import net.meilcli.hkjson.objects.Json
import net.meilcli.hkjson.objects.StringJson
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