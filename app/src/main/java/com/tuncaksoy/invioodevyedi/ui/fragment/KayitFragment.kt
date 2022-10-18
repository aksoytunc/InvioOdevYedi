package com.tuncaksoy.invioodevyedi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.tuncaksoy.invioodevyedi.R
import com.tuncaksoy.invioodevyedi.databinding.FragmentKayitBinding
import com.tuncaksoy.invioodevyedi.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var binding: FragmentKayitBinding
    private lateinit var viewModel: KayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_kayit, container, false)
        binding.kayitFragment = this
        binding.kayitToolbarBaslik = "İş Kayıt"

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewvModel: KayitViewModel by viewModels()
        viewModel = tempViewvModel
    }

    fun buttonKaydet(yapilacak_is: String) {
        viewModel.kaydet(yapilacak_is)
    }
}