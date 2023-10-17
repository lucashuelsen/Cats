package br.com.cats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.cats.ui.viewmodel.MainActivityViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}