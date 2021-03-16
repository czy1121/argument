package me.reezy.jetpack.argument

import android.os.Bundle


class ArgumentBoolean(default: Boolean = false, key: String? = null): ArgumentField<Boolean>(default, key) {
    override fun get(field: String, bundle: Bundle): Boolean {
        return bundle.getBoolean(field, default)
    }
}