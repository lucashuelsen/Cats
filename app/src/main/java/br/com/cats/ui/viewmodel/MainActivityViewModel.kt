package br.com.cats.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.cats.model.Cats

class MainActivityViewModel : ViewModel() {
    val catList: MutableLiveData<ArrayList<Cats>> = MutableLiveData()

    init {
        val cats = ArrayList<Cats>()
        cats.add(Cats("1","https://i.imgur.com/tMyUckg.gifv","Gato 1"))
        cats.add(Cats("2","https://i.imgur.com/tMyUckg.gifv","Gato 2"))
        cats.add(Cats("3","https://i.imgur.com/tMyUckg.gifv","Gato 3"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))
        cats.add(Cats("4","https://i.imgur.com/yK9v63h.jpg","Gato 4"))

        catList.postValue(cats)
    }

    class ViewModelFactory() :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            //Local variables
            val viewModel = when (modelClass) {
                MainActivityViewModel::class.java -> {
                    MainActivityViewModel() as T
                }
                else -> super.create(modelClass)
            }

            return viewModel
        }
    }
}