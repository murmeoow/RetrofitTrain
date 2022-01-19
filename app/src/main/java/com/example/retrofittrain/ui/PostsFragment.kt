package com.example.retrofittrain.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
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
        val postViewModel = ViewModelProvider(this, viewModelFactory)[PostViewModel::class.java]

//        val options : Map<String, String> = hashMapOf("_sort" to "id", "_order" to "asc")
//
//        binding.button.setOnClickListener {
//            val myNumber = binding.editTextNumber.text.toString()
//            postViewModel.getCustomPost2(Integer.parseInt(myNumber), options)
//            postViewModel.myResponse3.observe(viewLifecycleOwner, { response ->
//                if (response.isSuccessful) {
//                    Log.d("Response", response.body().toString())
//                    binding.textView.text =  response.body().toString()
//                }else{
//                    Toast.makeText(requireContext() , response.errorBody().toString(), Toast.LENGTH_SHORT).show()
//                    binding.textView.text =  response.body().toString()
//                }
//            })
//        }

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        val adapter = PostsAdapter()
        binding.recyclerView.adapter = adapter

        postViewModel.getPost("11112222")
        postViewModel.myResponse3.observe(viewLifecycleOwner, { response ->
            if (response.isSuccessful){
                adapter.submitList(response.body())
            }else{
                Toast.makeText(requireContext(), response.code(), Toast.LENGTH_SHORT).show()
            }
        })


        return binding.root
    }

}