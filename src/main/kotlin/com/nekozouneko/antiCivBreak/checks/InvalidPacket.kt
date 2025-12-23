package com.nekozouneko.antiCivBreak.checks

import com.github.retrooper.packetevents.event.PacketReceiveEvent
import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerDigging
import com.nekozouneko.antiCivBreak.checkers.PacketChecker
import com.nekozouneko.antiCivBreak.managers.PlayerManager

class InvalidPacket : PacketChecker() {
    init {
        checkType = "InvalidPacket"
        description = "CivBreak特有の不正なパケット順序をキャンセルします"
    }
    override fun handle(manager: PlayerManager, action: WrapperPlayClientPlayerDigging, event: PacketReceiveEvent) {
        if(manager.endStoneDiggingDuration != null) return
        violation(manager)
        event.isCancelled = true
    }
}