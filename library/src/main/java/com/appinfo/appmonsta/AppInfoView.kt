package com.appinfo.appmonsta

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.Gravity.CENTER
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import org.jsoup.Jsoup

class AppInfoView(context: Context, attrs: AttributeSet) : LinearLayout(context, attrs) {

    private val textView: TextView
    private val imageView: ImageView

    init {
        orientation = VERTICAL
        gravity = CENTER
        setBackgroundResource(R.drawable.app_background)
        val view = View.inflate(getContext(), R.layout.view_app_info, this)
        textView = view.findViewById(R.id.text_view)
        imageView = view.findViewById(R.id.image_view)
    }

    fun syncLoadAppInfo(appPackage: String): AppInfoModel {
        val url = AppmonstaRequest().packageName(appPackage).getUrl()
        val doc = Jsoup.connect(url).get()

//        val bigTitle = doc.select("h1[itemprop]=name")
//        val titleElement = bigTitle.select("span[content]")
//        val titleStr = titleElement.attr("content")
//        titleStr?.let {
//            title = titleStr
//        }

        val metaElements = doc.select("meta[property=og:title]")
        var title = ""
        metaElements.singleOrNull()?.let {
            title = it.attr("content")
        }

        val images = doc.select("img[src]")
        val appIcon = images.filter {
            val url = it.absUrl("src")
            url.startsWith("https://lh3.googleusercontent.com/")
        }.find {
            (it.attr("alt").contentEquals("Cover art"))
        }?.absUrl("src")
        appIcon?.let {
            return AppInfoModel(title, appPackage, it)
        } ?:run {
            return AppInfoModel(title, appPackage, "")
        }

    }

    fun setModel(model: AppInfoModel) {
        textView.setText(model.appName)
        Glide.with(this).load(model.imageUrl)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    imageView.setBackgroundColor(Color.TRANSPARENT)
                    textView.setTextColor(Color.BLACK)
                    return false
                }
            })
            .into(imageView)
    }

}