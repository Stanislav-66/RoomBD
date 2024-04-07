package com.example.roombd.ui.theme

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.roombd.database.Products


@Composable
fun ListItems(
    item : Products,
    onAdd: (Products) -> Unit,
    onDelete: (Products) -> Unit
)
{
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
        .clickable { onAdd(item) }
    )
    {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically)
        {
            Text(item.name, modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .padding(10.dp))
            Text(item.count.toString(), modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .padding(10.dp))
            Text(item.describe, modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
                .padding(10.dp))
            IconButton(onClick = { onDelete(item) }) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
            }
        }
    }
}