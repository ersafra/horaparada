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


        binding.btnData.setOnClickListener(this::clickDatePicker)
        binding.btnDados.setOnClickListener(this::calculateAge)
        binding.btnCalcular.setOnClickListener(this::showModal)
        //binding.imageButton.setOnClickListener(this::abrePeso)

    }
    //não mexer nunca
    private fun clickDatePicker(view: View) {
        if (TextUtils.isEmpty(binding.capv.text.toString())){
            binding.capv.error = "Valor Obrigatório"
            return}

        var c: Calendar = Calendar.getInstance()
        DatePickerDialog(this, DatePickerDialog.OnDateSetListener { _, yy, mm, dd ->
            var dt = "$dd/${mm + 1}/$yy"
            TimePickerDialog(this, TimePickerDialog.OnTimeSetListener { _, hh, mi ->
                dt += " $hh:$mi"
                binding.dataini.text = dt
                //("Data do inicio para calculo:$dt").also { binding.txtTempo.text = it }
            }, c.get(Calendar.HOUR), c.get(Calendar.MINUTE), true).show()
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show()
    }
    private fun calculateAge(view: View) {
        if (TextUtils.isEmpty(binding.capv.text.toString())){
            binding.capv.error = "Valor Obrigatório"
            return}
        //editar quando mudar os valores
        val valvha = 2.12/60
        val diadiv = "0,0354"
        //fim da edição
        var dobs = binding.dataini.text.toString()
        var sdf = SimpleDateFormat("dd/MM/yyyy HH:mm", getDefault())
        var dob = sdf.parse(dobs)
        val selectedDateInHour = dob!!.time / 60000
        val currentDateHour = sdf.parse(sdf.format(System.currentTimeMillis()))
        val currentDateToHour = currentDateHour!!.time / 60000
        val valnhora = currentDateToHour - selectedDateInHour
        if (valnhora < 300){
            ("O periodo apurado é de: $valnhora minutos, você só terá direito à indenização a partir de 300 minutos (5 horas).").also { binding.txtVtotal.text = it }
            return
        }
        val valordahora = valnhora * valvha
        binding.txtParcial.text =  valnhora.toString()
        binding.txtVhora.text =  valordahora.toString()
        val peso = binding.txtVhora.text.toString()
        val p1 : Float = peso.toFloat()
        val diaria1 = binding.capv.text.toString()
        val d1 : Float = diaria1.toFloat()
        val cmt = p1 * d1
        val dec = DecimalFormat("R$#,##0.00")
        val vcmt = dec.format(cmt)
        ("O período apurado foi de $valnhora minutos, com valor de $diadiv, por minuto parado. O valor a receber é de : $vcmt.").also { binding.txtVtotal.text = it }
    }
    private fun abreAnuncio(view: View) {
        startActivity(Intent(this, TelaAntt::class.java))
    }
    private fun abrePeso(view: View) {
        startActivity(Intent(this, InfoPeso::class.java))
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean{
        menuInflater.inflate(com.ersafra.horaparada05.R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)}
    /*override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            com.ersafra.horaparada05.R.id.enco ->{
                val build = AlertDialog.Builder(this)
                val view = layoutInflater.inflate(com.ersafra.horaparada05.R.layout.comofaz,null)
                build.setView(view)
                val btnClose = view.findViewById<ImageButton>(com.ersafra.horaparada05.R.id.btnclose)
                btnClose.setOnClickListener{dialog1.dismiss()}
                dialog1 = build.create()
                dialog1.show()
            }
        }
        return super.onOptionsItemSelected(item)
    }*/
    //fim-->Admob
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


