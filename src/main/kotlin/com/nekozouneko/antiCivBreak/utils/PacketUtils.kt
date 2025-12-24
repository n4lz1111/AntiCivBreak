package com.nekozouneko.antiCivBreak.utils

import com.github.retrooper.packetevents.wrapper.play.client.WrapperPlayClientPlayerDigging
import com.github.retrooper.packetevents.wrapper.play.server.WrapperPlayServerAcknowledgeBlockChanges
import com.nekozouneko.antiCivBreak.managers.PlayerManager

class PacketUtils {
    companion object{
        fun syncClientWithFakeAcknowledge(manager: PlayerManager, action: WrapperPlayClientPlayerDigging) {
            val packet = WrapperPlayServerAcknowledgeBlockChanges(action.sequence)
            manager.packetUser.sendPacket(packet)
        }
    }
}