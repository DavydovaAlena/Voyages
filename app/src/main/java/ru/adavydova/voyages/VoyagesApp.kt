package ru.adavydova.voyages

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.disk.DiskCache
import coil.memory.MemoryCache
import coil.request.CachePolicy
import coil.util.DebugLogger
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class VoyagesApp: Application(), ImageLoaderFactory {
    //i
    override fun newImageLoader(): ImageLoader {
        return ImageLoader(this).newBuilder()
            .memoryCachePolicy(CachePolicy.ENABLED)
            .memoryCache{
                MemoryCache.Builder(this)
                    .maxSizePercent(0.2)
                    .build()
            }
            .diskCachePolicy(CachePolicy.ENABLED)
            .diskCache {
                DiskCache.Builder()
                    .maxSizeBytes(5 * 1024 * 1024)
                    .directory(cacheDir.resolve("image_cache"))
                    .build()
            }
            .logger(DebugLogger())
            .respectCacheHeaders(false)
            .build()
    }
}