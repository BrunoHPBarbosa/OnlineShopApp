package com.example.onlineshopapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onlineshopapp.databinding.ViewholderCartBinding
import com.example.onlineshopapp.databinding.ViewholderCategoryBinding
import com.example.onlineshopapp.helper.ChangeNumberItemsListener
import com.example.onlineshopapp.helper.ManagmentCart
import com.example.onlineshopapp.model.ItemsModel

class CartAdapter(
    private val listItemSelected: ArrayList<ItemsModel>,
    context: Context,
    var changeNumberItemsListener: ChangeNumberItemsListener

):RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(
        val binding: ViewholderCartBinding
    ):RecyclerView.ViewHolder(binding.root)

    private val managmentCart = ManagmentCart(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ViewholderCartBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int  = listItemSelected.size


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = listItemSelected[position]

        holder.binding.titleTxt.text = item.title
        holder.binding.feeEachTime.text = "$${item.price}"
        holder.binding.totalEachItem.text = "$${Math.round(item.numberInCart*item.price)}"
        holder.binding.numberItemTxt.text = item.numberInCart.toString()

        Glide.with(holder.itemView.context)
            .load(item.picUrl[0])
            .into(holder.binding.pic)

        holder.binding.plusCartBtn.setOnClickListener {
            managmentCart.plusItem(listItemSelected,position, object : ChangeNumberItemsListener {
                override fun onChanged() {
                    notifyDataSetChanged()
                    changeNumberItemsListener.onChanged()
                }
            })
        }
        holder.binding.minusCartBtn.setOnClickListener {
            managmentCart.minusItem(listItemSelected,position, object : ChangeNumberItemsListener {
                override fun onChanged() {
                    notifyDataSetChanged()
                    changeNumberItemsListener.onChanged()
                }
            })
        }
    }
}