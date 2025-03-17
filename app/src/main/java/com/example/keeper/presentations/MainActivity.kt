package com.example.keeper.presentations

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.example.keeper.R
import com.example.keeper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHost.navController
        binding.navView.setupWithNavController(navController)
        binding.navView.setOnApplyWindowInsetsListener { _, insets -> insets }
        binding.navView.setOnItemSelectedListener { item ->
            item.onNavDestinationSelected(navController)
            val currentId =
                navController.currentDestination?.id ?: return@setOnItemSelectedListener false
            if (currentId != item.itemId) {
                navController.popBackStack(item.itemId, false)
            }
            true
        }
        navController.addOnDestinationChangedListener { _, _, _ ->
            bottomNavAnimVisibility(true)
        }
    }

    private fun bottomNavAnimVisibility(showBottomNav: Boolean) {
        val bottomNav = binding.navView
        if (showBottomNav) {
            bottomNav.alpha = 1f
            bottomNav.isVisible = true
            return
        }
        bottomNav.animate()
            .alpha(0f)
            .setDuration(0)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animator: Animator) {
                    bottomNav.isGone = true
                    animator.removeAllListeners()
                }

                override fun onAnimationCancel(animator: Animator) {
                    animator.removeAllListeners()
                }
            })
    }
}