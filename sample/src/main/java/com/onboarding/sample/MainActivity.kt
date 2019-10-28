package com.onboarding.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.appinfo.appmonsta.AppInfoView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private val supervisor = SupervisorJob()
    private var scope = CoroutineScope(Dispatchers.IO + supervisor)
    private var appInfoView: AppInfoView? = null
    private var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appInfoView = findViewById(R.id.app_info_view)
        editText = findViewById(R.id.edit_text)
    }

    fun onClickShowAppInfo(view: View) {
        appInfoView?.let {
            startBgJob(it, editText?.text.toString())
        }
    }

    private fun startBgJob(view: AppInfoView, packageName: String): Job {
        return scope.launch(block = {
            val appInfoFromPhone = view.getAppInfoFromPhone(packageName)
            appInfoFromPhone?.let {
                withContext(Dispatchers.Main) {
                    view.setModel(appInfoFromPhone)
                }
            } ?:run {
                val model = view.syncLoadAppInfo(packageName)
                model?.let {
                    withContext(Dispatchers.Main) {
                        view.setModel(model)
                    }
                }
            }
        })
    }



}
