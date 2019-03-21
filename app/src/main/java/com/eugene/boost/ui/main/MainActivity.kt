package com.eugene.boost.ui.main

import android.os.Bundle
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {

    val mainViewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.AppTheme_Light)

        setContentView(R.layout.activity_main)

        initView()
    }


    private fun initView() {

        setSupportActionBar(main_toolbar)
        supportActionBar?.title = getString(R.string.app_name)

        main_toolbar.setupWithNavController(
            Navigation.findNavController(this, R.id.main_navigation)
        )
    }
}
