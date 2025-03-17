package com.example.keeper.presentations.views.wallet.wallet_manager

import com.example.keeper.presentations.views.wallet.WalletScreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import com.example.keeper.presentations.views.wallet.WalletManagerScreen
import com.google.accompanist.themeadapter.material.MdcTheme

class WalletManagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                MdcTheme(setTextColors = true) {
                    WalletManagerScreen(

                    )
                }
            }
        }
    }
}