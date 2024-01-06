package com.brainerx.topimdbmovies

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebSettings.PluginState
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_movie_details.*


class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val movieId = intent.extras!!.getString("movieId")
        val MovieVM = ViewModelProvider(this).get(MoviesViewModel::class.java)
        MovieVM.getMovieById(movieId!!)
        MovieVM.movie.observe(this){movie ->
            if(movie!=null){
                //fill data in the layout
                movie_title.text = "${movie.title} (${movie.year})"
                mWebView.settings.javaScriptEnabled = true
                mWebView.loadUrl(movie.trailer_embed_link)
                mWebView.webChromeClient = WebChromeClient()
                movie_rating_details.text = movie.rating
                movie_description_details.text = movie.description
                Picasso.get().load(movie.big_image).into(movie_big_image)

            }
        }
    }
}