package com.nekozouneko.antiCivBreak.commands

import com.nekozouneko.antiCivBreak.AntiCivBreak
import net.kyori.adventure.text.Component
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class CivReloadCommand : CommandExecutor {
    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>): Boolean {
        AntiCivBreak.instance.reloadConfig()
        p0.sendMessage(Component.text("§aコンフィグを正常にリロードしました。"))
        return true
    }
}