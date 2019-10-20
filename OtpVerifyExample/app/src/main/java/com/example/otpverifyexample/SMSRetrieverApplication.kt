package com.example.otpverifyexample

import android.app.Application
import android.util.Log

/**
 * Created by Chintan on 01-11-2017.
 */
class SMSRetrieverApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        /*Following will generate the hash code*/
       /* var appSignature = AppSignatureHelper(this)
        appSignature.appSignatures
        Log.d("Hash Key:",appSignature.appSignatures.get(0))*/
    }
}