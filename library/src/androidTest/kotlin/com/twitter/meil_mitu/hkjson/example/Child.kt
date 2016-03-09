package com.twitter.meil_mitu.hkjson.example

import com.twitter.meil_mitu.hkjson.HKJson
import com.twitter.meil_mitu.hkjson.IJson
import com.twitter.meil_mitu.hkjson.IJsonArray
import com.twitter.meil_mitu.hkjson.IJsonObject
import com.twitter.meil_mitu.hkjson.objects.DateJson
import com.twitter.meil_mitu.hkjson.objects.StringJson
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