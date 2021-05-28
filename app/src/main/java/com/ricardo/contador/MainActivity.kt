package com.ricardo.contador

import android.app.usage.UsageEvents
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.ricardo.contador.databinding.ActivityMainBinding




class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        MobileAds.initialize(this) {}
        // Obtain the FirebaseAnalytics instance.
        firebaseAnalytics = Firebase.analytics

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val adview = binding.adView
        val adRequest = AdRequest.Builder().build()
        adview.loadAd(adRequest)

        initEvents()
    }

    private fun initEvents(){
        binding.buttonGetStarted.setOnClickListener {

        /*    firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM){
                param(FirebaseAnalytics.Param.ITEM_ID, 1)
                param(FirebaseAnalytics.Param.ITEM_NAME, "start")
                param(FirebaseAnalytics.Param.CONTENT_TYPE, "image")

                }*/

            firebaseAnalytics.logEvent(EVENT_INICIO_APP){

                param(PARAM_PRUEBA, "prueba de parametro")
            }

            startActivity(
                Intent(
                    this,
                    CountersActivity::class.java
                )
            )
        }
    }
    companion object{
        const val EVENT_INICIO_APP = "star app"
        const val PARAM_PRUEBA = "PRUEBA"


    }
}

