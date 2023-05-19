package com.diaz.catedraticotracker

import android.app.Application
import com.diaz.catedraticotracker.data.RepositoryCatedratico
import com.diaz.catedraticotracker.data.catedraticos

class CatedraticosTrackerApplication() : Application() {

    val catedraticoRepository: RepositoryCatedratico by lazy {
        RepositoryCatedratico()
    }
}