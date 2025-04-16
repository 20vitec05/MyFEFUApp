package com.example.MyFEFUApplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.MyFEFUApplication.fragment.ActivityFragment
import com.example.MyFEFUApplication.fragment.ChangePasswordFragment
import com.example.MyFEFUApplication.fragment.DetailsActivityFragment
import com.example.MyFEFUApplication.fragment.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class EmptyState : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.emptystate)

        val bundle: Bundle? = intent.extras
        val activity_id: Int?
        val need_change_password: Boolean?
        if (bundle != null) {
            activity_id = bundle.getInt("activity_id", 0)
            need_change_password = bundle.getBoolean("need_change_password")
            // case with activity "activity details"
            if (activity_id != 0) {
                if (savedInstanceState == null) {
                    supportFragmentManager.beginTransaction()
                        .add(
                            R.id.fragment_container,
                            DetailsActivityFragment(this, activity_id),
                            "DetailsActivityFragment"
                        )
                        .commit()
                    return
                }
            }
            if (need_change_password == true) {
                if (savedInstanceState == null) {
                    supportFragmentManager.beginTransaction()
                        .add(
                            R.id.fragment_container,
                            ChangePasswordFragment(this),
                            "ChangePasswordFragment"
                        )
                        .commit()
                    return
                }
            }

        }



        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ProfileFragment(), "ProfileFragment")
                .add(R.id.fragment_container, ActivityFragment(this), "ActivityFragment")
                .commit()
            switchFragment(activities_is_selected = true)
        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_activity -> {
                    switchFragment(activities_is_selected = true)
                    true
                }
                R.id.navigation_profile -> {
                    switchFragment(activities_is_selected = false)
                    true
                }
                else -> false
            }
        }
    }

    private fun switchFragment(activities_is_selected: Boolean? = null) {
        val activities_fragment: Fragment? =
            supportFragmentManager.findFragmentByTag("ActivityFragment")
        val profile_fragment: Fragment? =
            supportFragmentManager.findFragmentByTag("ProfileFragment")

        if (activities_fragment == null || profile_fragment == null) {
            // check only for kotlin type checking
            return
        }

        if (activities_is_selected != null) {
            if (activities_is_selected) {
                supportFragmentManager.beginTransaction()
                    .show(activities_fragment)
                    .hide(profile_fragment)
                    .commit()
            } else {
                supportFragmentManager.beginTransaction()
                    .show(profile_fragment)
                    .hide(activities_fragment)
                    .commit()
            }
        }
    }
}