package com.nekozouneko.antiCivBreak.checkers

import com.github.retrooper.packetevents.event.PacketReceiveEvent
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerDigging
import com.nekozouneko.antiCivBreak.managers.NotificationManager
import com.nekozouneko.antiCivBreak.managers.PlayerManager
import com.nekozouneko.antiCivBreak.wrapper.Config

abstract class PacketChecker {
    lateinit var checkType: String
    lateinit var description: String
    var maxViolation: Int? = null

    abstract fun handle(manager: PlayerManager, action: WrapperPlayClientPlayerDigging, event: PacketReceiveEvent)

    fun violation(manager: PlayerManager){
        if(!isDetailsSafe()) return
        NotificationManager.violation(manager.player, checkType, description)

        if(maxViolation == null || !Config.Punishments.AutoBan) return
        val violation = manager.violations[checkType]

        if(violation != null && violation >= maxViolation!!) {
            manager.banByViolation()
            NotificationManager.punishment(manager.player, checkType, description)
        }

        manager.violations[checkType] = manager.violations.getOrDefault(checkType, 0.0F) + 1.0F
    }

    private fun isDetailsSafe() : Boolean{
        if(!this::checkType.isInitialized) return false
        if(!this::description.isInitialized) return false
        return true
    }
}