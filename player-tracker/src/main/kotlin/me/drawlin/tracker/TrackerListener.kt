package me.drawlin.tracker

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.PlayerDeathEvent

class TrackerListener(val plugin: TrackerPlugin) : Listener {

    @EventHandler
    fun onDeath(event: PlayerDeathEvent) {
        val player = event.entity as Player
        val currentDeaths = plugin.playerDeaths.getOrDefault(player.uniqueId, 0)
        plugin.playerDeaths[player.uniqueId] = currentDeaths + 1
//        Bukkit.getServer().broadcastMessage(player.name + " has " + plugin.playerDeaths[player.uniqueId] + " deaths")
    }

    @EventHandler
    fun onKill(event: EntityDamageByEntityEvent) {
        val killed = event.entity as Player ?: return
        val killer = event.damager as Player ?: return

        if (killed.health > event.damage) return

        val currentKills = plugin.playerKills.getOrDefault(killer.uniqueId, 0)
        plugin.playerKills[killer.uniqueId] = currentKills + 1
//        Bukkit.getServer().broadcastMessage(killer.name + " has " + plugin.playerKills[killer.uniqueId] + " kills")
    }
}