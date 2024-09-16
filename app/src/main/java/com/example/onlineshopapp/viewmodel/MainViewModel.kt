package com.example.onlineshopapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.onlineshopapp.model.CategoryModel
import com.example.onlineshopapp.model.ItemsModel
import com.example.onlineshopapp.model.SliderModel
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener

class MainViewModel() : ViewModel() {
    private val firebaseDataBase = FirebaseDatabase.getInstance()

    private val _banners = MutableLiveData<List<SliderModel>>()
    private val _category = MutableLiveData<MutableList<CategoryModel>>()
    private val _recommended = MutableLiveData<MutableList<ItemsModel>>()

    val banners: LiveData<List<SliderModel>> = _banners
    val categories: LiveData<MutableList<CategoryModel>> = _category
    val recommended: LiveData<MutableList<ItemsModel>> = _recommended

    fun loadFiltered(id: String) {
        val Ref = firebaseDataBase.getReference("Items")
        val query: Query = Ref.orderByChild("categoryId").equalTo(id)
        query.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<ItemsModel>()
                for (childSnapShot in snapshot.children) {
                    Log.d("FirebaseData", "Processing snapshot: ${childSnapShot.value}")
                    val list = childSnapShot.getValue(ItemsModel::class.java)
                    if (list != null) {

                        lists.add(list)
                    }
                }
                _recommended.value = lists
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e("FirebaseError", "Erro ao carregar itens: ${error.message}")
            }
        })
    }


    fun loadRecommended() {
        val Ref = firebaseDataBase.getReference("Items")
        val query: Query = Ref.orderByChild("showRecommended").equalTo(true)
        query.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<ItemsModel>()
                for (childSnapShot in snapshot.children) {

                    Log.d("FirebaseData", "DataSnapshot: ${childSnapShot.value}")
                    val list = childSnapShot.getValue(ItemsModel::class.java)
                    if (list != null) {
                        lists.add(list)
                    }
                }
                _recommended.value = lists
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })


    }

    fun loadCategory() {
        val Ref = firebaseDataBase.getReference("Category")
        Ref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<CategoryModel>()
                for (childSnapShot in snapshot.children) {
                    val list = childSnapShot.getValue(CategoryModel::class.java)
                    if (list != null) {
                        lists.add(list)
                    }
                }
                _category.value = lists


            Log.d("FirebaseData", "Categorias carregadas: $lists")
        }

                override fun onCancelled(error: DatabaseError) {
            Log.e("FirebaseError", "Erro ao carregar categorias: ${error.message}")
        }

        })
    }

    fun loadBanners() {
        val Ref = firebaseDataBase.getReference("Banner")
        Ref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                val lists = mutableListOf<SliderModel>()
                for (childSnapShot in snapshot.children) {
                    val list = childSnapShot.getValue(SliderModel::class.java)
                    if (list != null) {
                        lists.add(list)
                    }
                }
                _banners.value = lists

            }

            override fun onCancelled(error: DatabaseError) {

            }

        })
    }
}