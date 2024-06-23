package com.example.todoapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.passwormanager.home.data.PasswordEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PasswordDao {

    @Query("SELECT * FROM passwordManager")
    fun getAllPassword():Flow<List<PasswordEntity>>

    @Query("SELECT * FROM passwordManager WHERE id=:id")
    fun getPasswordId(id:Int):PasswordEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPassword(passwordEntity: PasswordEntity)

    @Query("UPDATE passwordManager SET accountName = :accountName, userName = :userName, password =:password WHERE id =:id")
    suspend fun updatePassword(accountName:String,password:String,userName:String,id:Int)

    @Delete
    suspend fun deletePassword(passwordEntity: PasswordEntity)
}