package com.example.roombd.ui.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.roombd.viewmodel.ViewModelProduct

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainUi(viewModelProduct: ViewModelProduct = viewModel(factory = ViewModelProduct.factor))
{
    val items = viewModelProduct.listitem.collectAsState(initial = emptyList())
    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModelProduct.nameproduct.value,
                onValueChange = { viewModelProduct.nameproduct.value = it },
                label = { Text("Name") },
                modifier = Modifier.weight(1F)
                )
        }
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            TextField(
                value = viewModelProduct.describeproduct.value,
                onValueChange = { viewModelProduct.describeproduct.value = it },
                label = { Text("Describe") },
                modifier = Modifier.weight(1F)
            )
        }
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        TextField(
            value = viewModelProduct.countproduct.value,
            onValueChange = { viewModelProduct.countproduct.value = it },
            label = { Text("Count") },
            modifier = Modifier.weight(1F)
        )
        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            IconButton(onClick = { viewModelProduct.insert() }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
            }
        }
        Spacer(modifier = Modifier.height(5.dp))
        LazyColumn(modifier = Modifier.fillMaxWidth()){
            items(items.value)
            {
                item ->
                ListItems(item, {
                    viewModelProduct.isupdate = it
                    viewModelProduct.nameproduct.value = it.name
                    viewModelProduct.countproduct.value = it.count.toString()
                    viewModelProduct.describeproduct.value = it.describe

                },{
                    viewModelProduct.delete(it)
                })


            }
        }
    }
}