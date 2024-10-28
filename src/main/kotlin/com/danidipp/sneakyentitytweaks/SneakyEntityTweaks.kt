package com.danidipp.sneakyentitytweaks

import org.bukkit.plugin.java.JavaPlugin

class SneakyEntityTweaks : JavaPlugin() {

    override fun onLoad() {
        instance = this
    }
    override fun onEnable() {
        saveDefaultConfig()
    }

    companion object {
        const val IDENTIFIER = "sneakyentitytweaks"
        const val AUTHORS = "Team Sneakymouse"
        const val VERSION = "1.0"
        private lateinit var instance: SneakyEntityTweaks

        fun getInstance(): SneakyEntityTweaks {
            return instance
        }
    }
}
