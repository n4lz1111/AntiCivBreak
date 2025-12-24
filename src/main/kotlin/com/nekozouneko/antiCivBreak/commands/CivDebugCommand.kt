package com.nekozouneko.antiCivBreak.commands

import com.nekozouneko.antiCivBreak.AntiCivBreak
import net.kyori.adventure.text.Component
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.command.TabExecutor
import org.bukkit.entity.Player

class CivDebugCommand : CommandExecutor, TabExecutor{
    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>): Boolean {
        if(p0 !is Player) {
            p0.sendMessage("§cプレイヤーのみ実行可能なコマンドです。")
            return true
        }
        val manager = AntiCivBreak.getManager(p0.uniqueId) ?: return false
        manager.isDebugEnabled = manager.isDebugEnabled.also {
            if(it){
                p0.sendMessage(Component.text("§cデバッグモードを無効にしました。"))
            }else{
                p0.sendMessage(Component.text("§aデバッグモードを有効にしました。"))
            }
        }.not()
        return true
    }

    override fun onTabComplete(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>): List<String?>? {
        return null
    }
}