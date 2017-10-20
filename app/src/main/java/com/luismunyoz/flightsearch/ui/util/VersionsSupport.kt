package com.luismunyoz.flightsearch.ui.util

import android.os.Build

fun supportsKitKat(code: () -> Unit) {
    supportsVersion(code, Build.VERSION_CODES.KITKAT)
}

fun supportsLollipop(code: () -> Unit) {
    supportsVersion(code, Build.VERSION_CODES.LOLLIPOP)
}

private fun supportsVersion(code: () -> Unit, sdk: Int) {
    if (Build.VERSION.SDK_INT >= sdk) {
        code.invoke()
    }
}