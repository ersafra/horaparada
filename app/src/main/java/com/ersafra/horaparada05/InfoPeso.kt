package com.ersafra.horaparada05

import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.ersafra.horaparada05.databinding.ActivityInfoPesoBinding
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import java.util.*


class InfoPeso : AppCompatActivity() {

    private var mAdViewIP: AdView? = null
    private lateinit var ifBinding: ActivityInfoPesoBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ifBinding = ActivityInfoPesoBinding.inflate(layoutInflater)
        setContentView(ifBinding.root)
        setupAdsIP()


        //ifBinding.btnhi.setOnClickListener(this::clickDatePicker)
        // ifBinding.btncalc.setOnClickListener(this::calcJorn)
    }




    //--------------------admob---------------------//
    private fun setupAdsIP() {
        mAdViewIP = findViewById(R.id.adView)

        val adRequest = AdRequest.Builder().build()
        mAdViewIP?.let { adView ->
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
    //--------------------admob---------------------//

 /*   private fun clickDatePicker(view: View) {
        var c: Calendar = Calendar.getInstance()
        TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, HH, mi ->
            val di = "$HH:$mi"
            ifBinding.horaini.text = di
            LocalTimeAddSubtractExample.main(Array(di))
        }, c.get(Calendar.HOUR),
            c.get(Calendar.MINUTE), true).show()
    }

    object LocalTimeAddSubtractExample {
        @JvmStatic
        fun main(args: Array<String>) {
            val time: LocalTime = args[0]
            //ifBinding.Inicio.text = ("Inicio de Viagem"+time)
            System.out.println("Inicio da Jornada "+time)
            // Add hours, minutes, or seconds
            val paUm: LocalTime = time.plusHours(3).plusMinutes(30)
            System.out.println("Primeira Parada (Café) " +paUm)
            val paDois: LocalTime = time.plusHours(4)
            System.out.println("Reinicio "+paDois)
            val paTres: LocalTime = time.plusHours(7).plusMinutes(30)
            System.out.println("Segunda Parada (Almoço) "+paTres)
            val paQuatro: LocalTime = time.plusHours(8).plusMinutes(30)
            System.out.println("Reinicio "+paQuatro)
            val paCinco: LocalTime = time.plusHours(12)
            System.out.println("Terceira Parada (Lanche) "+paCinco)
            val paSeis: LocalTime = time.plusHours(12).plusMinutes(30)
            System.out.println("Reinicio "+paSeis)
            val paSete: LocalTime = time.plusHours(16)
            System.out.println("Quarta Parada (descanso de 8 horas) "+paSete)
            val paOito: LocalTime = time.plusHours(24)
            System.out.println("Reinicio "+paOito)


        }
    }
    //

//descanso
    private fun clickDatePicker(view: View) {
        var c: Calendar = Calendar.getInstance()
         TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, HH, mi ->
            val di = "$HH:$mi"
            //val d1 = "$HH"
            //val d2 = "$mi"

            ifBinding.horaini.text = di
             val df = di.toInt()
             with(LocalTimeAddSubtractExample) {
                 main(Array(df))
             }
         }, c.get(Calendar.HOUR),
            c.get(Calendar.MINUTE), true).show()
    }
    object LocalTimeAddSubtractExample {
    @JvmStatic
        fun main(args: Array<String>) {
            val time: String = args[0]
            //val time: LocalTime = LocalTime.of( 5, 0, 0)
            //ifBinding.Inicio.text = ("Inicio de Viagem"+time)
            System.out.println("Inicio da Jornada "+time)
            // Add hours, minutes, or seconds
            val paUm: LocalTime = time.plusHours(3).plusMinutes(30)
            System.out.println("Primeira Parada (Café) " +paUm)
            val paDois: LocalTime = time.plusHours(4)
            System.out.println("Reinicio "+paDois)
            val paTres: LocalTime = time.plusHours(7).plusMinutes(30)
            System.out.println("Segunda Parada (Almoço) "+paTres)
            val paQuatro: LocalTime = time.plusHours(8).plusMinutes(30)
            System.out.println("Reinicio "+paQuatro)
            val paCinco: LocalTime = time.plusHours(12)
            System.out.println("Terceira Parada (Lanche) "+paCinco)
            val paSeis: LocalTime = time.plusHours(12).plusMinutes(30)
            System.out.println("Reinicio "+paSeis)
            val paSete: LocalTime = time.plusHours(16)
            System.out.println("Quarta Parada (descanso de 8 horas) "+paSete)
            val paOito: LocalTime = time.plusHours(24)
            System.out.println("Reinicio "+paOito)


        }
    }





}*/


}//fim
