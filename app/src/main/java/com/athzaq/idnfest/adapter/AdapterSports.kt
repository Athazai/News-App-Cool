package com.athzaq.idnfest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.athzaq.idnfest.databinding.ItemRecyclerSportsBinding
import com.athzaq.idnfest.detailactivity.DetailEntertaimentActivity
import com.athzaq.idnfest.detailactivity.DetailSportsActivity
import com.athzaq.idnfest.model.ArticlesItem

class AdapterSports(private val listsports : ArrayList<ArticlesItem> = arrayListOf()) : RecyclerView.Adapter<AdapterSports.ViewHolder>() {
    class ViewHolder(var binding : ItemRecyclerSportsBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifySetDataChanged")
    fun addDataSports(ambiluy : List<ArticlesItem>) {
        listsports.clear()
        listsports.addAll(ambiluy)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerSportsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataartikelitem = listsports[position]

        holder.binding.txtTitlenewssports.text = dataartikelitem.title
        holder.binding.txtAuthornewssports.text = dataartikelitem.author
        holder.binding.txtPublishednewssports.text = dataartikelitem.publishedAt
        holder.binding.imgNewssports.load(dataartikelitem.urlToImage)

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailSportsActivity::class.java)
            pergi.putExtra(DetailSportsActivity.PublishedAt, dataartikelitem.publishedAt)
            pergi.putExtra(DetailSportsActivity.Author, dataartikelitem.author)
            pergi.putExtra(DetailSportsActivity.UrlImage, dataartikelitem.urlToImage)
            pergi.putExtra(DetailSportsActivity.Description, dataartikelitem.description)
            pergi.putExtra(DetailSportsActivity.Title, dataartikelitem.title)
            pergi.putExtra(DetailSportsActivity.Content, dataartikelitem.content)
            it.context.startActivity(pergi)
        }
    }

    override fun getItemCount() = listsports.size
}