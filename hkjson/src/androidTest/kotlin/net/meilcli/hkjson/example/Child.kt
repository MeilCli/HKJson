package net.meilcli.hkjson.example

import net.meilcli.hkjson.HKJson
import net.meilcli.hkjson.IHKJson
import net.meilcli.hkjson.IJsonArray
import net.meilcli.hkjson.IJsonObject
import org.json.JSONObject
import java.util.*

class Child(json: JSONObject? = null) : IHKJson by HKJson(json) {


    val name: String by string.json("child_name")
    val birthDay: Date by date.json("child_birth_day")
    var parentName: String? by string.optional.json("parent_name")

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