package com.example.MyFEFUApplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.MyFEFUApplication.EmptyState
import com.example.MyFEFUApplication.R
import com.google.android.material.button.MaterialButton

class ChangePasswordFragment(emptyStateActivity: EmptyState) : Fragment(), View.OnClickListener {
    val emptyStateActivity = emptyStateActivity
    lateinit var result_view: View
    lateinit var backButton: ImageButton
    lateinit var SavingPasswordButton: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        result_view = inflater.inflate(R.layout.change_password_fragment, container, false)

        result_view.findViewById<TextView>(R.id.title).text = getString(R.string.change_password)

        backButton = result_view.findViewById(R.id.back_button)
        backButton.setOnClickListener(this)

        SavingPasswordButton = result_view.findViewById(R.id.saving_new_password_button)
        SavingPasswordButton.setOnClickListener(this)

        return result_view
    }

    override fun onClick(view: View) {
        if (view.id == R.id.back_button) {
            emptyStateActivity.finish()
        }
        if (view.id == R.id.saving_new_password_button) {
            emptyStateActivity.finish()
        }
    }

}