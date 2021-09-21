package com.example.articleapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.articleapp.databinding.FragmentNewsBinding
import com.example.articleapp.databinding.FragmentSavedBinding
import com.example.articleapp.presentation.adapter.NewsAdapter
import com.example.articleapp.presentation.viewModel.NewsViewModel

class SavedFragment : Fragment() {

    private lateinit var fragmentSavedBinding: FragmentSavedBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_saved, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentSavedBinding = FragmentSavedBinding.bind(view)
        viewModel = (activity as MainActivity).viewModel
        newsAdapter = (activity as MainActivity).newsAdapter
        newsAdapter.setOnItemClickListener {
            val bundle = Bundle().apply {
                putSerializable("selected_article", it)
            }
            findNavController().navigate(R.id.action_newsFragment_to_infoFragment, bundle)
        }
        initRecyclerView()
        viewModel.getSavedNews().observe(viewLifecycleOwner, { articles ->
            newsAdapter.differ.submitList(articles)

        })
    }

    private fun initRecyclerView() {
        fragmentSavedBinding.rvSaved.apply {
            adapter = newsAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }
}