package com.danidipp.sneakyentitytweaks

import org.bukkit.entity.EntityType
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason
import org.bukkit.event.entity.EntityChangeBlockEvent

class Silverfish : Listener {

    // Prevents silverfish from spawning when breaking infested blocks
    @EventHandler
    fun onSpawn(event: CreatureSpawnEvent) {
        if (event.spawnReason != SpawnReason.SILVERFISH_BLOCK) return
        event.isCancelled = true
    }

    // Prevents silverfish from breaking or entering nearby infested blocks
    @EventHandler
    fun onBlockBreak(event: EntityChangeBlockEvent) {
        if (event.entityType != EntityType.SILVERFISH) return

        val sourceInfested = event.block.type.name.startsWith("INFESTED_")
        val targetInfested = event.to.name.startsWith("INFESTED_")
        if (sourceInfested || targetInfested) {
            event.isCancelled = true
        }
    }
}