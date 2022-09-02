package me.reezy.cosmo

import android.os.Bundle
import java.util.*



class ArgumentBoolean(default: Boolean = false, key: String? = null): ArgumentField<Boolean>(default, key) {
    override fun get(field: String, bundle: Bundle): Boolean {
        val o = bundle[field] ?: return default
        return when (o.toString().lowercase(Locale.ROOT)) {
            "false" -> false
            "0" -> false
            "" -> false
            "true" -> true
            "1" -> true
            else -> true
        }
    }
}