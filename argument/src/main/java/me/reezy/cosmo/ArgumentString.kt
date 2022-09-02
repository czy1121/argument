package me.reezy.cosmo

import android.os.Bundle


class ArgumentString(default: String = "", key: String?= null): ArgumentField<String>(default, key) {
    override fun get(field: String, bundle: Bundle): String {
        val o = bundle[field] ?: return default
        return when(o) {
            is Number -> o.toString()
            is String -> o
            else -> default
        }
    }
}