package com.example.keeper.utils.extension

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.ui.R

fun NavController.navigateAnim(
    resId: Int, bundle: Bundle? = null, inclusive: Boolean? = null, animType: String = "default"
) {
    val navOptions = when (animType) {
        "enter" -> NavOptions.Builder()
            .setEnterAnim(com.example.keeper.R.anim.scale_enter)
            .setExitAnim(com.example.keeper.R.anim.scale_exit)
            .setPopEnterAnim(com.example.keeper.R.anim.scale_enter)
            .setPopExitAnim(com.example.keeper.R.anim.scale_exit)
            .build()
        "fade" -> NavOptions.Builder()
            .setEnterAnim(android.R.anim.fade_in)
            .setExitAnim(android.R.anim.fade_out)
            .setPopEnterAnim(android.R.anim.fade_in)
            .setPopExitAnim(android.R.anim.fade_out)
            .build()
        else -> NavOptions.Builder()
            .setEnterAnim(R.anim.nav_default_enter_anim)
            .setExitAnim(R.anim.nav_default_exit_anim)
            .setPopEnterAnim(R.anim.nav_default_pop_enter_anim)
            .setPopExitAnim(R.anim.nav_default_pop_exit_anim)
            .build()
    }

    navigate(resId, bundle, navOptions)
}