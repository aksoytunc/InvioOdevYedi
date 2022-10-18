package com.tuncaksoy.invioodevyedi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.tuncaksoy.invioodevyedi.R
import com.tuncaksoy.invioodevyedi.databinding.FragmentDetayBinding
import com.tuncaksoy.invioodevyedi.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {
    private lateinit var viewModel: DetayViewModel
    private lateinit var binding: FragmentDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detay, container, false)
        binding.detayFragment = this
        binding.detayToolbarBaslik = "İş Detay"

        val bundle: DetayFragmentArgs by navArgs()
        val gelenIs = bundle.yapilacaklar

        binding.yapilacakIsNesnesi = gelenIs
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewvModel: DetayViewModel by viewModels()
        viewModel = tempViewvModel
    }

    fun buttonGuncelle(yapilacak_id: Int, yapilacak_is: String) {
        viewModel.guncelle(yapilacak_id, yapilacak_is)
    }
}