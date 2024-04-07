package com.example.roombd

import android.app.Application
import com.example.roombd.database.BD

class App : Application()
{
    val db by lazy { BD.GetDB(this) }
}