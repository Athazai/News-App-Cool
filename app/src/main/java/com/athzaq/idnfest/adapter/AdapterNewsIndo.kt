package com.athzaq.idnfest.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.athzaq.idnfest.databinding.ItemRecyclerIndoBinding
import com.athzaq.idnfest.detailactivity.DetailBisnisActivity
import com.athzaq.idnfest.detailactivity.DetailIndoActivity
import com.athzaq.idnfest.model.ArticlesItem

class AdapterNewsIndo(private val listberita : ArrayList<ArticlesItem> = arrayListOf()) : RecyclerView.Adapter<AdapterNewsIndo.ViewHolder>() {

    class ViewHolder(var binding: ItemRecyclerIndoBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifyDataSetChanged")
    fun addDataindo(ambil : List<ArticlesItem>) {
        listberita.clear()
        listberita.addAll(ambil)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val data = ItemRecyclerIndoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(data)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artikelitem = listberita[position]

        holder.binding.txtTitlenewsindo.text = artikelitem.title
        holder.binding.txtAuthornewsindo.text = artikelitem.author
        holder.binding.txtPublishednewsindo.text = artikelitem.publishedAt
        holder.binding.imgNewsindo.load(artikelitem.urlToImage){
            scale(Scale.FILL)
        }

        holder.itemView.setOnClickListener {
            val pergi = Intent(it.context, DetailIndoActivity::class.java)
            pergi.putExtra(DetailIndoActivity.PublishedAt, artikelitem.publishedAt)
            pergi.putExtra(DetailIndoActivity.Author, artikelitem.author)
            pergi.putExtra(DetailIndoActivity.UrlImage, artikelitem.urlToImage)
            pergi.putExtra(DetailIndoActivity.Description, artikelitem.description)
            pergi.putExtra(DetailIndoActivity.Title, artikelitem.title)
            pergi.putExtra(DetailIndoActivity.Content, artikelitem.content)
            it.context.startActivity(pergi)
        }
    }
    override fun getItemCount() = listberita.size
}