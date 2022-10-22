package com.athzaq.idnfest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.athzaq.idnfest.databinding.ActivityTeknologiBinding
import com.athzaq.idnfest.databinding.ItemRecyclerSportsBinding
import com.athzaq.idnfest.databinding.ItemRecyclerTeknologiBinding
import com.athzaq.idnfest.detailactivity.DetailSportsActivity
import com.athzaq.idnfest.detailactivity.DetailTeknologiActivity
import com.athzaq.idnfest.model.ArticlesItem

class AdapterTeknologi(private val listteknologi : ArrayList<ArticlesItem> = arrayListOf()) : RecyclerView.Adapter<AdapterTeknologi.ViewHolder>() {
    class ViewHolder(var binding: ItemRecyclerTeknologiBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifySetDataChanged")
    fun addDataTeknologi(ambilay : List<ArticlesItem>) {
        listteknologi.clear()
        listteknologi.addAll(ambilay)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerTeknologiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataartikel = listteknologi[position]

        holder.binding.txtTitlenewsteknologi.text = dataartikel.title
        holder.binding.txtAuthornewsteknologi.text = dataartikel.author
        holder.binding.txtPublishednewsteknologi.text = dataartikel.publishedAt
        holder.binding.imgNewsteknologi.load(dataartikel.urlToImage)

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailTeknologiActivity::class.java)
            pergi.putExtra(DetailTeknologiActivity.PublishedAt, dataartikel.publishedAt)
            pergi.putExtra(DetailTeknologiActivity.Author, dataartikel.author)
            pergi.putExtra(DetailTeknologiActivity.UrlImage, dataartikel.urlToImage)
            pergi.putExtra(DetailTeknologiActivity.Description, dataartikel.description)
            pergi.putExtra(DetailTeknologiActivity.Title, dataartikel.title)
            pergi.putExtra(DetailTeknologiActivity.Content, dataartikel.content)
            it.context.startActivity(pergi)
        }
    }

    override fun getItemCount() = listteknologi.size
}