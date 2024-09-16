package com.example.onlineshopapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.onlineshopapp.R
import com.example.onlineshopapp.databinding.ViewholderModelBinding

class SelectModelAdapter(val items: MutableList<String>) :
    RecyclerView.Adapter<SelectModelAdapter.ViewHolder>() {

    private var selectedPosition = 1
    private var lastSelectedPosition = -1
    private lateinit var context: Context

    inner class ViewHolder(
        val binding: ViewholderModelBinding
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SelectModelAdapter.ViewHolder {
        context = parent.context
        val binding =
            ViewholderModelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: SelectModelAdapter.ViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {
        holder.binding.modelTxt.text = items[position]

        holder.binding.root.setOnClickListener {
            lastSelectedPosition = selectedPosition
            selectedPosition = position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)
        }
        if (selectedPosition == position) {
            holder.binding.modelLayout.setBackgroundResource(R.drawable.green_bg_selected)
            holder.binding.modelTxt.setTextColor(context.resources.getColor(R.color.green))

        } else {
            holder.binding.modelLayout.setBackgroundResource(R.drawable.gray_bg)
            holder.binding.modelTxt.setTextColor(context.resources.getColor(R.color.black))
        }

    }

    override fun getItemCount(): Int = items.size

}