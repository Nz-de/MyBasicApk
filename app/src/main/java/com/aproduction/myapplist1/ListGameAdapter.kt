package com.aproduction.myapplist1

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListGameAdapter (val listGame: ArrayList<Game>, private val context: Context) : RecyclerView.Adapter<ListGameAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list_game, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val game = listGame[position]
        Glide.with(holder.itemView.context)
            .load(game.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)
        holder.tvName.text = game.name
        holder.tvDetail.text = game.detail

        holder.itemView.setOnClickListener {
            val getData = listGame.get(position)
            val DetailName: String = getData.name
            val DetailDesc: String = getData.detail
           // val DetailDescription: String = getData.description
            val DetailPhoto: Int = getData.photo
           // val DetailBg: Int = getData.background


            val moveToDetail = Intent(context, DetailActivity::class.java)
            moveToDetail.putExtra("mName", DetailName)
            moveToDetail.putExtra("mDetail", DetailDesc)
           // moveToDetail.putExtra("mDescription", DetailDescription)
            moveToDetail.putExtra("mPhoto", DetailPhoto)
           // moveToDetail.putExtra("mBg", DetailBg)
            context.startActivity(moveToDetail)
        }

    }

    override fun getItemCount(): Int {
        return listGame.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}