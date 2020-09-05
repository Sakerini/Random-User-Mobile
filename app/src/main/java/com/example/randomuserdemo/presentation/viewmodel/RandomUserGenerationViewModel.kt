package com.example.randomuserdemo.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuserdemo.data.model.User
import com.example.randomuserdemo.data.repository.RandomUserRepository
import com.example.randomuserdemo.data.utils.Resource
import com.example.randomuserdemo.presentation.service.NetworkService
import kotlinx.coroutines.launch

class RandomUserGenerationViewModel(
    private val randomUserRepository: RandomUserRepository,
    private val networkService: NetworkService,
    private val QUANTITY: Int = 10
) : ViewModel() {

    private val _users = MutableLiveData<Resource<List<User>>>()
    val users: LiveData<Resource<List<User>>> get() = _users

    private fun loadUsers() {
        viewModelScope.launch {
            _users.postValue(Resource.loading(null))

            if (networkService.isNetworkConnected()) {
                randomUserRepository.getRandomUsers(QUANTITY).fold({
                    _users.postValue(Resource.error(it.toString(), null))
                }, {
                    _users.postValue(Resource.success(it))
                })
            }
        }
    }
}