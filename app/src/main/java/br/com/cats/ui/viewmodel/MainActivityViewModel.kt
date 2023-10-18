package br.com.cats.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.cats.model.CatResponse
import br.com.cats.model.Cats
import br.com.cats.model.CatsGallery
import br.com.cats.repository.ImgurAPI
import br.com.cats.services.CatService
import br.com.cats.util.QueueMutableLiveDataLoader
import retrofit2.Callback

class MainActivityViewModel : ViewModel() {
    val catList = MutableLiveData<ArrayList<CatsGallery>>()
    val dataLoader = QueueMutableLiveDataLoader()

    init {
        dataLoader.load(catList){
            ArrayList(ImgurAPI().getCats())
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