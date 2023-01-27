package com.example.rickapimorty.ui.fragments._home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.rickapimorty.data.model.Characters
import com.example.rickapimorty.databinding.FragmentRickAndMortyBinding
import com.example.rickapimorty.ui.adapter.RickAndMortyAdapter

class RickAndMortyFragment : Fragment() {

    private lateinit var binding: FragmentRickAndMortyBinding
    private val viewModel by viewModels<RickAndMortyViewModel>()
    private val rickAndMortyAdapter = RickAndMortyAdapter(this::onClickFirstListener)
    private val allCharacter = arrayListOf<Characters>()
    private var nextPage = 2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRickAndMortyBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
        setupObserve()
    }

    private fun initialize() {
        binding.rvRickAndMorty.adapter = rickAndMortyAdapter
    }

    private fun onClickFirstListener(id: Int) {
        findNavController().navigate(
            RickAndMortyFragmentDirections.actionRickAndMortyFragmentToDetailFragment(
                id
            )
        )
    }

    private fun setupListeners() {
        binding.btmAdd.setOnClickListener {
            viewModel.getCharacter(page = nextPage++)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun setupObserve() {
        viewModel.rickAndMortyLiveData.observe(viewLifecycleOwner) {
            allCharacter.addAll(it)
            rickAndMortyAdapter.submitList(allCharacter)
            rickAndMortyAdapter.notifyDataSetChanged()
        }
        viewModel.errorLiveData.observe(viewLifecycleOwner){
        }
    }
}
