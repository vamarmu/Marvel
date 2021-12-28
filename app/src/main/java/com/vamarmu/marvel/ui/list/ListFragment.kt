package com.vamarmu.marvel.ui.list

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.dialog.MaterialDialogs
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.google.android.material.snackbar.Snackbar
import com.vamarmu.marvel.databinding.ListFragmentBinding
import com.vamarmu.marvel.ui.extension.toListItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var _binding : ListFragmentBinding? =null
    private val binding get() = _binding!!

    private val viewModel : ListViewModel by viewModels()

    private val listAdapter : ListAdapter by lazy {
        ListAdapter(emptyList()){
            Toast.makeText(requireContext(),"CLICK ${it.title}",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = ListFragmentBinding.inflate(inflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.status.observe(viewLifecycleOwner){
            when(it){
                is ListViewModel.UiListStatus.ListContent -> updateItems(it.characters.toListItem())
                is ListViewModel.UiListStatus.Error -> showError(it.error)
                is ListViewModel.UiListStatus.Loading -> showLoading()
                is ListViewModel.UiListStatus.NoContent -> showError("No found")
            }
        }
        binding.list.adapter = listAdapter
        viewModel.getCharacters()



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun updateItems(newItems : List<Item>){
        binding.progress.isVisible=false
        listAdapter.items = newItems
    }

    private fun showLoading(){
        binding.progress.isVisible=true
    }

    private fun showError(error : String){
        binding.progress.isVisible=false
        Snackbar.make(requireView(),error, Snackbar.LENGTH_SHORT)
            .show()
    }






}