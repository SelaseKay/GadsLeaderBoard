package com.judekwashie.leaderboard.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.judekwashie.leaderboard.R
import com.judekwashie.leaderboard.models.TopSkillers

class TopSkillersRecyclerAdapter(context: Context, private val topSkillers: ArrayList<TopSkillers>): RecyclerView.Adapter<TopSkillersRecyclerAdapter.SkillersViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillersViewHolder {
        val itemView = layoutInflater.inflate(R.layout.item_skill_iq, parent, false)
        return SkillersViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return topSkillers.size
    }

    override fun onBindViewHolder(holder: SkillersViewHolder, position: Int) {
        holder.nameTextView.text = topSkillers[position].name
        holder.scoreTextView.text = "${topSkillers[position].score} skill IQ Score, ${topSkillers[position].country}"
    }

    class SkillersViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        val scoreTextView: TextView = itemView.findViewById(R.id.skillIQTextView)
    }

}