package com.eugene.boost.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardFragment : BaseFragment() {

    private lateinit var viewModel: DashboardViewModel

    private var dashboardBottomNavigation: BottomNavigationView? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProviders.of(this).get(DashboardViewModel::class.java)

        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    override fun onDestroyView() {

        destroyView()

        super.onDestroyView()
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater?.inflate(R.menu.menu_main, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.settings_item -> {

                findNavController().navigate(R.id.settings_fragment)
            }
        }

        return super.onOptionsItemSelected(item)
    }


    private fun initView() {

        dashboardBottomNavigation = view?.findViewById(R.id.dashboard_bottom_navigation)

        NavigationUI
            .setupWithNavController(
                dashboardBottomNavigation!!,
                Navigation.findNavController(requireActivity(), R.id.dashboard_navigation)
            )
    }

    private fun destroyView() {

        dashboardBottomNavigation = null
    }
}
