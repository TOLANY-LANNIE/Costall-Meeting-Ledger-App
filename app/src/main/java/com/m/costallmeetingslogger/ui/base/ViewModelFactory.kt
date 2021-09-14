package com.m.costallmeetingslogger.ui.base

import androidx.lifecycle.ViewModelProvider
import com.m.costallmeetingslogger.repository.BaseRepository

class ViewModelFactory(
    private val repository:BaseRepository
){}