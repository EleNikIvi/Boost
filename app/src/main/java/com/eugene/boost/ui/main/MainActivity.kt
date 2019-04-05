package com.eugene.boost.ui.main

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    private val _mainViewModel: MainViewModel by viewModel()

    var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.AppTheme_Paper)

        setContentView(R.layout.activity_main)

        initView()
    }


    private fun initView() {

        toolbar = findViewById(R.id.tlb)

        toolbar?.let {

            setSupportActionBar(it)

            supportActionBar?.title = getString(R.string.app_name)

            it.setupWithNavController(
                Navigation.findNavController(this, R.id.nav_main)
            )
        }
    }
}
