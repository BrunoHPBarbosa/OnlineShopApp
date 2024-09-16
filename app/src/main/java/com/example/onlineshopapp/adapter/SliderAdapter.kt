package com.example.onlineshopapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.request.RequestOptions
import com.example.onlineshopapp.databinding.SliderItemContainerBinding
import com.example.onlineshopapp.model.SliderModel


class SliderAdapter(
    private var sliderItems: List<SliderModel>,
    private val viewPager2: ViewPager2

):RecyclerView.Adapter<SliderAdapter.SliderViewHolder>() {

    private lateinit var context: Context
    private var runable = Runnable {
        sliderItems = sliderItems
        notifyDataSetChanged()
    }

    class SliderViewHolder(
        private val binding: SliderItemContainerBinding

    ) : ViewHolder(binding.root) {
        fun setImage(sliderItems: SliderModel, context: Context) {
            Glide.with(context)
                .load(sliderItems.url)
                .apply { RequestOptions().transform(CenterInside()) }
                .into(binding.imgSlider)
        }

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SliderViewHolder {
        context = parent.context
        val binding =SliderItemContainerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SliderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SliderViewHolder, position: Int) {
        holder.setImage(sliderItems[position],context)
        if(position== sliderItems.lastIndex-1){
            viewPager2.post(runable)
        }

    }

    override fun getItemCount(): Int = sliderItems.size


    }
