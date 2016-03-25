package net.meilcli.hkjson

import net.meilcli.hkjson.objects.*
import net.meilcli.hkjson.properties.JsonProperty
import net.meilcli.hkjson.properties.OptionalJsonProperty
import org.json.JSONObject
import java.util.*

interface IHKJson {

    companion object

    fun parseJson(json: JSONObject)

    fun makeJson(): JSONObject

    fun clearJsonCache()

    fun isValid(): Boolean

    /*
    * String
    * */

    val string: StringJson.Companion
    fun StringJson.Companion.json(key: String): JsonProperty<String>
    fun StringJson.Companion.json(key: String, default: String): JsonProperty<String>
    fun StringOptionalJson.Companion.json(key: String): OptionalJsonProperty<String>
    fun StringArrayJson.Companion.json(key: String): JsonProperty<Array<String>>
    fun StringArrayJson.Companion.json(key: String, default: Array<String>): JsonProperty<Array<String>>
    fun StringArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<Array<String>>

    /*
    * Boolean
    * */

    val boolean: BooleanJson.Companion
    fun BooleanJson.Companion.json(key: String): JsonProperty<Boolean>
    fun BooleanJson.Companion.json(key: String, default: Boolean): JsonProperty<Boolean>
    fun BooleanOptionalJson.Companion.json(key: String): OptionalJsonProperty<Boolean>
    fun BooleanArrayJson.Companion.json(key: String): JsonProperty<BooleanArray>
    fun BooleanArrayJson.Companion.json(key: String, default: BooleanArray): JsonProperty<BooleanArray>
    fun BooleanArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<BooleanArray>

    /*
    * Int
    * */

    val int: IntJson.Companion
    fun IntJson.Companion.json(key: String): JsonProperty<Int>
    fun IntJson.Companion.json(key: String, default: Int): JsonProperty<Int>
    fun IntOptionalJson.Companion.json(key: String): OptionalJsonProperty<Int>
    fun IntArrayJson.Companion.json(key: String): JsonProperty<IntArray>
    fun IntArrayJson.Companion.json(key: String, default: IntArray): JsonProperty<IntArray>
    fun IntArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<IntArray>

    /*
    * Long
    * */

    val long: LongJson.Companion
    fun LongJson.Companion.json(key: String): JsonProperty<Long>
    fun LongJson.Companion.json(key: String, default: Long): JsonProperty<Long>
    fun LongOptionalJson.Companion.json(key: String): OptionalJsonProperty<Long>
    fun LongArrayJson.Companion.json(key: String): JsonProperty<LongArray>
    fun LongArrayJson.Companion.json(key: String, default: LongArray): JsonProperty<LongArray>
    fun LongArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<LongArray>

    /*
    * Double
    * */

    val double: DoubleJson.Companion
    fun DoubleJson.Companion.json(key: String): JsonProperty<Double>
    fun DoubleJson.Companion.json(key: String, default: Double): JsonProperty<Double>
    fun DoubleOptionalJson.Companion.json(key: String): OptionalJsonProperty<Double>
    fun DoubleArrayJson.Companion.json(key: String): JsonProperty<DoubleArray>
    fun DoubleArrayJson.Companion.json(key: String, default: DoubleArray): JsonProperty<DoubleArray>
    fun DoubleArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<DoubleArray>

    /*
    * Date
    * */

    val date: DateJson.Companion
    fun DateJson.Companion.json(key: String): JsonProperty<Date>
    fun DateJson.Companion.json(key: String, default: Date): JsonProperty<Date>
    fun DateOptionalJson.Companion.json(key: String): OptionalJsonProperty<Date>
    fun DateArrayJson.Companion.json(key: String): JsonProperty<Array<Date>>
    fun DateArrayJson.Companion.json(key: String, default: Array<Date>): JsonProperty<Array<Date>>
    fun DateArrayOptionalJson.Companion.json(key: String): OptionalJsonProperty<Array<Date>>

    /*
    * JsonObject
    * */

    val hkjson: HKJsonJson.Companion
    fun<T : IHKJson> HKJsonJson.Companion.json(key: String, creator: () -> T): JsonProperty<T>
    fun<T : IHKJson> HKJsonJson.Companion.json(key: String, creator: () -> T, default: T): JsonProperty<T>
    fun<T : IHKJson> HKJsonOptionalJson.Companion.json(key: String, creator: () -> T): OptionalJsonProperty<T>
    fun<T : IHKJson> HKJsonArrayJson.Companion.json(key: String, creator: (Int) -> Array<T>): JsonProperty<Array<T>>
    fun<T : IHKJson> HKJsonArrayJson.Companion.json(key: String, creator: (Int) -> Array<T>, default: Array<T>): JsonProperty<Array<T>>
    fun<T : IHKJson> HKJsonArrayOptionalJson.Companion.json(key: String, creator: (Int) -> Array<T>): OptionalJsonProperty<Array<T>>

    /*
    * Custom
    * */

    fun<T> HKJsonCustomJson.Companion.json(key: String, initter: (JSONObject, String) -> T, putter: (JSONObject, String, T) -> Unit): JsonProperty<T>
    fun<T> HKJsonCustomJson.Companion.json(key: String, initter: (JSONObject, String) -> T, putter: (JSONObject, String, T) -> Unit, default: T): JsonProperty<T>
    fun<T> HKJsonCustomOptionalJson.Companion.json(key: String, initter: (JSONObject, String) -> T?, putter: (JSONObject, String, T?) -> Unit): OptionalJsonProperty<T>

    /*
    * Extensions
    * */

    val<T : IHKJson> IJsonObject<T>.optional: IJsonOptionalObject<T>
    val<T : IHKJson> IJsonArray<T>.array: IJsonArray2<T>
    val<T : IHKJson> IJsonArray2<T>.optional: IJsonOptionalArray<T>

    fun<T : IHKJson> IJsonObject<T>.json(key: String): JsonProperty<T> {
        return HKJsonJson.json(key, this.creator())
    }

    fun<T : IHKJson> IJsonOptionalObject<T>.json(key: String): OptionalJsonProperty<T> {
        return HKJsonOptionalJson.json(key, this.creator())
    }

    fun<T : IHKJson> IJsonArray2<T>.json(key: String): JsonProperty<Array<T>> {
        return HKJsonArrayJson.json(key, this.arrayCreator())
    }

    fun<T : IHKJson> IJsonOptionalArray<T>.json(key: String): OptionalJsonProperty<Array<T>> {
        return HKJsonArrayOptionalJson.json(key, this.arrayCreator())
    }
}