package com.example.onlineshopapp.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.onlineshopapp.R
import com.example.onlineshopapp.adapter.ListItemsAdapter
import com.example.onlineshopapp.databinding.ActivityListItemsBinding
import com.example.onlineshopapp.viewmodel.MainViewModel

class ListItemsActivity : BaseActivity() {

    private val bindind by lazy{
        ActivityListItemsBinding.inflate(layoutInflater)
    }
    private val vieModel = MainViewModel()
    private var id:String = ""
    private var title:String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(bindind.root)

        getBundle()
        initList()
    }

    private fun initList() {
        bindind.apply {
            bindind.backBtn.setOnClickListener { finish() }
            progressBarList.visibility = View.VISIBLE

            // Configurar o RecyclerView antes de atribuir o adapter
            rvList.layoutManager = GridLayoutManager(this@ListItemsActivity, 2)

            vieModel.recommended.observe(this@ListItemsActivity, Observer { items ->
                if (items.isNotEmpty()) {
                    rvList.adapter = ListItemsAdapter(items)
                } else {
                    Log.d("Items", "Nenhum item encontrado para a categoria")
                }
                progressBarList.visibility = View.GONE
            })

            vieModel.loadFiltered(id)
        }
    }

    private fun getBundle() {
        id = intent.getStringExtra("id")!!
        title  = intent.getStringExtra("title")!!

        bindind.categoryTxt.text = title
    }
}