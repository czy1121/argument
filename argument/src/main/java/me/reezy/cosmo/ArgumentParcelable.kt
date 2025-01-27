@file:Suppress("FunctionName")

package me.reezy.cosmo

import android.os.Build
import android.os.Bundle
import android.os.Parcelable


inline fun <reified T : Parcelable> ArgumentParcelable(default: T, key: String? = null): ArgumentParcelable<T> {
    return ArgumentParcelable(T::class.java, default, key)
}

class ArgumentParcelable<T : Parcelable>(private val clazz: Class<T>, default: T, key: String? = null) : ArgumentField<T>(default, key) {
    override fun get(field: String, bundle: Bundle): T {
        return if (Build.VERSION.SDK_INT >= 34) {
            bundle.getParcelable(field, clazz) ?: default
        } else {
            val parcelable = bundle.getParcelable<T>(field)
            if (clazz.isInstance(parcelable)) {
                parcelable!!
            } else {
                default
            }
        }
    }
}