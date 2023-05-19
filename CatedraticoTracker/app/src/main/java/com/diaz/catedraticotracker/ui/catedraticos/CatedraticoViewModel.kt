package com.diaz.catedraticotracker.ui.catedraticos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.diaz.catedraticotracker.CatedraticosTrackerApplication
import com.diaz.catedraticotracker.data.CatedraticoModel
import com.diaz.catedraticotracker.data.RepositoryCatedratico

class CatedraticoViewModel(
    private val repository: RepositoryCatedratico
) : ViewModel() {
    private val _catedraticosList = MutableLiveData<List<CatedraticoModel>>()
    val catedraticosList = _catedraticosList
    private val _name = MutableLiveData<String>()
    val name = _name
    private val _lastName = MutableLiveData<String>()
    val lastName = _lastName
    private val _id = MutableLiveData<Int>()
    val id = _id
    private val _titulo = MutableLiveData<String>()
    val titulo = _titulo

    fun getCatedraticos() {
        _catedraticosList.value = repository.getCatedraticos()
    }

    fun getCatedraticoById(id: Int): CatedraticoModel? {
        return repository.getCatedraticosById(id)
    }

    fun addCatedratico(catedratico: CatedraticoModel) {
        repository.addCatedratico(catedratico)
        getCatedraticos()
    }

    fun onAddingChange(name: String, lastName: String, id: Int, titulo: String) {
        _name.value = name
        _lastName.value = lastName
        _id.value = id
        _titulo.value = titulo
    }



    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val repository =
                    (this[APPLICATION_KEY] as CatedraticosTrackerApplication).catedraticoRepository
                CatedraticoViewModel(repository)
            }
        }
    }
}