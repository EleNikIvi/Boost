package com.eugene.boost.ui.dashboard.week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseFragment

class WeekFragment : BaseFragment() {

    private lateinit var viewModel: WeekViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(WeekViewModel::class.java)

        return inflater.inflate(R.layout.fragment_week, container, false)
    }
}
