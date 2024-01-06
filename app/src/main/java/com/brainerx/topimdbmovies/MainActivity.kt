package com.brainerx.topimdbmovies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val MoviesVM = ViewModelProvider(this).get(MoviesViewModel::class.java)
        MoviesVM.getMovies()
        val manager = GridLayoutManager(this,3)
        movies_list.layoutManager= manager
        MoviesVM.topMovies.observe(this){ movies->
            if(movies!=null){
                progressBar.visibility = View.GONE
                val adapter = MovieAdapter(this,movies)
                movies_list.adapter = adapter

            }
        }
    }
}