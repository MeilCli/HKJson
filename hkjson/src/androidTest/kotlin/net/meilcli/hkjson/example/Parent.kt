package net.meilcli.hkjson.example

import net.meilcli.hkjson.HKJson
import net.meilcli.hkjson.IHKJson
import net.meilcli.hkjson.objects.HKJsonJson
import org.json.JSONObject

class Parent(json: JSONObject? = null) : IHKJson by HKJson(json) {
    // to Object : parseJson(JSONObject)
    // get JSONObject : makeJson()

    var name: String by string.json("name")
    var hasChild: Boolean by boolean.json("has_child")
    var children: Array<Child>? by Child.array.optional.json("children")
    var firstChild: Child? by Child.optional.json("first_child")
    // for not implemented Object
    var secondChild: Child? by HKJsonJson.optional.json("second_child", { Child() })
    // for malformation json
    var liveIn: String by HKJsonJson.custom.json("live_in", { json, key -> json.getString(key) }, { json, key, value -> json.put(key, value) })

}