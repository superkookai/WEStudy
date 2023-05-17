package com.superkookai.westudy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import android.content.Intent as Intent

class DataAdapter(val dataModelList: List<DataModel>): RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.model,parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataModel = dataModelList[position]
        holder.textTitle.text = dataModel.title

        Picasso.get().load(dataModel.photo)
            .error(R.mipmap.ic_launcher)
            .placeholder(R.drawable.placeholder)
            .into(holder.imageView)

        val title = dataModel.title
        val desc = dataModel.desc
//        val photo = dataModel.photo
        val video = dataModel.video
        holder.imageView.setOnClickListener{ v ->
            val intent = Intent(v.context, DetailActivity::class.java)
            intent.putExtra("TITLE", title)
            intent.putExtra("DESC",desc)
//            intent.putExtra("PHOTO", photo)
            intent.putExtra("VIDEO", video)
            v.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataModelList.size
    }
}

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)  {

    var textTitle: TextView = itemView.findViewById(R.id.title)
    var imageView: ImageView

    init {
        imageView = itemView.findViewById(R.id.thumbnail)
    }


}
