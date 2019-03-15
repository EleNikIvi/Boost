package com.eugene.boost.ui.main

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(MainViewModel::class.java)
    }


    var toolbar: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.AppTheme_Light)

        setContentView(R.layout.activity_main)

        initView()
    }

    override fun onDestroy() {

        destroyView()

        super.onDestroy()
    }


    private fun initView() {

        toolbar = findViewById(R.id.main_toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        toolbar?.setupWithNavController(
            Navigation.findNavController(this, R.id.main_navigation)
        )
    }

    private fun destroyView() {

        toolbar = null
    }
}
