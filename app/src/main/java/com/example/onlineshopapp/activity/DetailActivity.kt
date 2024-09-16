package com.example.onlineshopapp.activity

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.onlineshopapp.adapter.PicAdapter
import com.example.onlineshopapp.adapter.SelectModelAdapter
import com.example.onlineshopapp.databinding.ActivityDetailBinding
import com.example.onlineshopapp.helper.ManagmentCart
import com.example.onlineshopapp.model.ItemsModel

class DetailActivity : BaseActivity() {

    private val binding by lazy{
        ActivityDetailBinding.inflate(layoutInflater)
    }
    private lateinit var item:ItemsModel
    private var numberOrder = 1
    private lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)

        getBundle()
        initList()
    }

    private fun initList() {
        val modelList = ArrayList<String>()
        for(models in item.model){
            modelList.add(models)
        }
        binding.modelList.adapter = SelectModelAdapter(modelList)
        binding.modelList.layoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        
        val picList = ArrayList<String>()
        for(imgUrl in item.picUrl){
        picList.add(imgUrl)

        }
        Glide.with(this)
            .load(picList[0])
            .into(binding.img)

        binding.picList.adapter =PicAdapter(picList){selectedImgUrl ->
            Glide.with(this)
                .load(selectedImgUrl)
                .into(binding.img)
        }
        binding.picList.layoutManager =LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
    }

    private fun getBundle() {
        item = intent.getParcelableExtra("object")!!

        binding.titleTxt.text = item.title
        binding.descriptionTxt.text = item.description
        binding.priceText.text ="$${item.price}"
        binding.ratingTxt.text ="${item.rating} Rating"
        binding.addToCartBtn.setOnClickListener {
            item.numberInCart = numberOrder
            managmentCart.insertItem(item)
        }
        binding.backBtn.setOnClickListener { finish() }
        binding.cartBtn.setOnClickListener {
            startActivity(Intent(this@DetailActivity,CartActivity::class.java))
        }
    }
}