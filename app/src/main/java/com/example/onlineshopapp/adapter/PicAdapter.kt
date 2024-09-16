package com.example.onlineshopapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlineshopapp.R
import com.example.onlineshopapp.databinding.ViewholderPicBinding

class PicAdapter(

    val items:MutableList<String>,
    private val onImageSelected:(String)-> Unit

): RecyclerView.Adapter<PicAdapter.ViewHolder>(){

    private var  selectedPosition = 1
    private var lastSelectedPosition = -1


    inner class ViewHolder(val binding: ViewholderPicBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PicAdapter.ViewHolder {
       val binding = ViewholderPicBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PicAdapter.ViewHolder, position: Int) {
        val item = items[position]
        holder.binding.pic.loadImage(item)

        holder.binding.root.setOnClickListener {
            lastSelectedPosition =selectedPosition
            selectedPosition =position
            notifyItemChanged(lastSelectedPosition)
            notifyItemChanged(selectedPosition)

            onImageSelected(item)
        }
        if (selectedPosition== position){
            holder.binding.picLayout.setBackgroundResource(R.drawable.green_bg_selected)
        }else{

            holder.binding.picLayout.setBackgroundResource(R.drawable.gray_bg)
        }
    }

    override fun getItemCount(): Int  = items.size

    fun ImageView.loadImage(url:String){
        Glide.with(this.context)
            .load(url)
            .into(this)
    }
}