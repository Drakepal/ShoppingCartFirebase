package com.example.shoppingcartfirebase.viewmodel

import android.os.Message
import com.example.shoppingcartfirebase.model.MenuModel

interface MenuLoadListener {

    fun onMenuLoadSuccess(menuModelList: List<MenuModel>?)
    fun onMenuLoadFailure(message: String?)
}