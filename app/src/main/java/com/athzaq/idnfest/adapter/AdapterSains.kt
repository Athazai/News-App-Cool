package com.athzaq.idnfest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.athzaq.idnfest.databinding.ActivitySainsBinding
import com.athzaq.idnfest.databinding.ItemRecyclerSainsBinding
import com.athzaq.idnfest.detailactivity.DetailSainsActivity
import com.athzaq.idnfest.detailactivity.DetailSportsActivity
import com.athzaq.idnfest.model.ArticlesItem

class AdapterSains(private val listsains : ArrayList<ArticlesItem> = arrayListOf()) : RecyclerView.Adapter<AdapterSains.ViewHolder>() {
    class ViewHolder(var binding : ItemRecyclerSainsBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifySetDataChanged")
    fun addDataSains(ambiley : List<ArticlesItem>) {
        listsains.clear()
        listsains.addAll(ambiley)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerSainsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataartikel = listsains[position]

        holder.binding.txtTitlenewssains.text = dataartikel.title
        holder.binding.txtAuthornewssains.text = dataartikel.author
        holder.binding.txtPublishednewssains.text = dataartikel.publishedAt
        holder.binding.imgNewssains.load(dataartikel.urlToImage)

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailSainsActivity::class.java)
            pergi.putExtra(DetailSainsActivity.PublishedAt, dataartikel.publishedAt)
            pergi.putExtra(DetailSainsActivity.Author, dataartikel.author)
            pergi.putExtra(DetailSainsActivity.UrlImage, dataartikel.urlToImage)
            pergi.putExtra(DetailSainsActivity.Description, dataartikel.description)
            pergi.putExtra(DetailSainsActivity.Title, dataartikel.title)
            pergi.putExtra(DetailSainsActivity.Content, dataartikel.content)
            it.context.startActivity(pergi)
        }
    }

    override fun getItemCount() = listsains.size
}