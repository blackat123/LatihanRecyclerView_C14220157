package com.example.latihanrecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class adapterRevView(private val listWayang: ArrayList<wayang>) :
    RecyclerView.Adapter<adapterRevView.ListViewHolder>() {
    private lateinit var onItemClickCallBack: OnItemClickCallBack

    interface OnItemClickCallBack {
        fun onItemClicked(data: wayang)
        fun delData(pos: Int)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var _namaWayang: TextView = itemView.findViewById(R.id.namaWayang)
        var _karakterWayang: TextView = itemView.findViewById(R.id.karakterWayang)
        var _deskripsiWayang: TextView = itemView.findViewById(R.id.deskripsiWayang)
        var _gambarWayang: ImageView = itemView.findViewById(R.id.gambarWayang)
        var _btnHapus: Button = itemView.findViewById(R.id.btnHapus)
    }

    fun setOnItemClickCallBack(onItemClickCallBack: OnItemClickCallBack) {
        this.onItemClickCallBack = onItemClickCallBack
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
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
        holder._gambarWayang.setOnClickListener {
//            Toast.makeText(holder.itemView.context, wayang.nama, Toast.LENGTH_LONG).show()
            onItemClickCallBack.onItemClicked(listWayang[position])
        }
        holder._btnHapus.setOnClickListener {
            onItemClickCallBack.delData(position)
        }
    }
}