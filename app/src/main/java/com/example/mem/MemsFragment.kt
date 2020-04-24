package com.example.mem

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment.*

class MemsFragment : Fragment(){
    val adapter = Adapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycle.adapter = adapter
        recycle.layoutManager = GridLayoutManager(context, 2)
        adapter.name = listOf(
            Meme("https://vignette.wikia.nocookie.net/jamesbond/images/d/dc/James_Bond_%28Pierce_Brosnan%29_-_Profile.jpg/revision/latest?cb=20130506224906"),
            Meme("https://imgflip.com/s/meme/Drake-Hotline-Bling.jpg")
        )
    }

    inner class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

        var name: List<Meme>? = null
            set(value) {
                field = value
                notifyDataSetChanged()
            }


        override fun getItemCount(): Int {
            return name?.size ?: 0
        }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val inflater = LayoutInflater.from(context)
            val view = inflater.inflate(R.layout.for_element, parent, false)
            return ViewHolder(view)
        }


        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val meme = name!![position]
            Picasso.get().load(meme.url).error(ColorDrawable(
                Color.RED)).fit().centerCrop().into(holder.imageView)

        }

        inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val imageView = itemView.findViewById<ImageView>(R.id.oneitem)
        }
    }

}


