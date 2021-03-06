package com.eugene.boost.ui.project.editor

import android.app.Dialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.eugene.boost.AppConstants
import com.eugene.boost.R
import com.eugene.boost.ui.base.BaseFragment
import com.eugene.boost.util.DialogUtil
import com.eugene.boost.util.KeyboardUtil
import kotlinx.android.synthetic.main.fragment_project_editor.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class EditorFragment : BaseFragment() {

    private val _editorViewModel: EditorViewModel by viewModel()

    private val _progressDialog: Dialog by lazy { DialogUtil.getProgressDialog(activity!!) }


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

    override fun onPause() {

        KeyboardUtil.hideKeyboard(activity!!)

        super.onPause()
    }


    private fun initView() {

        _editorViewModel.projectId = arguments!!.getInt("project_id")

        setToolbarTitle(
            if (_editorViewModel.isCreating)
                getString(R.string.project_editor_title_new_project)
            else
                getString(R.string.project_editor_title_edit_project)
        )

        btn_save.isEnabled = _editorViewModel.isEditing

        setupViewListeners()

        subscribeToViewModel()

        loadData()
    }

    private fun setupViewListeners() {

        edt_name.addTextChangedListener(object : TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {

                btn_save.isEnabled = s != null && s.length >= AppConstants.ValidationProjectNameMinLingth
            }
        })

        btn_save.setOnClickListener {

            _editorViewModel.saveChanges(edt_name.text.toString())
        }
    }

    private fun subscribeToViewModel() {

        _editorViewModel.isLoading.observe(this, Observer {

            if (it) _progressDialog.show() else _progressDialog.hide()
        })

        _editorViewModel.isSaving.observe(this, Observer {

            if (it) {
                _progressDialog.show()
            } else {
                _progressDialog.hide()

                findNavController().navigateUp()
            }
        })

        _editorViewModel.project.observe(this, Observer {

            edt_name.setText(it.name)
        })
    }

    private fun loadData() {

        _editorViewModel.loadProject(_editorViewModel.projectId)
    }
}
