package com.example.retrofittrain.ui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofittrain.R
import com.example.retrofittrain.databinding.PostItemBinding
import com.example.retrofittrain.models.PostIListResponseItem

class PostsAdapter: ListAdapter<PostIListResponseItem, PostsAdapter.PostHolder>(PostsDiffCallback()) {


    class PostHolder(item: View): RecyclerView.ViewHolder(item) {

        val binding = PostItemBinding.bind(item)

        fun bind(post: PostIListResponseItem) = with(binding){

            tvTitle.text = post.title
            tvBody.text = post.body

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.post_item, parent, false)
        return PostHolder(view)
    }

    override fun onBindViewHolder(holder: PostHolder, position: Int) {
        holder.bind(getItem(position))
    }

}

class PostsDiffCallback : DiffUtil.ItemCallback<PostIListResponseItem>() {
    override fun areItemsTheSame(oldItem: PostIListResponseItem, newItem: PostIListResponseItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PostIListResponseItem, newItem: PostIListResponseItem): Boolean {
        return oldItem == newItem
    }
}
