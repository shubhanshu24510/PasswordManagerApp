package com.example.passwormanager.home.pesentation

import android.util.Base64
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.passwormanager.home.data.PasswordEntity
import com.example.passwormanager.home.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val _passwordList = MutableStateFlow<List<PasswordEntity>>(emptyList())
    val passwordList = _passwordList.asStateFlow()
    val loading = mutableStateOf(false)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getAllPassword().distinctUntilChanged()
                .collect { listOfPassword ->

                    if (listOfPassword.isEmpty()) {
                        Log.d("TAG", "EmptyList")
                    } else {
                        _passwordList.value = listOfPassword
                    }
                }
        }
    }

    fun AddPassword(passwordEntity: PasswordEntity) = viewModelScope.launch {
        loading.value = true
        delay(2000L)
        repository.addPassword(passwordEntity)
        loading.value = false
    }

    fun Delete(passwordEntity: PasswordEntity) = viewModelScope.launch {
        loading.value = true
        delay(2000L)
        repository.deletedPassword(passwordEntity)
        loading.value = false
    }

    fun Update(passwordEntity: PasswordEntity) = viewModelScope.launch {
        loading.value = true
        delay(2000L)
        repository.updatePassword(passwordEntity)
        loading.value = false
    }

    var key: String = "mysecretkey12345"
    var secretKeySpec = SecretKeySpec(key.toByteArray(), "AES")
    fun encrypt(string: String): String {

        val cipher =
            Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(
            Cipher.ENCRYPT_MODE,
            secretKeySpec
        )
        val encryptBytes =
            cipher.doFinal(string.toByteArray(Charsets.UTF_8))
        return Base64.encodeToString(encryptBytes, Base64.DEFAULT)
    }

    fun decrypt(string: String): String {
        val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec)
        val decryptedBytes =
            cipher.doFinal(Base64.decode(string, Base64.DEFAULT))
        return String(decryptedBytes, Charsets.UTF_8)
    }
}