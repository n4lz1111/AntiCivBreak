package com.nekozouneko.antiCivBreak.listeners

import com.nekozouneko.antiCivBreak.AntiCivBreak
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener : Listener{
    @EventHandler
    fun onJoin(e: PlayerJoinEvent){
        AntiCivBreak.initializePlayer(e.player)
    }
}