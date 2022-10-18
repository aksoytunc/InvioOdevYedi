package com.tuncaksoy.invioodevyedi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.tuncaksoy.invioodevyedi.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KayitViewModel @Inject constructor(var yrepo: YapilacaklarRepository) : ViewModel() {

    fun kaydet(yapilacak_is: String) {
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.kaydet(yapilacak_is)
        }
    }
}