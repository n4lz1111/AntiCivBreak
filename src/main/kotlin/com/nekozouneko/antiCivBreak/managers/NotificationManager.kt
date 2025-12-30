package com.nekozouneko.antiCivBreak.managers

import com.nekozouneko.antiCivBreak.AntiCivBreak
import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class NotificationManager {
    companion object {
        private const val PREFIX = "§8[§cAntiCivBreak§8]"
        fun violation(player: Player, checkType: String, description: String) {
            val component = Component.text(
                "$PREFIX §f${player.name} §7failed §f${checkType}"
            ).hoverEvent(
                Component.text(
                "§f検出詳細\n§7${description}"
            ))
            for (target in getTargets()) target.sendMessage(component)
            Bukkit.getConsoleSender().sendMessage(component.content())
        }

        fun punishment(player: Player, checkType: String, description: String) {
            val component = Component.text(
                "$PREFIX §f${player.name} §cwas banned for §f${checkType}"
            ).hoverEvent(
                Component.text(
                    "§f検出詳細\n§7${description}"
                ))
            for (target in getTargets()) target.sendMessage(component)
            Bukkit.getConsoleSender().sendMessage(component.content())
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