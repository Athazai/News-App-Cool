package com.athzaq.idnfest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.athzaq.idnfest.databinding.ItemRecyclerBisnisBinding
import com.athzaq.idnfest.detailactivity.DetailBisnisActivity
import com.athzaq.idnfest.model.ArticlesItem

class AdapterBisnis(private val listbisnis : ArrayList<ArticlesItem> = arrayListOf()) : RecyclerView.Adapter<AdapterBisnis.ViewHolder>() {
    class ViewHolder(var binding : ItemRecyclerBisnisBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifySetDataChanged")
    fun addDataBisnis(ambiloy : List<ArticlesItem>){
        listbisnis.clear()
        listbisnis.addAll(ambiloy)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerBisnisBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataartikel = listbisnis[position]

        holder.binding.txtTitlenewsbisnis.text = dataartikel.title
        holder.binding.txtAuthornewsbisnis.text = dataartikel.author
        holder.binding.txtPublishednewsbisnis.text = dataartikel.publishedAt
        holder.binding.imgNewsbisnis.load(dataartikel.urlToImage)

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailBisnisActivity::class.java)
            pergi.putExtra(DetailBisnisActivity.PublishedAt, dataartikel.publishedAt)
            pergi.putExtra(DetailBisnisActivity.Author, dataartikel.author)
            pergi.putExtra(DetailBisnisActivity.UrlImage, dataartikel.urlToImage)
            pergi.putExtra(DetailBisnisActivity.Description, dataartikel.description)
            pergi.putExtra(DetailBisnisActivity.Title, dataartikel.title)
            pergi.putExtra(DetailBisnisActivity.Content, dataartikel.content)
            it.context.startActivity(pergi)
        }
    }

    override fun getItemCount() = listbisnis.size
}