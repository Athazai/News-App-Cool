package com.athzaq.idnfest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.athzaq.idnfest.databinding.ItemRecyclerHealthBinding
import com.athzaq.idnfest.detailactivity.DetailEntertaimentActivity
import com.athzaq.idnfest.detailactivity.DetailHealthActivity
import com.athzaq.idnfest.model.ArticlesItem

class AdapterHeath(private val listhealth : ArrayList<ArticlesItem> = arrayListOf()) : RecyclerView.Adapter<AdapterHeath.ViewHolder>() {
    class ViewHolder(var binding : ItemRecyclerHealthBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifySetDataChanged")
    fun addDataHealth(ambiley : List<ArticlesItem>) {
        listhealth.clear()
        listhealth.addAll(ambiley)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerHealthBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataartikel = listhealth[position]

        holder.binding.txtTitlenewshealth.text = dataartikel.title
        holder.binding.txtAuthornewshealth.text = dataartikel.author
        holder.binding.txtPublishednewshealth.text = dataartikel.publishedAt
        holder.binding.imgNewshealth.load(dataartikel.urlToImage)

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailHealthActivity::class.java)
            pergi.putExtra(DetailHealthActivity.PublishedAt, dataartikel.publishedAt)
            pergi.putExtra(DetailHealthActivity.Author, dataartikel.author)
            pergi.putExtra(DetailHealthActivity.UrlImage, dataartikel.urlToImage)
            pergi.putExtra(DetailHealthActivity.Description, dataartikel.description)
            pergi.putExtra(DetailHealthActivity.Title, dataartikel.title)
            pergi.putExtra(DetailHealthActivity.Content, dataartikel.content)
            it.context.startActivity(pergi)
        }
    }

    override fun getItemCount() = listhealth.size
}