package com.example.artinstituteofchicagono.ui

import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.core.graphics.drawable.toBitmap
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.CustomTarget
import com.example.artinstituteofchicagono.databinding.ItemSkBinding

class SkelAdapter (private val paintings: List<Char>) :
    RecyclerView.Adapter<SkelAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val bind = ItemSkBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context).inflate(com.example.artinstituteofchicagono.R.layout.item_sk, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return paintings.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){

        }

    }




}