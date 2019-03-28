package com.eugene.boost.ui.project.editor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditorFragment : BaseFragment() {

    private val _editorViewModel: EditorViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_project_editor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }


    private fun initView() {

    }
}
