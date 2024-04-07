package com.example.roombd.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roombd.App
import com.example.roombd.database.BD
import com.example.roombd.database.Products
import kotlinx.coroutines.launch

class ViewModelProduct(val bd : BD) : ViewModel()
{
    val listitem = bd.daoProducts.getproducts()
    val nameproduct = mutableStateOf("")
    val describeproduct = mutableStateOf("")
    val countproduct = mutableStateOf("")
    var isupdate : Products? = null


    fun insert() = viewModelScope.launch {
        val update = isupdate?.copy(name = nameproduct.value) ?: Products(name = nameproduct.value, count = countproduct.value.toIntOrNull() ?: 0, describe = describeproduct.value  )
        if(nameproduct.value.isEmpty() || describeproduct.value.isEmpty())
        {
            Toast.makeText(context, "Не заполнены все поля", Toast.LENGTH_SHORT).show()
        }
        else
        {
            bd.daoProducts.insert(update)
            isupdate = null
            clear()
        }

    }

    fun delete(item: Products) = viewModelScope.launch {
            bd.daoProducts.delete(item)
    }

    private fun clear()
    {
        nameproduct.value = ""
        describeproduct.value = ""
        countproduct.value = ""
    }


    companion object{
        lateinit var context : Application
        val factor : ViewModelProvider.Factory = object : ViewModelProvider.Factory
        {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
                val datebase =(checkNotNull(extras[APPLICATION_KEY]) as App).db
                context = checkNotNull(extras[APPLICATION_KEY]) as App
                return ViewModelProduct(datebase) as T
            }
        }
    }
}