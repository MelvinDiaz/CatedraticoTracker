package com.diaz.catedraticotracker.ui.catedraticos

import android.text.Spannable.Factory
import android.util.Log
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