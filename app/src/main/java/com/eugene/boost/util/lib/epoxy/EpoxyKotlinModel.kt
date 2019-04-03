package com.eugene.boost.util.lib.epoxy

import android.view.View
import androidx.annotation.LayoutRes
import com.airbnb.epoxy.EpoxyModel

abstract class EpoxyKotlinModel(@LayoutRes private val layoutRes: Int) : EpoxyModel<View>() {

    private var view: View? = null


    abstract fun bind()

    override fun bind(view: View) {
        this.view = view
        bind()
    }

    override fun unbind(view: View) {
        this.view = null
    }

    override fun getDefaultLayout() = layoutRes
}
