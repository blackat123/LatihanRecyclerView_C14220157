package com.example.latihanrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class adapterRevView(private val listWayang: ArrayList<wayang>) : RecyclerView.Adapter<adapterRevView.ListViewHolder> () {
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _namaWayang: TextView = itemView.findViewById(R.id.namaWayang)
        var _karakterWayang: TextView = itemView.findViewById(R.id.karakterWayang)
        var _deskripsiWayang: TextView = itemView.findViewById(R.id.deskripsiWayang)
        var _gambarWayang: ImageView = itemView.findViewById(R.id.gambarWayang)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listWayang.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val wayang = listWayang[position]

        holder._namaWayang.setText(wayang.nama)
        holder._karakterWayang.setText(wayang.karakter)
        holder._deskripsiWayang.setText(wayang.deskripsi)
        Log.d("TEST", wayang.foto)
        Picasso.get().load(wayang.foto).into(holder._gambarWayang)
    }
}