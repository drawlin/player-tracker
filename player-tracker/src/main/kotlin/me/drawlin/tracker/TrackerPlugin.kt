package me.drawlin.tracker

import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import java.util.*
import kotlin.collections.HashMap

class TrackerPlugin: JavaPlugin() {

    val playerKills = HashMap<UUID, Int>()
    val playerDeaths = HashMap<UUID, Int>()

    override fun onEnable() {
        server.pluginManager.registerEvents(TrackerListener(this), this)
    }

    override fun onDisable() {

    }

}