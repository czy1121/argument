package me.reezy.cosmo

import android.os.Bundle


class ArgumentLong(default: Long = 0, key: String? = null): ArgumentField<Long>(default, key) {
    override fun get(field: String, bundle: Bundle): Long {
        val o = bundle[field] ?: return default
        return when(o) {
            is Number -> o.toLong()
            is String -> o.toLongOrNull() ?: default
            else -> default
        }
    }
}