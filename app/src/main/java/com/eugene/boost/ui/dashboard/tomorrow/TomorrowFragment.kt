package com.eugene.boost.ui.dashboard.tomorrow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseFragment

class TomorrowFragment : BaseFragment() {

    private lateinit var viewModel: TomorrowViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(TomorrowViewModel::class.java)

        return inflater.inflate(R.layout.fragment_tomorrow, container, false)
    }
}
