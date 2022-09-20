package com.ersafra.horaparada05

import android.icu.text.NumberFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.ersafra.horaparada05.databinding.ActivityTelaCubagemBinding
import com.google.android.gms.ads.*
import com.google.android.material.textfield.TextInputLayout
import java.text.DecimalFormat

 var FatorAerio = 166.7
 var FatorRodoviario = 300
 var FatorFracionado = 200
 var FatorMaritimo = 1000

 private var mAdView: AdView? = null
 private lateinit var binding: ActivityTelaCubagemBinding

class TelaCubagem : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaCubagemBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


//-----admob-----//
        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        binding.bannerID.loadAd(adRequest)
//-----admob----//

        val rootView = findViewById<View>(android.R.id.content)
        val textInputLayouts = Utils.findViewsWithType(rootView, TextInputLayout::class.java)

        binding.button.setOnClickListener {
            var noErrors = true
            for (textInputLayout in textInputLayouts) {
                val editTextString = textInputLayout.editText!!.text.toString()
                if (editTextString.isEmpty()) {
                    textInputLayout.error = resources.getString(R.string.error_string)
                    noErrors = false
                } else {
                    textInputLayout.error = null
                }
            }
            if (noErrors) {
                 calcular()
            }
        }

    }

    private fun calcular() {
        val u = binding.quantidade.text.toString()
        val und = u.toDouble()
        val c = binding.comprimento.text.toString()
        val comp = c.toDouble()
        val a = binding.altura.text.toString()
        val alt = a.toDouble()
        val l = binding.largura.text.toString()
        val lar = l.toDouble()

        val res = comp * alt * lar * und
        val rp2 = res
        val rp3 = String.format("%.2f", rp2)

        val resr = res * FatorRodoviario
        val resrf = String.format("%.1f", resr)

        val resa = res * FatorAerio
        val resaf = String.format("%.1f", resa)

        val resm = res * FatorMaritimo
        val resmf = String.format("%.1f", resm)

        val resfr = res * FatorFracionado
        val resfra = String.format("%.1f", resfr)

        val las = comp * lar
        val lastro = String.format("%.2f",las)

        ("Metragem do Baú: $rp3 M3\n\n" +
                "Peso Cubado Rodoviario: $resrf kg\n\n" +
                "Peso Cubado Fracionado: $resfra kg\n\n" +
                "Peso Cubado Aéreo: $resaf kg\n\n" +
                "Peso Cubado Maritimo: $resmf kg\n\n" +
                "Metragem do Lastro : $las m2").also { binding.bau.text = it }
            }
}
