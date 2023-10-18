package br.com.cats.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import br.com.cats.R
import br.com.cats.databinding.FragmentImageZoomBinding
import br.com.cats.ui.viewmodel.ImageZoomViewModel

class ImageZoom : AppCompatDialogFragment() {
    private lateinit var viewModel: ImageZoomViewModel
    private lateinit var mBinding: FragmentImageZoomBinding

    var img: ImageView? = null

    companion object {
        fun newInstance(img: ImageView): ImageZoom{
            val imageZoom = ImageZoom()
            imageZoom.img = img

            return imageZoom
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setupBinding(inflater, container)

        return mBinding.root
    }

    private fun setupBinding(inflater: LayoutInflater, container: ViewGroup?) {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_image_zoom,
            container,
            false
        )

        mBinding.lifecycleOwner = this

        //Set image to dialog
        mBinding.imageView.setImageDrawable(img?.drawable)

        //Close dialog
        mBinding.btnBack.setOnClickListener{
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        val width = ViewGroup.LayoutParams.MATCH_PARENT
        val height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog?.window?.setLayout(width, height)
        dialog?.window?.setBackgroundDrawableResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ImageZoomViewModel::class.java)
    }

}