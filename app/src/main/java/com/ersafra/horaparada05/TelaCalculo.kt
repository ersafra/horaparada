package com.ersafra.horaparada05

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ersafra.horaparada05.databinding.ActivityTelaCalculoBinding
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.getDefault


class TelaCalculo : AppCompatActivity() {

    private var mAdViewTC: AdView? = null
    private lateinit var dialog1: AlertDialog
    private lateinit var binding: ActivityTelaCalculoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCalculoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setupAdsTC()


        //binding.btnData.setOnClickListener(this::clickDatePicker)
        //binding.btnDados.setOnClickListener(this::calculateAge)
        binding.btnCalcular.setOnClickListener(this::showModal)
        //binding.imageButton.setOnClickListener(this::abrePeso)

    }
    //não mexer nunca

    private fun abreAnuncio(view: View) {
        startActivity(Intent(this, TelaAntt::class.java))
    }
    private fun abrePeso(view: View) {
        startActivity(Intent(this, InfoPeso::class.java))
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menuInflater.inflate(com.ersafra.horaparada05.R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)}

    private fun setupAdsTC() {
        mAdViewTC = findViewById(R.id.adView)

        val adRequest = AdRequest.Builder().build()
        mAdViewTC?.let { adView ->
            adView.loadAd(adRequest)
            setAdModListener(adView)
        }

    }
    private fun setAdModListener(adView: AdView) {
        adView.adListener = object : AdListener() {
            override fun onAdLoaded() {
                Log.e("======> ", "onAdLoaded: ")
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.e("======> ", "onAdFailedToLoad: $adError ")
            }

            override fun onAdOpened() {
                Log.e("======> ", "onAdOpened")
            }

            override fun onAdClicked() {
                Log.e("======> ", "onAdClicked")
            }

            override fun onAdClosed() {
                Log.e("======> ", "onAdClosed")
            }
        }
    }

    private fun showModal(view: View?) {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.resultado)
        val close = dialog.findViewById<Button>(R.id.btnFechar)
        close.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }

}//fim


