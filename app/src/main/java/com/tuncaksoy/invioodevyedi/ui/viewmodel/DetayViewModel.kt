package com.tuncaksoy.invioodevyedi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.tuncaksoy.invioodevyedi.data.repo.YapilacaklarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetayViewModel @Inject constructor(var yrepo: YapilacaklarRepository) : ViewModel() {

    fun guncelle(yapilacak_id: Int, yapilacak_is: String) {
        CoroutineScope(Dispatchers.Main).launch {
            yrepo.guncelle(yapilacak_id, yapilacak_is)
        }
    }
}