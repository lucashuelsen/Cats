package br.com.cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import br.com.cats.databinding.ActivityMainBinding
import br.com.cats.ui.adapter.CatsAdapterList
import br.com.cats.ui.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    private var mBinding : ActivityMainBinding? = null
    private var mViewModel: MainActivityViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupViewModel()
        setupBinding()
        setupObservers()
        reloadList()
    }

    private fun setupObservers(){
        mViewModel?.catList?.observe(this){
        }

        mViewModel?.imageList?.observe(this){
            reloadList()
        }
    }

    private fun setupViewModel(){
        mViewModel = ViewModelProvider(this,
            MainActivityViewModel.ViewModelFactory()
        ).get(MainActivityViewModel::class.java)
    }

    private fun setupBinding(){
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding?.lifecycleOwner = this
        mBinding?.viewModel = mViewModel
    }

    private fun reloadList(){
        mBinding?.rcvCats?.layoutManager = GridLayoutManager(this, GRID_COLS)

        val adapter = CatsAdapterList(
            viewLifecycleOwner = this,
            mViewModel?.imageList?.value?: arrayListOf()
            )

        mBinding?.rcvCats?.adapter = adapter
    }


    companion object{
        const val GRID_COLS = 4
    }
}