package com.nekozouneko.antiCivBreak.listeners

import com.nekozouneko.antiCivBreak.AntiCivBreak
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerQuitEvent

class PlayerQuitListener : Listener {
    @EventHandler
    fun onQuit(e: PlayerQuitEvent) {
        val manager = AntiCivBreak.getManager(e.player.uniqueId) ?: return
        AntiCivBreak.uninitializePlayer(manager)
    }
}