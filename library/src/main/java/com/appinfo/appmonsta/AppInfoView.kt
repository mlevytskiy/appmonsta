package com.appinfo.appmonsta

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Parcelable
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
import java.lang.Exception

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

//    override fun onSaveInstanceState(): Parcelable {
//        return super.onSaveInstanceState()
//
//    }
//
//    override fun onRestoreInstanceState(state: Parcelable) {
//        super.onRestoreInstanceState(state)
//    }

    fun syncLoadAppInfo(appPackage: String): AppInfoModel? {
        val url = AppmonstaRequest().packageName(appPackage).getUrl()
        try {
            val doc = Jsoup.connect(url).get()
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
        } catch (e: Exception) {
            return null
        }
    }

    fun setModel(model: AppInfoModelFromPhone) {
        textView.setText(model.appName)
        textView.setTextColor(Color.BLACK)
        imageView.setImageDrawable(model.imageDrawable)
        imageView.setBackgroundColor(Color.TRANSPARENT)
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

    fun getAppInfoFromPhone(appPackage: String): AppInfoModelFromPhone? {
        val pm = context.packageManager
        var appInfo: ApplicationInfo?
        try {
            appInfo = pm.getApplicationInfo(appPackage, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            appInfo = null
        }
        appInfo?.let {
            val label = (pm.getApplicationLabel(appInfo) ?: "(unknown)").toString()
            val icon = pm.getApplicationIcon(appInfo)

            return AppInfoModelFromPhone(label, appPackage, icon)
        } ?:run {
            return null
        }
    }

}