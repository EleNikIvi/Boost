package com.eugene.boost.ui.base

import androidx.fragment.app.Fragment
import com.eugene.boost.ui.main.MainActivity

abstract class BaseFragment : Fragment() {

    protected val mainActivity: MainActivity?
        get() = activity as MainActivity


    protected fun setToolbarTitle(title: String) {

        mainActivity?.toolbar?.title = title
    }
}
