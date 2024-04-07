package com.example.roombd.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.navigation.NavController
import com.example.roombd.App
import com.example.roombd.database.BD
import com.example.roombd.database.User

class ViewModelUser(val bd: BD) : ViewModel()
{

    val login = mutableStateOf("")
    val password = mutableStateOf("")
    val listuser = bd.daoUsers.getusers()

    fun enterApp(list: List<User>, navController: NavController)
    {
        list.map { user -> login.value == user.login && password.value == user.password }
        if(list.isEmpty())
        {
            Toast.makeText(context, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show()
        }
        else
        {
            navController.navigate("home")
        }
    }

    companion object{
        lateinit var context : Application
        val factor : ViewModelProvider.Factory = object : ViewModelProvider.Factory
        {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val datebase =(checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]) as App).db
                context = checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return ViewModelUser(datebase) as T
            }
        }
    }
}