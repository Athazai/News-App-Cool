package com.athzaq.idnfest.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.athzaq.idnfest.databinding.ItemRecyclerCovidBinding
import com.athzaq.idnfest.model.ResponseCovid
import com.athzaq.idnfest.service.DataItem
import com.athzaq.idnfest.service.ResponseCovidProv

class AdapterCovid(private val listcovid : ArrayList<com.athzaq.idnfest.model.DataItem> = arrayListOf()) : RecyclerView.Adapter<AdapterCovid.ViewHolder>() {

    class ViewHolder(var binding : ItemRecyclerCovidBinding) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("NotifySetDataChanged")
    fun addDataCovid(ambil : List<com.athzaq.idnfest.model.DataItem>){
        listcovid.clear()
        listcovid.addAll(ambil)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = ItemRecyclerCovidBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artikelitem = listcovid[position]

        holder.binding.txtMeninggalcovid.text = artikelitem.kasusMeni
        holder.binding.txtNamaprovinsi.text = artikelitem.provinsi
        holder.binding.txtPositifcovid.text = artikelitem.kasusPosi
        holder.binding.txtSembuhcovid.text = artikelitem.kasusSemb
    }

    override fun getItemCount() = listcovid.size
}