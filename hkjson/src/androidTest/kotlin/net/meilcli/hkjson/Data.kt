package net.meilcli.hkjson

import org.json.JSONObject
import java.util.*

class Data(json: JSONObject? = null) : IHKJson by HKJson(json) {
    var s1 by string.json("s1")
    var s2 by string.optional.json("s2")
    var s3 by string.array.json("s3")
    var s4 by string.array.optional.json("s4")

    var b1 by boolean.json("b1")
    var b2 by boolean.optional.json("b2")
    var b3 by boolean.array.json("b3")
    var b4 by boolean.array.optional.json("b4")

    var i1 by int.json("i1")
    var i2 by int.optional.json("i2")
    var i3 by int.array.json("i3")
    var i4 by int.array.optional.json("i4")

    var l1 by long.json("l1")
    var l2 by long.optional.json("l2")
    var l3 by long.array.json("l3")
    var l4 by long.array.optional.json("l4")

    var d1 by double.json("d1")
    var d2 by double.optional.json("d2")
    var d3 by double.array.json("d3")
    var d4 by double.array.optional.json("d4")

    var da1 by date.json("da1")
    var da2 by date.optional.json("da2")
    var da3 by date.array.json("da3")
    var da4 by date.array.optional.json("da4")

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