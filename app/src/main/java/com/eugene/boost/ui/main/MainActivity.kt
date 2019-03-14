package com.eugene.boost.ui.main

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProviders
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel

    private var tlbMain: Toolbar? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setTheme(R.style.AppTheme_Light)

        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        initView()
    }

    override fun onDestroy() {

        destroyView()

        super.onDestroy()
    }


    private fun initView() {

        tlbMain = findViewById(R.id.tlb_main)

        setSupportActionBar(tlbMain)
        supportActionBar?.title = ""
    }

    private fun destroyView() {

        tlbMain = null
    }
}
