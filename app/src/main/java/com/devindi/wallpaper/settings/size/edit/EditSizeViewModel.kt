package com.devindi.wallpaper.settings.size.edit

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.devindi.wallpaper.settings.model.IntField
import com.devindi.wallpaper.settings.model.SizeSettingsFactory

class EditSizeViewModel(private val factory: SizeSettingsFactory) : ViewModel() {

    private lateinit var field: IntField
    private val wallpaperSize = MutableLiveData<Int>()

    fun loadSize(key: String) {
        field = factory.createField(key)
        wallpaperSize.value = field.get()
    }

    fun setSize(value: Int) {
        field.set(value)
    }

    fun wallpaperSize(): LiveData<Int> {
        return wallpaperSize
    }
}
