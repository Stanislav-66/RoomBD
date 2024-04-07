package com.example.roombd.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.NavController
import com.example.roombd.App
import com.example.roombd.database.BD
import com.example.roombd.database.User
import kotlinx.coroutines.launch
import kotlin.math.log

class ViewModelReg(val bd : BD) : ViewModel()
{
    val newlogin = mutableStateOf("")
    val newpassword = mutableStateOf("")

    fun insert(navController: NavController) = viewModelScope.launch {
        if(newlogin.value.isEmpty() || newpassword.value.isEmpty())
        {
            Toast.makeText(context, "Не все поля заполнены", Toast.LENGTH_SHORT).show()
        }
        else
        {
            val user = User(login = newlogin.value, password = newpassword.value)
            bd.daoUsers.insert(user)
            clear()
            navController.navigate("auth")
        }

    }

    private fun clear()
    {
        newlogin.value = ""
        newpassword.value = ""
    }

    companion object{
        lateinit var context : Application
        val fabric : ViewModelProvider.Factory = object : ViewModelProvider.Factory
        {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val database = (checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App).db
                context = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App
                return ViewModelReg(database) as T
            }
        }
    }
}