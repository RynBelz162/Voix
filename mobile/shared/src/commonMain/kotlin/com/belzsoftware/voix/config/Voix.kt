package com.belzsoftware.voix.config

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

class Voix {

    companion object {
        fun initNapierDebug() {
            Napier.base(DebugAntilog())
        }
    }
}