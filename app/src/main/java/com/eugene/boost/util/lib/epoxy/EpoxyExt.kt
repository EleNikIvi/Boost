package com.eugene.boost.util.lib.epoxy

import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyRecyclerView

fun EpoxyRecyclerView.withModels(buildModelsCallback: EpoxyController.() -> Unit) {

    setControllerAndBuildModels(object : EpoxyController() {

        override fun buildModels() {

            buildModelsCallback()
        }
    })
}
