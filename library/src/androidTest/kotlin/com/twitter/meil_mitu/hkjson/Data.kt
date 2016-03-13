package com.twitter.meil_mitu.hkjson

import com.twitter.meil_mitu.hkjson.objects.*
import org.json.JSONObject
import java.util.*

class Data(json: JSONObject? = null) : IJson by HKJson(json) {
    var s1 by StringJson.json("s1")
    var s2 by StringJson.jsonOptional("s2")
    var s3 by StringJson.jsonArray("s3")
    var s4 by StringJson.jsonOptionalArray("s4")

    var b1 by BooleanJson.json("b1")
    var b2 by BooleanJson.jsonOptional("b2")
    var b3 by BooleanJson.jsonArray("b3")
    var b4 by BooleanJson.jsonOptionalArray("b4")

    var i1 by IntJson.json("i1")
    var i2 by IntJson.jsonOptional("i2")
    var i3 by IntJson.jsonArray("i3")
    var i4 by IntJson.jsonOptionalArray("i4")

    var l1 by LongJson.json("l1")
    var l2 by LongJson.jsonOptional("l2")
    var l3 by LongJson.jsonArray("l3")
    var l4 by LongJson.jsonOptionalArray("l4")

    var d1 by DoubleJson.json("d1")
    var d2 by DoubleJson.jsonOptional("d2")
    var d3 by DoubleJson.jsonArray("d3")
    var d4 by DoubleJson.jsonOptionalArray("d4")

    var da1 by DateJson.json("da1")
    var da2 by DateJson.jsonOptional("da2")
    var da3 by DateJson.jsonArray("da3")
    var da4 by DateJson.jsonOptionalArray("da4")

    override fun equals(other: Any?): Boolean {
        if (other == null) return false
        if (other is Data == false) return false
        val o = other as Data
        when {
            s1 != o.s1 || s2 != o.s2 || s3 notEquals o.s3 || s4 notEquals o.s4 -> return false
            b1 != o.b1 || b2 != o.b2 || b3 notEquals o.b3 || b4 notEquals o.b4 -> return false
            i1 != o.i1 || i2 != o.i2 || i3 notEquals o.i3 || i4 notEquals o.i4 -> return false
            l1 != o.l1 || l2 != o.l2 || l3 notEquals o.l3 || l4 notEquals o.l4 -> return false
            d1 != o.d1 || d2 != o.d2 || d3 notEquals o.d3 || d4 notEquals o.d4 -> return false
            da1 != o.da1 || da2 != o.da2 || da3 notEquals o.da3 || da4 notEquals o.da4 -> return false
            else -> return true
        }
    }

    infix fun Array<String>?.notEquals(that: Array<String>?): Boolean {
        return if (this == null || that == null) true else Arrays.equals(this, that).not()
    }

    infix fun Array<Date>?.notEquals(that: Array<Date>?): Boolean {
        return if (this == null || that == null) true else Arrays.equals(this, that).not()
    }

    infix fun BooleanArray?.notEquals(that: BooleanArray?): Boolean {
        return if (this == null || that == null) true else Arrays.equals(this, that).not()
    }

    infix fun IntArray?.notEquals(that: IntArray?): Boolean {
        return if (this == null || that == null) true else Arrays.equals(this, that).not()
    }

    infix fun LongArray?.notEquals(that: LongArray?): Boolean {
        return if (this == null || that == null) true else Arrays.equals(this, that).not()
    }

    infix fun DoubleArray?.notEquals(that: DoubleArray?): Boolean {
        return if (this == null || that == null) true else Arrays.equals(this, that).not()
    }
}