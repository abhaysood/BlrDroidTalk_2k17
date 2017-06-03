package com.gojek.blrdroidandroidcomponents

import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.manifest.AndroidManifest
import org.robolectric.res.FileFsFile

class CustomRobolectricTestRunner(testClass: Class<*>?) : RobolectricTestRunner(testClass) {
    override fun getAppManifest(config: Config?): AndroidManifest {
        val androidManifest = AndroidManifest(FileFsFile.from("app/build/intermediates/manifests/full/debug/AndroidManifest.xml"),
                // We can't use @Config annotation  to set resDirectory and assetDirectory
                // because Robolectric assumes all res and assets to be in the same dir as
                // the AndroidManifest.
                FileFsFile.from("app/build/intermediates/res/merged/debug"),
                FileFsFile.from("app/build/intermediates/bundles/debug/assets"))
        return androidManifest
    }
}