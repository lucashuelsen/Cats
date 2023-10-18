package br.com.cats.ui.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.cats.data.model.Cats
import br.com.cats.data.usecases.BOCats
import br.com.cats.util.QueueMutableLiveDataLoader

class MainActivityViewModel : ViewModel() {
    val imageList = MediatorLiveData<ArrayList<Cats>>()
    val dataLoader = QueueMutableLiveDataLoader()

    init {
        dataLoader.load(imageList){
            BOCats().getImagesList()
        }
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