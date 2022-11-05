package com.ersafra.horaparada05

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.view.View
import android.widget.Toast
import com.ersafra.horaparada05.databinding.ActivityMainBinding
import com.ersafra.horaparada05.databinding.ActivityMeusDadosBinding
import kotlinx.android.synthetic.main.activity_meus_dados.*

class MeusDados : AppCompatActivity() {

    private lateinit var binding: ActivityMeusDadosBinding
    private val MY_SHARED_PREF_NAME = "preferencias"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMeusDadosBinding.inflate(layoutInflater)
        setContentView(binding.root)


        dadosSalvos()
        binding.btnSalvar.setOnClickListener {
            salvarDados()
                    }
                }

    private fun salvarDados() {

                 val sharePref = getSharedPreferences(MY_SHARED_PREF_NAME,
                   Context.MODE_PRIVATE)

                 val editor = sharePref.edit()
                   editor.putString("TONKEY",binding.tonkey.text.toString())
                   editor.putString("PALKEY",binding.palkey.text.toString())
                   editor.putString("ALTKEY",binding.altkey.text.toString())
                   editor.putString("COMKEY",binding.comkey.text.toString())
                   editor.putString("LARKEY",binding.larkey.text.toString())
                   editor.putString("EIXKEY",binding.eixkey.text.toString())
                   editor.apply()

               Toast.makeText(this,"Dados Salvos",Toast.LENGTH_SHORT).show()

            }

    private fun dadosSalvos(){

        val sharePref = this.getSharedPreferences(MY_SHARED_PREF_NAME,
            Context.MODE_PRIVATE)

        val key_ton =sharePref.getString("TONKEY","")
        val key_pal =sharePref.getString("PALKEY","")
        val key_alt =sharePref.getString("ALTKEY","")
        val key_com =sharePref.getString("COMKEY","")
        val key_lar =sharePref.getString("LARKEY","")
        val key_eix =sharePref.getString("EIXKEY","")

        binding.dadosResult.text =  "Eixos:$key_eix\n" +
                                    "Peso Bruto: $key_ton\n" +
                                    "Paletes: $key_pal\n" +
                                    "Comprimento: $key_com\n" +
                                    "Altura: $key_alt\n" +
                                    "Largura: $key_lar"

    }
        }

