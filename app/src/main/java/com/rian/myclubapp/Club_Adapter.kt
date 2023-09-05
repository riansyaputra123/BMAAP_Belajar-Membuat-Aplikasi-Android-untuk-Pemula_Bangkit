package com.rian.myclubapp

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class Club_Adapter (private val listClub: ArrayList<Club>) : RecyclerView.Adapter<Club_Adapter.ListViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.list_club, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listClub.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo, berdiri, negara, liga, kota, urlNegara, urlLiga) = listClub[position]
        Glide.with(holder.itemView.context)
            .load(photo) // URL Gambar
            .into(holder.imgPhoto) // imageView mana yang akan diterapkan
        holder.tvName.text = name
        holder.tvDescription.text = description

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, Detail_Club::class.java)
            moveDetail.putExtra(Detail_Club.EXTRA_DESCRIPTION, description)
            moveDetail.putExtra(Detail_Club.EXTRA_NAME, name)
            moveDetail.putExtra(Detail_Club.EXTRA_PHOTO, photo)
            moveDetail.putExtra(Detail_Club.EXTRA_FOUNDED, berdiri)
            moveDetail.putExtra(Detail_Club.EXTRA_NATION, negara)
            moveDetail.putExtra(Detail_Club.EXTRA_LEAGUE, liga)
            moveDetail.putExtra(Detail_Club.EXTRA_CITY, kota)
            moveDetail.putExtra(Detail_Club.EXTRA_NATION_IMG, urlNegara)
            moveDetail.putExtra(Detail_Club.EXTRA_LEAGUE_IMG, urlLiga)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_club_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_club_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_club_description)
    }




}