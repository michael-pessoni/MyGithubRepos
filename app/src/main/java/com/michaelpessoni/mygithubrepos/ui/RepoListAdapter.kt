package com.michaelpessoni.mygithubrepos.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.michaelpessoni.mygithubrepos.data.model.Repo
import com.michaelpessoni.mygithubrepos.databinding.ItemRepoBinding
import com.bumptech.glide.Glide


class RepoListAdapter : ListAdapter<Repo, RepoListAdapter.ViewHolder>(DiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRepoBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoListAdapter.ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ViewHolder(
        private val binding: ItemRepoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Repo) {
            binding.tvRepoName.text = item.name
            binding.tvRepoDescription.text = item.description
            binding.tvRepoLang.text = item.language
            binding.chipStar.text = item.stargazersCount.toString()

            Glide.with(binding.root.context)
                .load(item.owner.avatarURL).into(binding.ivOwner)
        }

    }
}

class DiffCallback : DiffUtil.ItemCallback<Repo>() {
    override fun areItemsTheSame(oldItem: Repo, newItem: Repo) = oldItem == newItem

    override fun areContentsTheSame(oldItem: Repo, newItem: Repo) = oldItem.id == newItem.id

}