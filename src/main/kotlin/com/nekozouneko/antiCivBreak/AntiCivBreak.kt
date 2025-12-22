package com.nekozouneko.antiCivBreak

import com.github.retrooper.packetevents.PacketEvents
import com.nekozouneko.antiCivBreak.checkers.BlockChecker
import com.nekozouneko.antiCivBreak.checks.ConsistencyRayTrace
import com.nekozouneko.antiCivBreak.listeners.BlockBreakListener
import io.github.retrooper.packetevents.factory.spigot.SpigotPacketEventsBuilder
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class AntiCivBreak : JavaPlugin() {
    companion object {
        lateinit var instance: JavaPlugin

        val blockHandlers: List<BlockChecker> = listOf(
            ConsistencyRayTrace()
        )
    }

    override fun onLoad() {
        PacketEvents.setAPI(SpigotPacketEventsBuilder.build(this))
        PacketEvents.getAPI().load()
    }

    override fun onEnable() {
        instance = this

        //Initialize PacketEvents
        PacketEvents.getAPI().init()

        //Listeners
        val listeners: List<Listener> = listOf(
            BlockBreakListener()
        )
        for(listener in listeners) server.pluginManager.registerEvents(listener, this)
    }

    override fun onDisable() {
        PacketEvents.getAPI().terminate()
    }
}
