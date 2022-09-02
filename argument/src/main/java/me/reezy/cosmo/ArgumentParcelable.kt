package me.reezy.cosmo

import android.os.Bundle
import android.os.Parcelable


class ArgumentParcelable<T : Parcelable>(default: T , key: String?= null): ArgumentField<T>(default, key) {
    override fun get(field: String, bundle: Bundle): T {
        return bundle.getParcelable(field) ?: default
    }
}