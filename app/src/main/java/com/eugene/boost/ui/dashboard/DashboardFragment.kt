package com.eugene.boost.ui.dashboard

import android.os.Bundle
import android.view.*
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_dashboard.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : BaseFragment() {

    val dashboardViewModel: DashboardViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
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

        NavigationUI
            .setupWithNavController(
                dashboard_bottom_navigation,
                Navigation.findNavController(requireActivity(), R.id.dashboard_navigation)
            )
    }
}
