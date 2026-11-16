package com.cutozmie.oaster.desktop

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.cutozmie.oaster.app.OasterApp

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Oaster"
    ) {
        OasterApp()
    }
}
