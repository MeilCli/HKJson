package com.twitter.meil_mitu.hkjson.example

import com.twitter.meil_mitu.hkjson.HKJson
import com.twitter.meil_mitu.hkjson.IJson
import com.twitter.meil_mitu.hkjson.IJsonArray
import com.twitter.meil_mitu.hkjson.IJsonObject
import org.json.JSONObject
import java.util.*

class Child : IJson {

    override val hkjson = HKJson()

    val name: String by jsonString("child_name")
    val birthDay: Date by jsonDate("child_birth_day")
    var parentName: String? by jsonOptionalString("parent_name")

    // for IJsonObject, IJsonArray interface and creators
    constructor() {
    }

    constructor(obj: JSONObject) {
        hkjson.parse(obj)
    }

    companion object : IJsonObject<Child>, IJsonArray<Child> {

        override fun creator(): () -> Child {
            return { Child() }
        }

        override fun arrayCreator(): (Int) -> Array<Child> {
            return { i -> Array(i, { i -> Child() }) }
        }
    }
}