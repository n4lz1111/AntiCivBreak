package com.nekozouneko.antiCivBreak.managers

import com.nekozouneko.antiCivBreak.AntiCivBreak
import net.kyori.adventure.text.Component
import org.bukkit.entity.Player

class NotificationManager {
    companion object {
        fun violation(player: Player, checkType: String, description: String) {
            val component = Component.text(
                "§8[§cAntiCivBreak§8] §f${player.name} §7failed §f${checkType}"
            ).hoverEvent(
                Component.text(
                "§f検出詳細\n§7${description}"
            ))
            for (target in getTargets()) target.sendMessage(component)
        }

        fun sendDebugMessage(message: String){
            for(m in AntiCivBreak.getManagers().filter {
                it.isDebugEnabled
            }) {
                m.player.sendMessage(Component.text(message))
            }
        }

        private fun getTargets(): List<Player> {
            return AntiCivBreak.instance.server.onlinePlayers.filter {
                it.hasPermission("anticivbreak.notify")
            }
        }
    }
}