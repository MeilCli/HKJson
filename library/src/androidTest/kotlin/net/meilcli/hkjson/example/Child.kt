package net.meilcli.hkjson.example

import net.meilcli.hkjson.HKJson
import net.meilcli.hkjson.IJson
import net.meilcli.hkjson.IJsonArray
import net.meilcli.hkjson.IJsonObject
import net.meilcli.hkjson.objects.DateJson
import net.meilcli.hkjson.objects.StringJson
import org.json.JSONObject
import java.util.*

class Child(json: JSONObject? = null) : IJson by HKJson(json) {


    val name: String by StringJson.json("child_name")
    val birthDay: Date by DateJson.json("child_birth_day")
    var parentName: String? by StringJson.jsonOptional("parent_name")

    // for IJsonObject, IJsonArray interface and creators
    companion object : IJsonObject<Child>, IJsonArray<Child> {

        override fun creator(): () -> Child {
            return { Child() }
        }

        override fun arrayCreator(): (Int) -> Array<Child> {
            return { i -> Array(i, { i -> Child() }) }
        }
    }
}