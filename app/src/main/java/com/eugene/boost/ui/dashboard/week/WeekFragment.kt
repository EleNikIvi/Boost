package com.eugene.boost.ui.dashboard.week

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class WeekFragment : BaseFragment() {

    val weekViewModel: WeekViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_dashboard_week, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }


    private fun initView() {

        setToolbarTitle(getString(R.string.app_week))
    }
}
