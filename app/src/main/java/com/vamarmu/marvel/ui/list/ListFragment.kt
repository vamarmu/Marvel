package com.vamarmu.marvel.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.vamarmu.marvel.R
import com.vamarmu.marvel.databinding.ListFragmentBinding
import com.vamarmu.marvel.ui.detail.DetailFragment
import com.vamarmu.marvel.ui.extension.toListItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment() {

    private var _binding : ListFragmentBinding? =null
    private val binding get() = _binding!!

    private val viewModel : ListViewModel by viewModels()

    private val listAdapter : ListAdapter by lazy {
        ListAdapter(emptyList()){
            val bundle = bundleOf(DetailFragment.ARG_CHARACTERS_ID to it.id)
            binding.root.findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
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
        (activity as AppCompatActivity).supportActionBar?.apply {
            title =requireContext().resources.getString(R.string.app_name)
        }


        viewModel.status.observe(viewLifecycleOwner){
            when(it){
                is ListViewModel.UiListStatus.ListContent -> updateItems(it.characters.toListItem())
                is ListViewModel.UiListStatus.Error -> showError(it.error)
                is ListViewModel.UiListStatus.Loading -> showLoading()
                is ListViewModel.UiListStatus.NoContent -> showError("No found")
            }
        }
        binding.list.adapter = listAdapter


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun updateItems(newItemDataViews : List<ItemDataView>){
        binding.progress.isVisible=false
        listAdapter.itemDataViews = newItemDataViews
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