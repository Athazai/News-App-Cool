package com.athzaq.idnfest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.athzaq.idnfest.databinding.ItemRecyclerEntertaimentBinding
import com.athzaq.idnfest.detailactivity.DetailBisnisActivity
import com.athzaq.idnfest.detailactivity.DetailEntertaimentActivity
import com.athzaq.idnfest.model.ArticlesItem

class AdapterEntertaiment(private val listentertaiment : ArrayList<ArticlesItem> = arrayListOf()) : RecyclerView.Adapter<AdapterEntertaiment.ViewHolder>() {
    class ViewHolder(var binding : ItemRecyclerEntertaimentBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifySetDataChanged")
    fun addDataEntertaiment(ambiloy : List<ArticlesItem>) {
        listentertaiment.clear()
        listentertaiment.addAll(ambiloy)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerEntertaimentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataartikelitem = listentertaiment[position]

        holder.binding.txtTitlenewsentertaiment.text = dataartikelitem.title
        holder.binding.txtAuthornewsentertaiment.text = dataartikelitem.author
        holder.binding.txtPublishednewsentertaiment.text = dataartikelitem.publishedAt
        holder.binding.imgNewsentertaiment.load(dataartikelitem.urlToImage)

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailEntertaimentActivity::class.java)
            pergi.putExtra(DetailEntertaimentActivity.PublishedAt, dataartikelitem.publishedAt)
            pergi.putExtra(DetailEntertaimentActivity.Author, dataartikelitem.author)
            pergi.putExtra(DetailEntertaimentActivity.UrlImage, dataartikelitem.urlToImage)
            pergi.putExtra(DetailEntertaimentActivity.Description, dataartikelitem.description)
            pergi.putExtra(DetailEntertaimentActivity.Title, dataartikelitem.title)
            pergi.putExtra(DetailEntertaimentActivity.Content, dataartikelitem.content)
            it.context.startActivity(pergi)
        }
    }

    override fun getItemCount() = listentertaiment.size
}