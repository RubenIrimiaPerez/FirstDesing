package com.RubenIrimiaPerez.firstdesign

import android.app.Application
import com.google.android.material.color.DynamicColors

class FirstDesignApplication :Application(){
    override fun onCreate() {
        // Apply dynamic color
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}