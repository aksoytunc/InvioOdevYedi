package com.tuncaksoy.invioodevyedi.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import com.tuncaksoy.invioodevyedi.R
import com.tuncaksoy.invioodevyedi.databinding.FragmentAnasayfaBinding
import com.tuncaksoy.invioodevyedi.ui.adapter.YapilacaklarAdapter
import com.tuncaksoy.invioodevyedi.ui.viewmodel.AnasayfaViewModel
import com.tuncaksoy.invioodevyedi.utils.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_anasayfa, container, false)
        binding.anasayfaFragment = this
        binding.anasayfaToolbarBaslik = "Yapılacaklar"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarAnasayfa)

        viewModel.yapilacaklarListesi.observe(viewLifecycleOwner) {
            val adapter = YapilacaklarAdapter(requireContext(), it, viewModel)
            binding.kisilerAdapter = adapter
        }

        requireActivity().addMenuProvider(
            object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.toolbar_menu, menu)

                    val item = menu.findItem(R.id.action_ara)
                    val searchView = item.actionView as SearchView
                    searchView.setOnQueryTextListener(this@AnasayfaFragment)
                }

                override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                    return false
                }
            },
            viewLifecycleOwner,
            Lifecycle.State.RESUMED
        )

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewvModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewvModel
    }

    fun fabTikla(view: View) {
        Navigation.gecisYap(view, R.id.kisiKayitGecis)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.ara(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.ara(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        viewModel.yapilacaklariYukle()
    }
}