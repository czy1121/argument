package me.reezy.jetpack.argument

import android.os.Bundle


class ArgumentFloat(default: Float = 0f, key: String? = null): ArgumentField<Float>(default, key) {
    override fun get(field: String, bundle: Bundle): Float {
        val o = bundle[field] ?: return default
        return when(o) {
            is Number -> o.toFloat()
            is String -> o.toFloatOrNull() ?: default
            else -> default
        }
    }
}