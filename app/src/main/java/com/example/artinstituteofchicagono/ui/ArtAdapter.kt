package com.example.artinstituteofchicagono.ui

import android.app.Dialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.artinstituteofchicagono.data.room.small.SmallPaint
import com.example.artinstituteofchicagono.databinding.ItemBinding
import com.example.artinstituteofchicagono.inter.OnClickListener
import kotlinx.coroutines.*


class ArtAdapter(private val paintings: List<SmallPaint>, private val listener: OnClickListener) :
    RecyclerView.Adapter<ArtAdapter.ViewHolder>() {

    private lateinit var context: Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {


        val bind = ItemBinding.bind(view)

        fun setListener(paint: SmallPaint) {
            bind.root.setOnClickListener {
                listener.onClick(paint)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context
        val view = LayoutInflater.from(context)
            .inflate(com.example.artinstituteofchicagono.R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return paintings.size
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       /* val paint = paintings[position]
        with(holder) {

            // val people = room.paintDao().insert(Paint(paint))

            setListener(paint)
            bind.title.text = paint.title
            bind.author.text = paint.artist_title

            var g: Bitmap? = bind.image.drawable?.toBitmap()






            Glide.with(context)
                .asBitmap()
                .load("https://www.artic.edu/iiif/2/${paint.image_id}/full/843,/0/default.jpg")
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(object : CustomTarget<Bitmap>() {
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: com.bumptech.glide.request.transition.Transition<in Bitmap>?
                    ) {
                        g = resource
                    }

                    override fun onLoadCleared(placeholder: Drawable?) {
                    }
                })

            // CoroutineScope(Dispatchers.IO).launch {
                Glide.with(context)
                    .load("https://www.artic.edu/iiif/2/${paint.image_id}/full/843,/0/default.jpg")
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .centerCrop()
                    .format(DecodeFormat.PREFER_RGB_565)
                    .into(bind.image)

           //  }


            bind.imgCard.setOnClickListener {
                val builder = Dialog(context)
                builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
                builder.window!!.setBackgroundDrawable(
                    ColorDrawable(Color.TRANSPARENT)
                )

                val imageView = ImageView(context)
                imageView.setOnClickListener {
                    Toast.makeText(context, "aaaaa", Toast.LENGTH_SHORT).show()
                }

                if (g != null) {
                    val w = g!!.width
                    val h = g!!.height
                    imageView.setImageBitmap(g)

                    builder.addContentView(
                        imageView, RelativeLayout.LayoutParams(
                            (w * 1.2).toInt(),
                            (h * 1.2).toInt()
                        )
                    )
                    builder.show()
                }

            }

        }

        */


        val paint = paintings[position]
        with(holder) {

            setListener(paint)
            bind.title.text = paint.title
            bind.author.text = paint.artist_title

            var g: Bitmap? = bind.image.drawable?.toBitmap()
            GlobalScope.launch(Dispatchers.IO) {
                val bitmap = withContext(Dispatchers.IO) {
                    Glide.with(context)
                        .asBitmap()
                        .load("https://www.artic.edu/iiif/2/${paint.image_id}/full/843,/0/default.jpg")
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .submit()
                        .get()
                }
                withContext(Dispatchers.Main) {
                    g = bitmap
                    Glide.with(context)
                        .load("https://www.artic.edu/iiif/2/${paint.image_id}/full/843,/0/default.jpg")
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .centerCrop()
                        .format(DecodeFormat.PREFER_RGB_565)
                        .into(bind.image)
                }
            }

            bind.imgCard.setOnClickListener {
                val builder = Dialog(context)
                builder.requestWindowFeature(Window.FEATURE_NO_TITLE)
                builder.window!!.setBackgroundDrawable(
                    ColorDrawable(Color.TRANSPARENT)
                )

                val imageView = ImageView(context)
                imageView.setOnClickListener {
                    Toast.makeText(context, "aaaaa", Toast.LENGTH_SHORT).show()
                }

                if (g != null) {
                    val w = g!!.width
                    val h = g!!.height
                    imageView.setImageBitmap(g)

                    builder.addContentView(
                        imageView, RelativeLayout.LayoutParams(
                            (w * 1.2).toInt(),
                            (h * 1.2).toInt()
                        )
                    )
                    builder.show()
                }
            }
        }
    }


}