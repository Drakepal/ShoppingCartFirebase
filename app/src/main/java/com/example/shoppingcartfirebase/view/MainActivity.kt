package com.example.shoppingcartfirebase.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppingcartfirebase.R
import com.example.shoppingcartfirebase.databinding.ActivityMainBinding
import com.example.shoppingcartfirebase.model.MenuModel
import com.example.shoppingcartfirebase.viewmodel.MenuLoadListener
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MainActivity : AppCompatActivity(), MenuLoadListener {

    private lateinit var binding: ActivityMainBinding

    lateinit var menuLoadListener: MenuLoadListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
        loadMenuFromFirebase()
    }

    private fun loadMenuFromFirebase() {
        val menuModelsFirebase: MutableList<MenuModel> = ArrayList()
        FirebaseDatabase.getInstance()
            .getReference("Menu")
            .addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()) {
                        for (menuSnapshot in snapshot.children) {
                            val menuModel = menuSnapshot.getValue(MenuModel::class.java)
                            menuModel!!.key = menuSnapshot.key
                            menuModelsFirebase.add(menuModel)
                        }
                        menuLoadListener.onMenuLoadSuccess(menuModelsFirebase)
                    }
                    else
                        menuLoadListener.onMenuLoadFailure("Item does not exist.")
                }

                override fun onCancelled(error: DatabaseError) {
                    menuLoadListener.onMenuLoadFailure(error.message)
                }

            })
    }

    private fun init() {
        menuLoadListener = this
    }

    override fun onMenuLoadSuccess(menuModelList: List<MenuModel>?) {

    }

    override fun onMenuLoadFailure(message: String?) {
        Snackbar.make(binding.mainLayout, message!!, Snackbar.LENGTH_LONG).show()
    }
}