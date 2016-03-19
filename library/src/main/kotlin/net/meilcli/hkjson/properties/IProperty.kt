package net.meilcli.hkjson.properties

import org.json.JSONException
import org.json.JSONObject

interface IProperty {
    val key: String

    @Throws(JSONException::class)
    fun put(json: JSONObject)

    @Throws(JSONException::class)
    fun init(json: JSONObject)

}