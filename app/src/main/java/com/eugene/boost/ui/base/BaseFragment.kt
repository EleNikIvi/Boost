package com.eugene.boost.ui.base

import androidx.fragment.app.Fragment
import com.eugene.boost.ui.main.MainActivity

abstract class BaseFragment : Fragment() {

    private val _mainActivity: MainActivity?
        get() = activity as MainActivity


    protected fun setToolbarTitle(title: String) {

        _mainActivity?.toolbar?.title = title
    }
}
