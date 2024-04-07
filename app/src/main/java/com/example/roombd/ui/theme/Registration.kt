package com.example.roombd.ui.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.roombd.viewmodel.ViewModelReg

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Registration(navController: NavController, viewModelReg: ViewModelReg = viewModel(factory = ViewModelReg.fabric))
{
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Регистрация",
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(bottom = 16.dp)),
        )

        OutlinedTextField(
            value = viewModelReg.newlogin.value,
            onValueChange = { viewModelReg.newlogin.value = it },
            label = { Text("Логин") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(bottom = 8.dp))
        )

        OutlinedTextField(
            value = viewModelReg.newpassword.value,
            onValueChange = { viewModelReg.newpassword.value = it },
            label = { Text("Пароль") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(PaddingValues(bottom = 8.dp))
        )

        Button(
            onClick = {
               viewModelReg.insert(navController)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Регистрация")
        }
    }
}