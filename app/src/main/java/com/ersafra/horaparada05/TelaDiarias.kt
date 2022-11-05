package com.ersafra.horaparada05

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import com.ersafra.horaparada05.databinding.ActivityTelaDiariasBinding
import com.google.android.gms.ads.*
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_tela_calculo.*
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*


private var mAdViewTC: AdView? = null
private lateinit var binding: ActivityTelaDiariasBinding

class TelaDiarias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaDiariasBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        binding.banDiarias.loadAd(adRequest) //banner load

        val rootView = findViewById<View>(android.R.id.content)
        val textInputLayouts = Utils.findViewsWithType(
            rootView, TextInputLayout::class.java)

        binding.datainicial.setOnFocusChangeListener { view, isFocused ->
            if (view.isInTouchMode && isFocused) {
                view.performClick()
            }
        }
        binding.datainicial.setOnClickListener {
            showDatePicker()
        }
        binding.btncaldado.setOnClickListener{
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
                calcularDiaria()
            }
        }
        binding.btnvoltar.setOnClickListener(this::voltar)
    }

    private fun showDatePicker() {
        var c: Calendar = Calendar.getInstance()
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, yy, mm, dd ->
            var dt = "$dd/${mm + 1}/$yy"
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hh, mi ->
                dt += " $hh:$mi"
               binding.datainicial.setText(dt)
             }, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), true).show()
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show()
    }
    private fun calcularDiaria() {
        //editar quando mudar os valores
        val hantt = 2.12
        val valvha = hantt/60
        val diadiv = "0,0354"
        //fim da edição
        var dobs = binding.datainicial.text.toString()
        var sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
        var dob = sdf.parse(dobs)

        val dataini = dob!!.time / 60000
        val datafim = sdf.parse(sdf.format(System.currentTimeMillis()))
        val datafimT = datafim!!.time / 60000
        val valnhora = datafimT - dataini
//--------------dias e horas------------//
        val data_ini = dob!!.time
        val data_fim = sdf.parse(sdf.format(System.currentTimeMillis()))
        val data_fimT = data_fim!!.time
        val val_nhora = data_fimT - data_ini
        val dias = val_nhora /86400000
        val horas = val_nhora %86400000/3600000
        val minutos = val_nhora %86400000%3600000/60000


        if (valnhora < 300){
            ("O periodo apurado é de: $valnhora minutos, você só terá direito à indenização a partir de 300 minutos (5 horas).").also { binding.dtxt.text = it }
            ("").also { binding.dtxt1.text = it }
            ("").also { binding.dtxt2.text = it }
            ("").also { binding.dtxt3.text = it }
            ("").also { binding.dtxt4.text = it }
            ("").also { binding.dtxt5.text = it }
            return
        }

        val valordahora = valnhora * valvha
        //binding.dtxt.text =  valnhora.toString()
        //binding.dtxt1.text =  valordahora.toString()
        //val peso = binding.dtxt1.text.toString()
        val peso = valordahora.toString()
        val p1 : Float = peso.toFloat()
        val diaria1 = binding.capcarga.text.toString()
        val d1 : Float = diaria1.toFloat()
        val cmt = p1 * d1
        val dec = DecimalFormat("R$#,##0.00")
        val vcmt = dec.format(cmt)

        ("Capacidade de carga $diaria1 toneladas\n").also { binding.dtxt.text = it }
        ("Tempo de espera: $dias  dia(s) ,$horas  hora(s) e $minutos  minuto(s)\n").also { binding.dtxt1.text = it }
        ("O valor da hora para calculo é de $hantt\n").also { binding.dtxt2.text = it }
        ("Formula = Cap. x Nºhoras x R$ 2,12\n").also { binding.dtxt3.text = it }
        ("Valor apurado da(s) diaria(s)\n").also { binding.dtxt4.text = it }
        ("   $vcmt   ").also { binding.dtxt5.text = it }

    }
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
    fun voltar(view: View) {
        startActivity(Intent(this, MainActivity::class.java))
    }

}


