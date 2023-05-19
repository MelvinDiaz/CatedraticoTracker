package com.diaz.catedraticotracker.data

class RepositoryCatedratico() {

   fun getCatedraticos(): List<CatedraticoModel> {
       return catedraticos
   }

    fun getCatedraticosById(id: Int) = catedraticos.find { it.id == id }

    fun addCatedratico(catedratico: CatedraticoModel) {
        catedraticos.add(catedratico)
    }
}