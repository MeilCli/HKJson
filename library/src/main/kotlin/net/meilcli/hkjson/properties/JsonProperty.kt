package net.meilcli.hkjson.properties

import net.meilcli.hkjson.IJson
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
        require(t != null) { "put value is must init json key:$key" }
        putter(json, key, t!!)
    }

    override fun getValue(thisRef: IJson, property: KProperty<*>): T {
        require(t != null) { "get value is must init json key:$key" }
        return this.t!!
    }

    override fun setValue(thisRef: IJson, property: KProperty<*>, value: T) {
        this.t = value
    }

}