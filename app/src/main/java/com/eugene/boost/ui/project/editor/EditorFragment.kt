package com.eugene.boost.ui.project.editor

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.eugene.boost.AppConstants
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_project_editor.*
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

        _editorViewModel.projectId = arguments?.get("PROJECT_ID")?.toString()?.toIntOrNull()

        setToolbarTitle(
            if (_editorViewModel.projectId == null)
                getString(R.string.project_editor_title_new_project)
            else
                getString(R.string.project_editor_title_edit_project)
        )

        edt_name.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                btn_save.isEnabled = s != null && s.length >= AppConstants.ValidationProjectNameMinLingth
            }
        })

        btn_save.isEnabled = _editorViewModel.projectId != null
        btn_save.setOnClickListener {

            _editorViewModel.saveChanges(edt_name.text.toString())

            findNavController().navigateUp()
        }
    }
}
