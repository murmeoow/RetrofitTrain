package com.example.retrofittrain.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.retrofittrain.R
import com.example.retrofittrain.databinding.FragmentPostsBinding
import com.example.retrofittrain.repository.PostsRepository


class PostsFragment : Fragment() {

    private lateinit var binding: FragmentPostsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPostsBinding.inflate(inflater, container, false)

        val repository = PostsRepository()
        val viewModelFactory = PostViewModelFactory(repository)
        val postViewModel = ViewModelProvider(this, viewModelFactory).get(PostViewModel::class.java)

        postViewModel.getPost()
        postViewModel.myResponse.observe(viewLifecycleOwner, Observer {
            Log.d("Response", it.userId.toString())
            binding.tvIdPost1.text = it.userId.toString()
            binding.tvTitlePost.text = it.title
            binding.tvBodyPost.text = it.body
        })

        return binding.root
    }

}