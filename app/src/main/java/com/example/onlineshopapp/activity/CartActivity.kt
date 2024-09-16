package com.example.onlineshopapp.activity

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.onlineshopapp.R
import com.example.onlineshopapp.adapter.CartAdapter
import com.example.onlineshopapp.databinding.ActivityCartBinding
import com.example.onlineshopapp.helper.ChangeNumberItemsListener
import com.example.onlineshopapp.helper.ManagmentCart

class CartActivity : BaseActivity() {
    private val binding by lazy {
        ActivityCartBinding.inflate(layoutInflater)
    }
    private lateinit var managmentCart: ManagmentCart
    private var tax: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)

        setVariable()
        initCartList()
        calculatorCart()
    }

    private fun initCartList() {
        binding.rvCart.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvCart.adapter = CartAdapter(managmentCart.getListCart(), this,
            object : ChangeNumberItemsListener {
                override fun onChanged() {
                    calculatorCart()
                }

            })
        with(binding){
            emptyTxt.visibility = if (managmentCart.getListCart().isEmpty())View.VISIBLE else View.GONE
            scrollView.visibility = if (managmentCart.getListCart().isEmpty())View.GONE else View.VISIBLE
        }
    }


    private fun setVariable() {
        binding.apply {
            backBtn.setOnClickListener {
                finish()
            }
            method1.setOnClickListener {
                method1.setBackgroundResource(R.drawable.green_bg_selected)
                methodIc1.imageTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(this@CartActivity, R.color.green))
                methodTitle1.setTextColor(getResources().getColor(R.color.green))
                methodSubtitle1.setTextColor(getResources().getColor(R.color.green))

                method2.setBackgroundResource(R.drawable.gray_bg_selected)
                methodIc2.imageTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(this@CartActivity, R.color.black))
                methodTitle2.setTextColor(getResources().getColor(R.color.black))
                methodSubtitle2.setTextColor(getResources().getColor(R.color.gray))
            }
            method2.setOnClickListener {
                method2.setOnClickListener {
                    method2.setBackgroundResource(R.drawable.green_bg_selected)
                    methodIc2.imageTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            this@CartActivity,
                            R.color.green
                        )
                    )
                    methodTitle2.setTextColor(getResources().getColor(R.color.green))
                    methodSubtitle2.setTextColor(getResources().getColor(R.color.green))

                    method1.setBackgroundResource(R.drawable.gray_bg_selected)
                    methodIc1.imageTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(
                            this@CartActivity,
                            R.color.black
                        )
                    )
                    methodTitle1.setTextColor(getResources().getColor(R.color.black))
                    methodSubtitle1.setTextColor(getResources().getColor(R.color.gray))
                }
            }
        }
    }

    private fun calculatorCart() {

        val percentTax = 0.02
        val delivery = 10.0
        tax = Math.round((managmentCart.getTotalFee() * percentTax) * 100) / 100.0
        val total = Math.round((managmentCart.getTotalFee() + tax + delivery) * 100) / 100
        val itemTotal = Math.round(managmentCart.getTotalFee() * 100) / 100

        with(binding) {
            totalFeeTxt.text = "$$itemTotal"
            taxTxt.text = "$$tax"
            deliveryTxt.text = "$$delivery"
            totalTxt.text = "$$total"
        }
    }
}
