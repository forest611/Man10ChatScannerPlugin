package com.psysoftware.man10chatscanner

import java.io.File
import java.io.IOException
import net.md_5.bungee.config.YamlConfiguration
import net.md_5.bungee.config.ConfigurationProvider
import net.md_5.bungee.config.Configuration

class Config(val plugin: Man10ChatScanner) {

    private var config: Configuration? = null
    
    fun load(){
        if (!plugin.dataFolder.exists()) {
            plugin.dataFolder.mkdir()
        }

        val file = File(plugin.dataFolder, "config.yml")

        try {
            if (!file.exists()) {
                file.createNewFile()
            }
    
            config = ConfigurationProvider.getProvider(YamlConfiguration::class.java).load(file)
                
        } catch (e: IOException) {
            plugin.logger.severe("config.ymlを読み込めませんでした")
        }
    }

    fun save(){
        try {
            ConfigurationProvider.getProvider(YamlConfiguration::class.java).save(config, File(plugin.dataFolder, "config.yml"))
        } catch (e: IOException) {
            plugin.logger.severe("config.ymlを保存できませんでした")
        }
    }

    fun get(): Configuration? {
        return config
    }
    
}
