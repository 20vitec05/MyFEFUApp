package com.example.MyFEFUApplication.fragment

import ActivityAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.MyFEFUApplication.EmptyState
import com.example.MyFEFUApplication.R
import com.example.MyFEFUApplication.database.AppDatabase
import com.example.MyFEFUApplication.entity.ActivityEntity
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.properties.Delegates

class ActivityFragment(emptyState: EmptyState) : Fragment() {
    var is_personal by Delegates.notNull<Boolean>()
    val emptyState = emptyState

    lateinit var result_view: View
    lateinit var recycler_view: RecyclerView
    private lateinit var adapter: ActivityAdapter
    private var myList: List<ActivityEntity> = listOf()
    private lateinit var db: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        db = AppDatabase.getDatabase(emptyState)
//        lifecycleScope.launch {
//            withContext(Dispatchers.IO) {
//                db.activityDao().insertActivities(
//                    ActivityEntity(
//                        id = (1..10000).random(),
//                        type = "good",
//                        distanceInMeters = 1,
//                        timeInSeconds = 1,
//                        startTime = 1,
//                        endTime = 1,
//                        date = "good date",
//                        author = "admin",
//                        comment = null
//                    )
//                )
//            }
//
//        }

        result_view = inflater.inflate(R.layout.activity_fragment, container, false)
        recycler_view = result_view.findViewById(R.id.recycler_view)

        is_personal = true
        setNewAdapter()

        if (this.context != null) {
            // this "if" only for android studio type checker
            recycler_view.layoutManager = LinearLayoutManager(this.context)
        }

        val topNavigationView = result_view.findViewById<BottomNavigationView>(R.id.top_navigation)
        topNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.personal_activities -> {
                    is_personal = true
                    setNewAdapter()
                    true
                }
                R.id.common_activities -> {
                    is_personal = false
                    setNewAdapter()
                    true
                }
                else -> false
            }
        }


        return result_view
    }


    private fun setNewAdapter(){
        lifecycleScope.launch {
            myList = if (is_personal) {
                withContext(Dispatchers.IO) {
                    db.activityDao().getPersonalActivities("admin")
                }
            } else {
                withContext(Dispatchers.IO) {
                    db.activityDao().getUsersActivities("admin")
                }
            }
            recycler_view.adapter = ActivityAdapter(myList, result_view)
        }



    }


}