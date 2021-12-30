package com.vamarmu.marvel.ui.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.vamarmu.domain.AspectRatioImage
import com.vamarmu.domain.MarvelCharacter
import com.vamarmu.marvel.R
import com.vamarmu.marvel.databinding.DetailFragmentBinding
import com.vamarmu.marvel.ui.extension.getUrl
import com.vamarmu.marvel.ui.extension.getUrlWithAspectRatio
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailFragment : Fragment() {

    private var _binding : DetailFragmentBinding? =null
    private val binding get() = _binding!!

    private val viewModel : DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = DetailFragmentBinding.inflate(inflater,container,false)
        return binding.root

    }
    
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).supportActionBar?.apply {
            title =""
        }
        viewModel.status.observe(viewLifecycleOwner){
            when(it){
                is DetailViewModel.UiDetailStatus.DetailContent -> updateUI(it.characters)
                is DetailViewModel.UiDetailStatus.Error -> showError(it.error)
                is DetailViewModel.UiDetailStatus.Loading -> showLoading()
                is DetailViewModel.UiDetailStatus.NoContent -> showError("No found")
            }
        }
    }

    private fun updateUI(characters : MarvelCharacter){
        binding.progress.isVisible = false

        (activity as AppCompatActivity).supportActionBar?.apply {
            title = characters.name
            setDisplayHomeAsUpEnabled(true)
        }
        with(binding){
            progress.isVisible = false
            detail.isVisible = true
            description.text = characters.description
            Glide.with(requireContext()).load(characters.thumbnail.getUrlWithAspectRatio(
                AspectRatioImage.landscape_amazing)).into(thumbnail)
        }

    }

    private fun showLoading(){
        binding.progress.isVisible = true
    }

    private fun showError(error : String){
        binding.progress.isVisible = false
        Snackbar.make(requireView(),error, Snackbar.LENGTH_SHORT)
            .show()
    }

    companion object {
        const val ARG_CHARACTERS_ID = "charactersId"
    }

}