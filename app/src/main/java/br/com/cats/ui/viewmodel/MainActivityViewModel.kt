package br.com.cats.ui.viewmodel

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.cats.data.model.Cats
import br.com.cats.data.model.CatsGallery
import br.com.cats.data.repository.ImgurAPI
import br.com.cats.util.QueueMutableLiveDataLoader

class MainActivityViewModel : ViewModel() {
    val catList = MutableLiveData<ArrayList<CatsGallery>>()
    val imageList = MediatorLiveData<ArrayList<Cats>>()
    val dataLoader = QueueMutableLiveDataLoader()

    init {
        dataLoader.load(catList){
            ArrayList(ImgurAPI().getCats())
        }

        imageList.addSource(catList){
            imageList.value = getImagesList(it)
        }
    }

    fun getImagesList(catsGalleries: ArrayList<CatsGallery>): ArrayList<Cats> {
        val allImages = ArrayList<Cats>()

        catsGalleries.forEach {
            allImages.addAll(it.images)
        }

        return allImages
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