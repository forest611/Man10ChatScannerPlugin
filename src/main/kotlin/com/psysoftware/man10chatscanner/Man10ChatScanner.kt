package com.psysoftware.man10chatscanner

import net.md_5.bungee.api.plugin.Plugin
import com.psysoftware.man10chatscanner.PlayerChatListener

class Man10ChatScanner : Plugin() {

    private val config = Config(this)

    override fun onEnable() {
        logger.info("Man10ChatScannerを起動しました")

        proxy.pluginManager.registerListener(this, PlayerChatListener())

        config.load()

    }

    override fun onDisable() {
        logger.info("Man10ChatScannerを停止しました")
    }

}
