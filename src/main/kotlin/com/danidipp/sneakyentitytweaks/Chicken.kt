package com.danidipp.sneakyentitytweaks

import net.kyori.adventure.text.Component
import org.bukkit.Bukkit
import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason
import org.bukkit.event.entity.EntityDropItemEvent
import org.bukkit.event.entity.ItemSpawnEvent

class Chicken : Listener{

    // Prevents chickens from spawning when breaking eggs
    @EventHandler
    fun onSpawn(event: CreatureSpawnEvent) {
        if (event.spawnReason != SpawnReason.EGG) return
        event.isCancelled = true
    }

    // Prevents chickens from laying eggs
    @EventHandler
    fun onLayEgg(event: EntityDropItemEvent) {
        Bukkit.broadcast(Component.text("Entity type: ${event.entityType}, item type: ${event.itemDrop.type}"))
        if (event.entity.type != EntityType.CHICKEN) return
        event.isCancelled = true
    }
}