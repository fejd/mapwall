package com.devindi.wallpaper.source

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.ViewModel
import com.devindi.wallpaper.model.config.ConfigManager
import com.devindi.wallpaper.model.SettingsRepo
import com.devindi.wallpaper.model.map.MapSource
import org.osmdroid.tileprovider.tilesource.OnlineTileSourceBase

class MapSourceViewModel(private val settings: SettingsRepo, private val configManager: ConfigManager): ViewModel() {

    val currentMapSource = MediatorLiveData<MapSource>()
    val mapSourceList = configManager.config.availableSources

    init {
        currentMapSource.addSource(settings.currentMapSource()) { t -> t?.let { currentMapSource.value = it } }
        currentMapSource.addSource(configManager.config.defaultMapSourceData, { currentMapSource.value = it} )
    }

    fun setCurrentSource(source: MapSource) {
        settings.setCurrentMapSource(source)
    }
}