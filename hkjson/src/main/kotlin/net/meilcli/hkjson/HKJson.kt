package net.meilcli.hkjson

import net.meilcli.hkjson.objects.*
import net.meilcli.hkjson.properties.IProperty
import net.meilcli.hkjson.properties.JsonProperty
import net.meilcli.hkjson.properties.OptionalJsonProperty
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

// have extensibility
open class HKJson(json: JSONObject? = null) : IHKJson {

    protected val properties = ArrayList<IProperty<*>>()
    protected var rootJsonObject: JSONObject?

    init {
        this.rootJsonObject = json
    }

    @Throws(JSONException::class)
    override fun parseJson(json: JSONObject) {
        for (p in properties) {
            p.init(json)
        }
    }

    @Throws(JSONException::class)
    override fun makeJson(): JSONObject {
        val json = JSONObject()
        for (p in properties) {
            p.put(json)
        }
        return json
    }

    override fun clearJsonCache() {
        rootJsonObject = null
    }

    override fun isValid(): Boolean {
        for (p in properties) {
            if (p is JsonProperty && p is OptionalJsonProperty == false) {
                if (p.value == null) return false
            }
            var value = p.value
            if (value is IHKJson) {
                if (value.isValid().not()) return false
            }
            if (value is Array<*>) {
                if (value.asSequence().filterIsInstance(IHKJson::class.java).all { it.isValid() }.not()) return false
            }
        }
        return true
    }

    protected fun <T : IProperty<*>> T.addProperty(): T {
        properties.add(this)
        if (rootJsonObject != null) this.init(rootJsonObject!!)
        return this
    }

    /*
    * String
    * */
    override val string = StringJson.Companion

    override fun StringJson.Companion.json(key: String): JsonProperty<String> {
        return JsonProperty(key, initString, putString).addProperty()
    }

    override fun StringJson.Companion.json(key: String, default: String) = json(key).apply { value = default }

    override fun StringOptionalJson.Companion.json(key: String): OptionalJsonProperty<String> {
        return OptionalJsonProperty(key, initOptionalString, putOptionalString).addProperty()
    }

    override fun StringArrayJson.Companion.json(key: String): JsonProperty<Array<String>> {
        return JsonProperty(key, initStringArray, putStringArray).addProperty()
    }

    override fun StringArrayJson.Companion.json(key: String, default: Array<String>) = json(key).apply { value = default }

    override fun StringArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<Array<String>> {
        return OptionalJsonProperty(key, initOptionalStringArray, putOptionalStringArray).addProperty()
    }

    /*
    * Boolean
    * */
    override val boolean = BooleanJson.Companion

    override fun BooleanJson.Companion.json(key: String): JsonProperty<Boolean> {
        return JsonProperty(key, initBoolean, putBoolean).addProperty()
    }

    override fun BooleanJson.Companion.json(key: String, default: Boolean) = json(key).apply { value = default }

    override fun BooleanOptionalJson.Companion.json(key: String): OptionalJsonProperty<Boolean> {
        return OptionalJsonProperty(key, initOptionalBoolean, putOptionalBoolean).addProperty()
    }

    override fun BooleanArrayJson.Companion.json(key: String): JsonProperty<BooleanArray> {
        return JsonProperty(key, initBooleanArray, putBooleanArray).addProperty()
    }

    override fun BooleanArrayJson.Companion.json(key: String, default: BooleanArray) = json(key).apply { value = default }

    override fun BooleanArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<BooleanArray> {
        return OptionalJsonProperty(key, initOptionalBooleanArray, putOptionalBooleanArray).addProperty()
    }

    /*
    * Int
    * */
    override val int = IntJson.Companion

    override fun IntJson.Companion.json(key: String): JsonProperty<Int> {
        return JsonProperty(key, initInt, putInt).addProperty()
    }

    override fun IntJson.Companion.json(key: String, default: Int) = json(key).apply { value = default }

    override fun IntOptionalJson.Companion.json(key: String): OptionalJsonProperty<Int> {
        return OptionalJsonProperty(key, initOptionalInt, putOptionalInt).addProperty()
    }

    override fun IntArrayJson.Companion.json(key: String): JsonProperty<IntArray> {
        return JsonProperty(key, initIntArray, putIntArray).addProperty()
    }

    override fun IntArrayJson.Companion.json(key: String, default: IntArray) = json(key).apply { value = default }

    override fun IntArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<IntArray> {
        return OptionalJsonProperty(key, initOptionalIntArray, putOptionalIntArray).addProperty()
    }

    /*
    * Long
    * */
    override val long = LongJson.Companion

    override fun LongJson.Companion.json(key: String): JsonProperty<Long> {
        return JsonProperty(key, initLong, putLong).addProperty()
    }

    override fun LongJson.Companion.json(key: String, default: Long) = json(key).apply { value = default }

    override fun LongOptionalJson.Companion.json(key: String): OptionalJsonProperty<Long> {
        return OptionalJsonProperty(key, initOptionalLong, putOptionalLong).addProperty()
    }

    override fun LongArrayJson.Companion.json(key: String): JsonProperty<LongArray> {
        return JsonProperty(key, initLongArray, putLongArray).addProperty()
    }

    override fun LongArrayJson.Companion.json(key: String, default: LongArray) = json(key).apply { value = default }

    override fun LongArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<LongArray> {
        return OptionalJsonProperty(key, initOptionalLongArray, putOptionalLongArray).addProperty()
    }

    /*
    * Double
    * */

    override val double = DoubleJson.Companion

    override fun DoubleJson.Companion.json(key: String): JsonProperty<Double> {
        return JsonProperty(key, initDouble, putDouble).addProperty()
    }

    override fun DoubleJson.Companion.json(key: String, default: Double) = json(key).apply { value = default }

    override fun DoubleOptionalJson.Companion.json(key: String): OptionalJsonProperty<Double> {
        return OptionalJsonProperty(key, initOptionalDouble, putOptionalDouble).addProperty()
    }

    override fun DoubleArrayJson.Companion.json(key: String): JsonProperty<DoubleArray> {
        return JsonProperty(key, initDoubleArray, putDoubleArray).addProperty()
    }

    override fun DoubleArrayJson.Companion.json(key: String, default: DoubleArray) = json(key).apply { value = default }

    override fun DoubleArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<DoubleArray> {
        return OptionalJsonProperty(key, initOptionalDoubleArray, putOptionalDoubleArray).addProperty()
    }

    /*
    * Date
    * */

    override val date = DateJson.Companion

    override fun DateJson.Companion.json(key: String): JsonProperty<Date> {
        return JsonProperty(key, initDate, putDate).addProperty()
    }

    override fun DateJson.Companion.json(key: String, default: Date) = json(key).apply { value = default }

    override fun DateOptionalJson.Companion.json(key: String): OptionalJsonProperty<Date> {
        return OptionalJsonProperty(key, initOptionalDate, putOptionalDate).addProperty()
    }

    override fun DateArrayJson.Companion.json(key: String): JsonProperty<Array<Date>> {
        return JsonProperty(key, initDateArray, putDateArray).addProperty()
    }

    override fun DateArrayJson.Companion.json(key: String, default: Array<Date>) = json(key).apply { value = default }

    override fun DateArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<Array<Date>> {
        return OptionalJsonProperty(key, initOptionalDateArray, putOptionalDateArray).addProperty()
    }

    /*
    * JsonObject
    * */
    override val hkjson = HKJsonJson.Companion

    override fun<T : IHKJson> HKJsonJson.Companion.json(key: String, creator: () -> T): JsonProperty<T> {
        return JsonProperty(key, initJsonObject(creator), putJsonObject()).addProperty()
    }

    override fun <T : IHKJson> HKJsonJson.Companion.json(key: String, creator: () -> T, default: T) = json(key, creator).apply { value = default }

    override fun<T : IHKJson> HKJsonOptionalJson.Companion.json(key: String, creator: () -> T): OptionalJsonProperty<T> {
        return OptionalJsonProperty(key, initOptionalJsonObject(creator), putOptionalJsonObject()).addProperty()
    }

    override fun<T : IHKJson> HKJsonArrayJson.Companion.json(key: String, creator: (Int) -> Array<T>): JsonProperty<Array<T>> {
        return JsonProperty(key, initJsonArray(creator), putJsonArray()).addProperty()
    }

    override fun <T : IHKJson> HKJsonArrayJson.Companion.json(key: String, creator: (Int) -> Array<T>, default: Array<T>) = json(key, creator).apply { value = default }

    override fun<T : IHKJson> HKJsonArrayOptionalJson.Companion.json(key: String, creator: (Int) -> Array<T>): OptionalJsonProperty<Array<T>> {
        return OptionalJsonProperty(key, initOptionalJsonArray(creator), putOptionalJsonArray()).addProperty()
    }

    /*
    * Custom
    * */
    override fun<T> HKJsonCustomJson.Companion.json(key: String, initter: (JSONObject, String) -> T, putter: (JSONObject, String, T) -> Unit): JsonProperty<T> {
        return JsonProperty(key, initter, putter).addProperty()
    }

    override fun <T> HKJsonCustomJson.Companion.json(key: String, initter: (JSONObject, String) -> T, putter: (JSONObject, String, T) -> Unit, default: T)
            = json(key, initter, putter).apply { value = default }

    override fun<T> HKJsonCustomOptionalJson.Companion.json(key: String, initter: (JSONObject, String) -> T?, putter: (JSONObject, String, T?) -> Unit): OptionalJsonProperty<T> {
        return OptionalJsonProperty(key, initter, putter).addProperty()
    }

    /*
    * Extensions
    * */

    override val <T : IHKJson> IJsonObject<T>.optional: IJsonOptionalObject<T>
        get() {
            val t = this
            return object : IJsonOptionalObject<T> {
                override fun creator() = t.creator()
            }
        }

    override val <T : IHKJson> IJsonArray<T>.array: IJsonArray2<T>
        get() {
            val t = this
            return object : IJsonArray2<T> {
                override fun arrayCreator() = t.arrayCreator()
            }
        }

    override val <T : IHKJson> IJsonArray2<T>.optional: IJsonOptionalArray<T>
        get() {
            val t = this
            return object : IJsonOptionalArray<T> {
                override fun arrayCreator() = t.arrayCreator()
            }
        }

    companion object {
        /*
        * get Object for init Object
        * */
        private val getString: (JSONObject, String) -> String = {
            json, key ->
            json.getString(key)!!
        }
        private val getStringArray: (JSONObject, String) -> Array<String> = {
            json, key ->
            val ar = json.getJSONArray(key);
            Array(ar.length(), { i -> ar.getString(i) })
        }
        private val getBoolean: (JSONObject, String) -> Boolean = {
            json, key ->
            json.getBoolean(key)
        }
        private val getBooleanArray: (JSONObject, String) -> BooleanArray = {
            json, key ->
            val ar = json.getJSONArray(key);
            BooleanArray(ar.length(), { i -> ar.getBoolean(i) })
        }
        private val getInt: (JSONObject, String) -> Int = {
            json, key ->
            json.getInt(key)
        }
        private val getIntArray: (JSONObject, String) -> IntArray = {
            json, key ->
            val ar = json.getJSONArray(key);
            IntArray(ar.length(), { i -> ar.getInt(i) })
        }
        private val getLong: (JSONObject, String) -> Long = {
            json, key ->
            json.getLong(key)
        }
        private val getLongArray: (JSONObject, String) -> LongArray = {
            json, key ->
            val ar = json.getJSONArray(key);
            LongArray(ar.length(), { i -> ar.getLong(i) })
        }
        private val getDouble: (JSONObject, String) -> Double = {
            json, key ->
            json.getDouble(key)
        }
        private val getDoubleArray: (JSONObject, String) -> DoubleArray = {
            json, key ->
            val ar = json.getJSONArray(key);
            DoubleArray(ar.length(), { i -> ar.getDouble(i) })
        }
        private val getDate: (JSONObject, String) -> Date = {
            json, key ->
            Date(json.getLong(key))
        }
        private val getDateArray: (JSONObject, String) -> Array<Date> = {
            json, key ->
            val ar = json.getJSONArray(key);
            Array(ar.length(), { i -> Date(ar.getLong(i)) })
        }

        private fun <T : IHKJson> getJsonObject(creator: () -> T): (JSONObject, String) -> T {
            return {
                json, key ->
                creator().apply { this.parseJson(json.getJSONObject(key)!!) }
            }
        }

        private fun <T : IHKJson> getJsonArray(creator: (Int) -> Array<T>): (JSONObject, String) -> Array<T> {
            return {
                json, key ->
                val ar = json.getJSONArray(key);
                creator(ar.length()).apply {
                    for (i in 0..ar.length() - 1) {
                        this[i].parseJson(ar.getJSONObject(i)!!)
                    }
                }
            }
        }

        /*
        * init Object
        * */
        private val initString: (JSONObject, String) -> String = {
            json, key ->
            getString.invoke(json, key)
        }
        private val initOptionalString: (JSONObject, String) -> String? = {
            json, key ->
            if (json.isNull(key)) null else getString.invoke(json, key)
        }
        private val initStringArray: (JSONObject, String) -> Array<String> = {
            json, key ->
            getStringArray.invoke(json, key)
        }
        private val initOptionalStringArray: (JSONObject, String) -> Array<String>? = {
            json, key ->
            if (json.isNull(key)) null else getStringArray.invoke(json, key)
        }
        private val initBoolean: (JSONObject, String) -> Boolean = {
            json, key ->
            getBoolean.invoke(json, key)
        }
        private val initOptionalBoolean: (JSONObject, String) -> Boolean? = {
            json, key ->
            if (json.isNull(key)) null else getBoolean.invoke(json, key)
        }
        private val initBooleanArray: (JSONObject, String) -> BooleanArray = {
            json, key ->
            getBooleanArray.invoke(json, key)
        }
        private val initOptionalBooleanArray: (JSONObject, String) -> BooleanArray? = {
            json, key ->
            if (json.isNull(key)) null else getBooleanArray.invoke(json, key)
        }
        private val initInt: (JSONObject, String) -> Int = {
            json, key ->
            getInt.invoke(json, key)
        }
        private val initOptionalInt: (JSONObject, String) -> Int? = {
            json, key ->
            if (json.isNull(key)) null else getInt.invoke(json, key)
        }
        private val initIntArray: (JSONObject, String) -> IntArray = {
            json, key ->
            getIntArray.invoke(json, key)
        }
        private val initOptionalIntArray: (JSONObject, String) -> IntArray? = {
            json, key ->
            if (json.isNull(key)) null else getIntArray.invoke(json, key)
        }
        private val initLong: (JSONObject, String) -> Long = {
            json, key ->
            getLong.invoke(json, key)
        }
        private val initOptionalLong: (JSONObject, String) -> Long? = {
            json, key ->
            if (json.isNull(key)) null else getLong.invoke(json, key)
        }
        private val initLongArray: (JSONObject, String) -> LongArray = {
            json, key ->
            getLongArray.invoke(json, key)
        }
        private val initOptionalLongArray: (JSONObject, String) -> LongArray? = {
            json, key ->
            if (json.isNull(key)) null else getLongArray.invoke(json, key)
        }
        private val initDouble: (JSONObject, String) -> Double = {
            json, key ->
            getDouble.invoke(json, key)
        }
        private val initOptionalDouble: (JSONObject, String) -> Double? = {
            json, key ->
            if (json.isNull(key)) null else getDouble.invoke(json, key)
        }
        private val initDoubleArray: (JSONObject, String) -> DoubleArray = {
            json, key ->
            getDoubleArray.invoke(json, key)
        }
        private val initOptionalDoubleArray: (JSONObject, String) -> DoubleArray? = {
            json, key ->
            if (json.isNull(key)) null else getDoubleArray.invoke(json, key)
        }
        private val initDate: (JSONObject, String) -> Date = {
            json, key ->
            getDate.invoke(json, key)
        }
        private val initOptionalDate: (JSONObject, String) -> Date? = {
            json, key ->
            if (json.isNull(key)) null else getDate.invoke(json, key)
        }
        private val initDateArray: (JSONObject, String) -> Array<Date> = {
            json, key ->
            getDateArray.invoke(json, key)
        }
        private val initOptionalDateArray: (JSONObject, String) -> Array<Date>? = {
            json, key ->
            if (json.isNull(key)) null else getDateArray.invoke(json, key)
        }

        private fun <T : IHKJson> initJsonObject(creator: () -> T): (JSONObject, String) -> T {
            return {
                json, key ->
                getJsonObject(creator).invoke(json, key)
            }
        }

        private fun <T : IHKJson> initOptionalJsonObject(creator: () -> T): (JSONObject, String) -> T? {
            return {
                json, key ->
                if (json.isNull(key)) null else getJsonObject(creator).invoke(json, key)
            }
        }

        private fun <T : IHKJson> initJsonArray(creator: (Int) -> Array<T>): (JSONObject, String) -> Array<T> {
            return {
                json, key ->
                getJsonArray(creator).invoke(json, key)
            }
        }

        private fun <T : IHKJson> initOptionalJsonArray(creator: (Int) -> Array<T>): (JSONObject, String) -> Array<T>? {
            return {
                json, key ->
                if (json.isNull(key)) null else getJsonArray(creator).invoke(json, key)
            }
        }

        /*
        * put Object
        * */
        private val putString: (JSONObject, String, String) -> Unit = {
            json, key, value ->
            json.put(key, value)
        }
        private val putOptionalString: (JSONObject, String, String?) -> Unit = {
            json, key, value ->
            if (value != null) putString.invoke(json, key, value)
        }
        private val putStringArray: (JSONObject, String, Array<String>) -> Unit = {
            json, key, value ->
            val ar = JSONArray().apply {
                for ((i, v) in value.withIndex()) {
                    this.put(i, v)
                }
            }
            json.put(key, ar)
        }
        private val putOptionalStringArray: (JSONObject, String, Array<String>?) -> Unit = {
            json, key, value ->
            if (value != null) putStringArray.invoke(json, key, value)
        }
        private val putBoolean: (JSONObject, String, Boolean) -> Unit = {
            json, key, value ->
            json.put(key, value)
        }
        private val putOptionalBoolean: (JSONObject, String, Boolean?) -> Unit = {
            json, key, value ->
            if (value != null) putBoolean.invoke(json, key, value)
        }
        private val putBooleanArray: (JSONObject, String, BooleanArray) -> Unit = {
            json, key, value ->
            val ar = JSONArray().apply {
                for ((i, v) in value.withIndex()) {
                    this.put(i, v)
                }
            }
            json.put(key, ar)
        }
        private val putOptionalBooleanArray: (JSONObject, String, BooleanArray?) -> Unit = {
            json, key, value ->
            if (value != null) putBooleanArray.invoke(json, key, value)
        }
        private val putInt: (JSONObject, String, Int) -> Unit = {
            json, key, value ->
            json.put(key, value)
        }
        private val putOptionalInt: (JSONObject, String, Int?) -> Unit = {
            json, key, value ->
            if (value != null) putInt.invoke(json, key, value)
        }
        private val putIntArray: (JSONObject, String, IntArray) -> Unit = {
            json, key, value ->
            val ar = JSONArray().apply {
                for ((i, v) in value.withIndex()) {
                    this.put(i, v)
                }
            }
            json.put(key, ar)
        }
        private val putOptionalIntArray: (JSONObject, String, IntArray?) -> Unit = {
            json, key, value ->
            if (value != null) putIntArray.invoke(json, key, value)
        }
        private val putLong: (JSONObject, String, Long) -> Unit = {
            json, key, value ->
            json.put(key, value)
        }
        private val putOptionalLong: (JSONObject, String, Long?) -> Unit = {
            json, key, value ->
            if (value != null) putLong.invoke(json, key, value)
        }
        private val putLongArray: (JSONObject, String, LongArray) -> Unit = {
            json, key, value ->
            val ar = JSONArray().apply {
                for ((i, v) in value.withIndex()) {
                    this.put(i, v)
                }
            }
            json.put(key, ar)
        }
        private val putOptionalLongArray: (JSONObject, String, LongArray?) -> Unit = {
            json, key, value ->
            if (value != null) putLongArray.invoke(json, key, value)
        }
        private val putDouble: (JSONObject, String, Double) -> Unit = {
            json, key, value ->
            json.put(key, value)
        }
        private val putOptionalDouble: (JSONObject, String, Double?) -> Unit = {
            json, key, value ->
            if (value != null) putDouble.invoke(json, key, value)
        }
        private val putDoubleArray: (JSONObject, String, DoubleArray) -> Unit = {
            json, key, value ->
            val ar = JSONArray().apply {
                for ((i, v) in value.withIndex()) {
                    this.put(i, v)
                }
            }
            json.put(key, ar)
        }
        private val putOptionalDoubleArray: (JSONObject, String, DoubleArray?) -> Unit = {
            json, key, value ->
            if (value != null) putDoubleArray.invoke(json, key, value)
        }
        private val putDate: (JSONObject, String, Date) -> Unit = {
            json, key, value ->
            json.put(key, value.time)
        }
        private val putOptionalDate: (JSONObject, String, Date?) -> Unit = {
            json, key, value ->
            if (value != null) putDate.invoke(json, key, value)
        }
        private val putDateArray: (JSONObject, String, Array<Date>) -> Unit = {
            json, key, value ->
            val ar = JSONArray().apply {
                for ((i, v) in value.withIndex()) {
                    this.put(i, v.time)
                }
            }
            json.put(key, ar)
        }
        private val putOptionalDateArray: (JSONObject, String, Array<Date>?) -> Unit = {
            json, key, value ->
            if (value != null) putDateArray.invoke(json, key, value)
        }

        private fun <T : IHKJson> putJsonObject(): (JSONObject, String, T) -> Unit = {
            json, key, value ->
            json.put(key, value.makeJson())
        }

        private fun <T : IHKJson> putOptionalJsonObject(): (JSONObject, String, T?) -> Unit = {
            json, key, value ->
            if (value != null) putJsonObject<T>().invoke(json, key, value)
        }

        private fun <T : IHKJson> putJsonArray(): (JSONObject, String, Array<T>) -> Unit = {
            json, key, value ->
            val ar = JSONArray().apply {
                for (i in 0..value.size - 1) {
                    this.put(i, value[i].makeJson())
                }
            };
            json.put(key, ar)
        }

        private fun <T : IHKJson> putOptionalJsonArray():
                (JSONObject, String, Array<T>?) -> Unit = {
            json, key, value ->
            if (value != null) putJsonArray<T>().invoke(json, key, value)
        }
    }
}