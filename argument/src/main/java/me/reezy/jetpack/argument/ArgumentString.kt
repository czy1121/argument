package me.reezy.jetpack.argument

import android.os.Bundle
import me.reezy.jetpack.argument.ArgumentField


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