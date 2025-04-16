
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.MyFEFUApplication.EmptyState
import com.example.MyFEFUApplication.R
import com.example.MyFEFUApplication.entity.ActivityEntity


class ActivityAdapter(activityList: List<ActivityEntity>, view: View) : RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {
    private val activityList = activityList
    private val view = view

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout, parent, false)
        return ActivityViewHolder(view)
    }
    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val activity = activityList[position]
        holder.bind(activity)

    }

    override fun getItemCount(): Int = activityList.size

    inner class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val item_distance: TextView = itemView.findViewById(R.id.item_distance)
        private val item_type: TextView = itemView.findViewById(R.id.item_type)
        private val item_date: TextView = itemView.findViewById(R.id.item_date)

        fun bind(activity: ActivityEntity) {
            item_distance.text = activity.distanceInMeters.toString()
            item_type.text = activity.type
            item_date.text = activity.date

            itemView.setOnClickListener {
                val intent = Intent(view.context, EmptyState::class.java)
                intent.putExtra("activity_id", activity.id)
                view.context.startActivity(intent)
            }
        }
    }
}