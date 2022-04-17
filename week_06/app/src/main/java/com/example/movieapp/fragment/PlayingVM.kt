package com.example.movieapp.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.lang.Exception
import com.example.movieapp.modal.Movie
import com.example.movieapp.services.MovieRestClient
import com.example.movieapp.services.MovieApis
class PlayingVM: ViewModel() {
    private var _movieData: MutableLiveData<List<Movie>> = MutableLiveData<List<Movie>>()
    val movieData: LiveData<List<Movie>>
        get() = _movieData

    private var _errEvent: MutableLiveData<String> = MutableLiveData<String>()
    val errEvent: LiveData<String>
        get() = _errEvent

    fun getNowPlaying() {
        viewModelScope.launch {
            try {
                val movieResp = MovieRestClient.getInstance().api.listNowPlayMovies(
                    language = "en_US",
                    page = 1,

                )
                _movieData.postValue(movieResp.results!!)
            } catch (e: Exception) {
                _errEvent.value = e.message
            }
        }
    }


    fun getComingUpMovie() {
        viewModelScope.launch {
            val movieResp = MovieRestClient.getInstance().api.listRatedMovies(
                language = "en-US",
                page = 1,
            )
            _movieData.postValue(movieResp.results!!)
        }
    }
}