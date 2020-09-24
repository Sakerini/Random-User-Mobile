package com.example.randomuserdemo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuserdemo.data.remote.model.User
import com.example.randomuserdemo.domen.repository.RandomUserRepository
import kotlinx.coroutines.launch

class RandomUserGenerationViewModel(
    private val randomUserRepository: RandomUserRepository,
    private val QUANTITY: Int = 10
) : ViewModel() {

    //val users = MutableStateFlow<Resource<List<User>>>(Resource.loading(null));


    fun testApi() {
        var testList : List<User>
        var error: String
        viewModelScope.launch {
            randomUserRepository.getRandomUsers(QUANTITY).fold({
                error = it.toString();
            }, {
                testList = it
        })
        }
    }
/*
    fun loadUsers() {
        viewModelScope.launch {
            randomUserRepository.getRandomUsers(QUANTITY).fold({
                users.value = (Resource.error(it.toString(), null))
            }, {
                users.value = Resource(Status.SUCCESS, it, null)//(Resource.success(it))
                println()
            })
        }
        println()
    }

    fun getUsers(): StateFlow<Resource<List<User>>> {
        return users
    }

 */

}