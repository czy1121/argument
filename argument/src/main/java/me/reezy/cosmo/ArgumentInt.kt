package me.reezy.cosmo

import android.os.Bundle


class ArgumentInt(default: Int = 0, key: String? = null): ArgumentField<Int>(default, key) {
    override fun get(field: String, bundle: Bundle): Int {
        val o = bundle[field] ?: return default
        return when(o) {
            is Number -> o.toInt()
            is String -> o.toIntOrNull() ?: default
            else -> default
        }
    }
}