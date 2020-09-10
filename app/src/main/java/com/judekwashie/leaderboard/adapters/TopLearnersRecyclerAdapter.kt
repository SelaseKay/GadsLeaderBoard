package com.judekwashie.leaderboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.judekwashie.leaderboard.R
import com.judekwashie.leaderboard.TopLearners

class TopLearnersRecyclerAdapter(context: Context, private val topLearners: ArrayList<TopLearners>) :
    RecyclerView.Adapter<TopLearnersRecyclerAdapter.TopLearnerViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopLearnerViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_learners, parent, false)
        return TopLearnerViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return topLearners.size
    }

    override fun onBindViewHolder(holder: TopLearnerViewHolder, position: Int) {
        holder.nameTextView.text = topLearners[position].name
        holder.hoursTextView.text = "${topLearners[position].hours} learning hours, ${topLearners[position].country}"
    }

    class TopLearnerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val hoursTextView: TextView = itemView.findViewById(R.id.hoursTextView)
    }
}