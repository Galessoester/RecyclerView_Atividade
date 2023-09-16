package com.example.estergalesso_rm89350

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.estergalesso_rm89350.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding

    val FilmeAdapter = FilmeItemAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.filmesRecycle.layoutManager = LinearLayoutManager(this)


        bind.filmesRecycle.adapter = FilmeAdapter


        FilmeAdapter.setList(

        )


    }


}