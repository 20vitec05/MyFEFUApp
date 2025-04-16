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

class DetailsActivityFragment(emptyStateActivity: EmptyState, activity_id: Int) : Fragment(),
    View.OnClickListener {
    val emptyStateActivity = emptyStateActivity
    val activity_id = activity_id
    lateinit var result_view: View
    lateinit var backButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        result_view = inflater.inflate(R.layout.details_activity_fragment, container, false)
        result_view.findViewById<TextView>(R.id.title).text = activity_id.toString()

        backButton = result_view.findViewById(R.id.back_button)
        backButton.setOnClickListener(this)

        return result_view
    }

    override fun onClick(view: View) {
        if (view.id == R.id.back_button) {
            emptyStateActivity.finish()
        }
    }
}