package br.com.cats.data.usecases

import br.com.cats.data.model.Cats
import br.com.cats.data.model.CatsGallery
import br.com.cats.data.repository.ImgurAPI

class BOCats {
    fun getImagesList(): ArrayList<Cats> {
        val allImages = ArrayList<Cats>()
        getCats().forEach {
            allImages.addAll(it.images)
        }

        return allImages
    }

    fun getCats(): List<CatsGallery> {
        return ImgurAPI().getCats()
    }
}