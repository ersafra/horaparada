package com.ersafra.horaparada05

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import com.ersafra.horaparada05.databinding.ActivityFracionadoBinding
import com.google.android.material.textfield.TextInputLayout
import java.text.DecimalFormat

var FA = 166.7 // aerio
var FR = 300   // rodoviario
var FF = 200   // fracionado
var FM = 1000  // maritimo

val DEC = DecimalFormat("R$ #,##0.00")

private lateinit var binding: ActivityFracionadoBinding
private val MY_SHARED_PREF_NAME = "preferencias"

class Fracionado : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFracionadoBinding.inflate(layoutInflater)
        setContentView(binding.root)


        dadosCarregados()

        val rootView = findViewById<View>(android.R.id.content)
        val textInputLayouts = Utils.findViewsWithType(rootView, TextInputLayout::class.java)

        binding.buttonfra.setOnClickListener {
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
                calcularfra()
            }
        }

    }

    private fun dadosCarregados(){
        val nome = intent.getStringExtra("tabelaantt")
        val n_ome = nome?.toDouble()
        val n_o_me = DEC.format(n_ome)

        val sharePref = this.getSharedPreferences(MY_SHARED_PREF_NAME, Context.MODE_PRIVATE)
        val fra_ton = sharePref.getString("TONKEY","")
        val fra_pal = sharePref.getString("PALKEY","")
        val fra_alt = sharePref.getString("ALTKEY","")
        val fra_com = sharePref.getString("COMKEY","")
        val fra_lar = sharePref.getString("LARKEY","")
        val fra_eix = sharePref.getString("EIXKEY","")
       //teste//
        val alt_fra = fra_alt.toString()
        val afd = alt_fra.toDouble()
        val com_fra = fra_com.toString()
        val cfd = com_fra.toDouble()
        val lar_fra = fra_lar.toString()
        val lfd = lar_fra.toDouble()

        val cubcar = afd*cfd*lfd
        val cub_car = String.format("%.2f", cubcar)

        val pescub = cubcar * FR
        val pe_scub = String.format("%.0f",pescub)
        //val pe_scub = String.format("%2.f", p_escub)
        //teste//

        binding.baufra.text = "Valor Tabela ANTT para a Rota : $n_o_me\n"+
                              "Capacidade do seu Veiculo: $fra_ton ton\n" +
                              "Quantidade de Paletes: $fra_pal PBR\n" +
                              "Quantidade de eixos do Veiculo: $fra_eix\n" +
                              "Cubagem do Veiculo: $cub_car m3\n" +
                              "Peso Cubado: $pe_scub kg"

    }

    private fun calcularfra() {
        //recebe o valor da tabela antt
        val nome = intent.getStringExtra("tabelaantt")
        val n_ome = nome?.toDouble()
        val n_o_me = DEC.format(n_ome)
        //recebe o valor da distancia
        val distanciaantt = intent.getStringExtra("distanciaantt")
        val d_istanciaantt = distanciaantt?.toDouble()
        //faz o calculo da cubagem do material
        val u = binding.quantidadefra.text.toString()
        val und = u.toDouble()
        val c = binding.comprimentofra.text.toString()
        val comp = c.toDouble()
        val a = binding.alturafra.text.toString()
        val alt = a.toDouble()
        val l = binding.largurafra.text.toString()
        val lar = l.toDouble()
        val res = comp * alt * lar * und
        val rp2 = res
        val rp3 = String.format("%.2f", rp2)
       //faz o caluclo do peso cubico
        val pesocubico = res * FR
        val p_esocubico = String.format("%.0f", pesocubico)
       //faz o calulo do lastro -> pode usar para definir o numero de paletes ou espaço no caminhão
        val lastro = comp * lar
        val l_astro = String.format("%.2f", lastro)
       //pega o valor da transportadora
        val fretepago = binding.preco.text.toString()
        val f_retepago = fretepago.toDouble()
        val fr_etepago = DEC.format(f_retepago)
        //divide o valor da transportadora pelo cubico do material
        val porpesocubico = f_retepago?.div(pesocubico)
        val p_orpesocubico = String.format("%.2f" ,porpesocubico)
        //divide o valor pago pelo km rodado
        val porkmrodado = d_istanciaantt?.let { f_retepago?.div(it) }
        val p_orkmrodado = String.format("%.2f",porkmrodado)
        //divide serviço por cubagem
        val porcubagem = f_retepago?.div(rp2)
        val p_orcubagem = String.format("%.2f",porcubagem)


        binding.dadoscubagem.text = "------- Resumo do Complemento -------------------\n"+
                                    "Tabela ANTT : $n_o_me\n"+
                                    "Valor Transportadora : $fr_etepago\n"+
                                    "Cubagem : $rp3\n"+
                                    "Peso cubado : $p_esocubico\n"+
                                    "Valor por km :R$ $p_orkmrodado\n"+
                                    "Valor por kg Fisico :\n"+
                                    "Valor por kg Cubado : $p_orpesocubico\n"+
                                    "Valor por Metro Cubico : $p_orcubagem\n"+
                                    "Valor por Palete :\n"
    }
}