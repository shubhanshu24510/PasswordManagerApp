package com.example.todoapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.passwormanager.home.data.PasswordEntity



@Database(
    entities = [PasswordEntity::class],
    version = 3,
    exportSchema = false

)
abstract class PasswordDatabase:RoomDatabase() {
    abstract fun PasswordDao():PasswordDao
}