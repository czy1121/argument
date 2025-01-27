package me.reezy.cosmo

import android.app.Activity
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

abstract class ArgumentField<T>(protected val default: T, private val key: String?): ReadOnlyProperty<Any, T> {

    override operator fun getValue(thisRef: Any, property: KProperty<*>): T {
        if (thisRef is Activity) {
            thisRef.intent?.extras?.let {
                return get(key ?: property.name, it)
            }
        } else if (thisRef is Fragment) {
            thisRef.arguments?.let {
                return get(key ?: property.name, it)
            }
        }
        return default
    }

    abstract fun get(field: String, bundle: Bundle): T
}