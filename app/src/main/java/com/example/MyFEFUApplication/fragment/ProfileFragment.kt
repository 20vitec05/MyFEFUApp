package com.example.MyFEFUApplication.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.MyFEFUApplication.EmptyState
import com.example.MyFEFUApplication.R

class ProfileFragment : Fragment(), View.OnClickListener {
    lateinit var result_view: View
    lateinit var ChangePasswordButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        result_view = inflater.inflate(R.layout.profile_fragment, container, false)

        ChangePasswordButton = result_view.findViewById(R.id.change_password_button)
        ChangePasswordButton.setOnClickListener(this)

        return result_view
    }


    override fun onClick(view: View) {
        if (view.id == R.id.change_password_button) {
            val intent = Intent(view.context, EmptyState::class.java)
            intent.putExtra("need_change_password", true)
            view.context.startActivity(intent)
        }
    }

}