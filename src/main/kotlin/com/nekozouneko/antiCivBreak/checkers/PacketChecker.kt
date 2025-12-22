package com.nekozouneko.antiCivBreak.checkers

import com.github.retrooper.packetevents.event.PacketReceiveEvent
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerDigging
import com.nekozouneko.antiCivBreak.managers.NotificationManager
import com.nekozouneko.antiCivBreak.managers.PlayerManager

abstract class PacketChecker {
    lateinit var checkType: String
    lateinit var description: String

    abstract fun handle(manager: PlayerManager, action: WrapperPlayClientPlayerDigging, event: PacketReceiveEvent)

    fun violation(manager: PlayerManager){
        if(!isDetailsSafe()) return
        NotificationManager.violation(manager.getPlayer(), checkType, description)
    }

    private fun isDetailsSafe() : Boolean{
        if(!this::checkType.isInitialized) return false
        if(!this::description.isInitialized) return false
        return true
    }
}