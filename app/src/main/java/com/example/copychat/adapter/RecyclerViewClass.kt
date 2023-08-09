package com.example.copychat.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.copychat.Fragment.MessageDataClass
import com.example.copychat.R

class RecyclerViewClass(var messageDataClass: ArrayList<MessageDataClass>)  : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var viewType = 1
    class LeftViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tvLeftView = view.findViewById<TextView>(R.id.tvLeft)
        var tvLeftTime = view.findViewById<TextView>(R.id.tvLeftTime)
    }
    class RightViewHolder(var view: View) : RecyclerView.ViewHolder(view) {
        var tvRightView = view.findViewById<TextView>(R.id.tvRight)
        var tvRightTime = view.findViewById<TextView>(R.id.tvRightTime)
    }

    override fun getItemViewType(position: Int): Int {
        this.viewType = messageDataClass[position].type ?: 1
        return super.getItemViewType(position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        if(this.viewType == 1){
            return LeftViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chat_left, parent, false))
        }else {
            return RightViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.chat_right, parent, false))
        }

    }

    override fun getItemCount(): Int {
        return messageDataClass.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder) {
            is RightViewHolder -> {
                holder.tvRightView.setText(messageDataClass[position].message)
                holder.tvRightTime.setText(messageDataClass[position].time)
            }

            is LeftViewHolder -> {
                holder.tvLeftView.setText(messageDataClass[position].message)
                holder.tvLeftTime.setText(messageDataClass[position].time)
            }
        }
    }

}
