package com.nekozouneko.antiCivBreak.wrapper

import com.nekozouneko.antiCivBreak.AntiCivBreak

object Config {
    object Punishments {
        val AutoBan
            get() = AntiCivBreak.instance.config.getBoolean("punishments.autoban")
        val Reason
            get() = AntiCivBreak.instance.config.getStringList("punishments.reason")
    }
}