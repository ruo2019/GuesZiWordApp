package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ScoreViewModel(finalScore : Int): ViewModel() {
    private var _score = MutableLiveData<Int>()
    val score : LiveData<Int>
    get() = _score
    init {
        _score.value = finalScore
        Log.i("ScoreViewModel", "Final score is $finalScore")
    }
}

class ScoreViewModelFactory(private val finalScore: Int):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(finalScore) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}