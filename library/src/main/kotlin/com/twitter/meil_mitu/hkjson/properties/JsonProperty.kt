package com.twitter.meil_mitu.hkjson.properties

import com.twitter.meil_mitu.hkjson.IJson
import org.json.JSONObject
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

open class JsonProperty<T>(
        key: String,
        val initter: (JSONObject, String) -> T,
        val putter: (JSONObject, String, T) -> Unit) :
        ReadWriteProperty<IJson, T>, ReadOnlyProperty<IJson, T>, IProperty {

    override val key: String
    internal var t: T? = null

    init {
        this.key = key
    }

    override fun init(json: JSONObject) {
        t = initter(json, key)
    }

    override fun put(json: JSONObject) {
        require(t != null) { "must init json" }
        putter(json, key, t!!)
    }

    override fun getValue(thisRef: IJson, property: KProperty<*>): T {
        require(t != null) { "must init json" }
        return this.t!!
    }

    override fun setValue(thisRef: IJson, property: KProperty<*>, value: T) {
        this.t = value
    }

}