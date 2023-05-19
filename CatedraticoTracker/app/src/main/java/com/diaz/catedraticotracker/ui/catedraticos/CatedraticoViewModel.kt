package com.diaz.catedraticotracker.ui.catedraticos

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diaz.catedraticotracker.data.CatedraticoModel
import com.diaz.catedraticotracker.data.RepositoryCatedratico

class CatedraticoViewModel(
    private val repository: RepositoryCatedratico
): ViewModel() {
    private val _catedraticos = MutableLiveData<List<CatedraticoModel>>()
    val catedraticos = _catedraticos

    init {
        getCatedraticos()
    }

    fun getCatedraticos() {
        _catedraticos.value = repository.getCatedraticos()
    }

    fun getCatedraticoById(id: Int): CatedraticoModel? {
        return repository.getCatedraticosById(id)
    }

    fun addCatedratico(catedratico: CatedraticoModel) {
        repository.addCatedratico(catedratico)
        getCatedraticos()
    }
}