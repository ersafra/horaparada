package com.ersafra.horaparada05

import android.content.Context
import android.content.Intent
import android.net.Uri

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.InputDevice
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService
import com.ersafra.horaparada05.databinding.ActivityTelaAnttBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_tela_antt.*
import java.text.DecimalFormat
import kotlin.Any as string


class TelaAntt : AppCompatActivity() {

    val DEC = DecimalFormat("R$ #,##0.00")
    var  recebe : String? = null
//-eixo 2-//
    val	GS02 =	3.0908
    val	GS2 =	252.7
    val	GL02 =	3.1308
    val	GL2 =	258.72
    val	FA02 =	3.7095
    val	FA2 =	291.86
    val	CO02 =	0.0
    val	CO2 =	0.0
    val	CG02 =	3.0839
    val	CG2 =	250.78
    val	NE02 =	2.6959
    val	NE2 =	250.78
    val	PGS02 =	3.7125
    val	PGS2 =	370.88
    val	PGL02 =	3.7729
    val	PGL2 =	387.49
    val	PFA02 =	4.1915
    val	PFA2 =	375.59
    val	PCO02 =	0.0
    val	PCO2 =	0.0
    val	PCG02 =	3.3677
    val	PCG2 =	326.06
    val	CGP02 =	0.0
    val	CGP2 =	0.0
//-eixo3-//
    val	GS03	 =	3.9886
    val	GS3	 =	300.69
    val	GL03	 =	4.0391
    val	GL3	 =	309.59
    val	FA03	 =	4.7567
    val	FA3	 =	340.73
    val	CO03	 =	3.9759
    val	CO3	 =	297.19
    val	CG03	 =	3.9759
    val	CG3	 =	297.19
    val	NE03	 =	3.9759
    val	NE3	 =	297.19
    val	PGS03	 =	4.6103
    val	PGS3	 =	418.87
    val	PGL03	 =	4.6811
    val	PGL3	 =	438.33
    val	PFA03	 =	5.2387
    val	PFA3	 =	424.46
    val	PCO03	 =	4.2597
    val	PCO3	 =	372.47
    val	PCG03	 =	4.2597
    val	PCG3	 =	372.47
    val	CGP03	 =	0.0
    val	CGP3	 =	0.0
//--4--//
    val	GS04 =	4.5346
    val	GS4 =	308.26
    val	GL04 =	4.5644
    val	GL4 =	306.52
    val	FA04 =	5.441
    val	FA4 =	360.3
    val	CO04 =	4.5282
    val	CO4 =	306.52
    val	CG04 =	4.5282
    val	CG4 =	306.52
    val	NE04 =	4.546
    val	NE4 =	311.4
    val	PGS04 =	5.1865
    val	PGS4 =	431.99
    val	PGL04 =	5.2187
    val	PGL4 =	440.84
    val	PFA04 =	5.9449
    val	PFA4 =	451.24
    val	PCO04 =	4.8423
    val	PCO4 =	387.35
    val	PCG04 =	4.8423
    val	PCG4 =	387.35
    val	CGP04 =  0.0
    val	CGP4 = 0.0
//--5--//
    val	GS05 =	5.2018
    val	GS5 =	341.28
    val	GL05 =	5.2868
    val	GL5 =	354.72
    val	FA05 =	6.3221
    val	FA5 =	423.32
    val	CO05 =	5.1999
    val	CO5 =	340.76
    val	CG05 =	5.1999
    val	CG5 =	340.76
    val	NE05 =	5.1999
    val	NE5 =	340.76
    val	PGS05 =	5.8538
    val	PGS5 =	465.00
    val	PGL05 =	5.9411
    val	PGL5 =	489.03
    val	PFA05 =	6.826
    val	PFA5 =	514.26
    val	PCO05 =	5.514
    val	PCO5 =	421.59
    val	PCG05 =	5.514
    val	PCG5 =	421.59
    val	CGP05 =	5.3696
    val	CGP5 =	387.41
    //--6--//
    val	GS06 =	5.949
    val	GS6 =	381.8
    val	GL06 =	6.034
    val	GL6 =	395.24
    val	FA06 =	7.1883
    val	FA6 =	463.84
    val	CO06 =	5.9471
    val	CO6 =	381.28
    val	CG06 =	5.9471
    val	CG6 =	381.28
    val	NE06 =	5.9471
    val	NE6 =	381.28
    val	PGS06 =	6.601
    val	PGS6 =	505.53
    val	PGL06 =	6.6883
    val	PGL6 =	529.55
    val	PFA06 =	7.6922
    val	PFA6 =	554.79
    val	PCO06 =	6.2612
    val	PCO6 =	462.11
    val	PCG06 =	6.2612
    val	PCG6 =	462.11
    val	CGP06 =	6.1167
    val	CGP6 =	427.93
    //--7--//
    val	GS07 =	6.4105
    val	GS7 =	442.25
    val	GL07 =	6.5362
    val	GL7 =	466.85
    val	FA07 =	7.645
    val	FA7 =	522.96
    val	CO07 =	6.4112
    val	CO7 =	442.42
    val	CG07 =	6.4112
    val	CG7 =	442.42
    val	NE07 =	6.4112
    val	NE7 =	442.42
    val	PGS07 =	7.0824
    val	PGS7 =	571.45
    val	PGL07 =	7.2104
    val	PGL7 =	606.64
    val	PFA07 =	8.1747
    val	PFA7 =	621.02
    val	PCO07 =	6.7452
    val	PCO7 =	528.72
    val	PCG07 =	6.7452
    val	PCG7 =	528.72
    val	CGP07 = 0.0
    val	CGP7 =  0.0
    //-9-//
    val	GS09 =	7.3765
    val	GS9 =	484.22
    val	GL09 =	7.5014
    val	GL9 =	508.64
    val	FA09 =	8.7747
    val	FA9 =	569.98
    val	CO09 =	7.3701
    val	CO9 =	482.47
    val	CG09 =	7.3701
    val	CG9 =	482.47
    val	NE09 =	7.3701
    val	NE9 =	482.47
    val	PGS09 =	8.0483
    val	PGS9 =	613.41
    val	PGL09 =	8.1756
    val	PGL9 =	648.43
    val	PFA09 =	9.3044
    val	PFA9 =	668.04
    val	PCO09 =	7.7041
    val	PCO9 =	568.77
    val	PCG09 =	7.7041
    val	PCG9 =	568.77
    val	CGP09 =	7.6212
    val	CGP9 =	551.52

    private lateinit var binding: ActivityTelaAnttBinding
    private var mAdViewTC: AdView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaAnttBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //fecha teclado
        neixos.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(ed: Editable){
            if (ed?.length == 1)
            closekeyboard()}
            override fun beforeTextChanged(p0: CharSequence,p1: Int,p2:Int,p3:Int){
            }
            override fun onTextChanged(p0: CharSequence,p1: Int,p2:Int,p3:Int){
            }
        })
        //

        //--admod--//
        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        binding.banAntt.loadAd(adRequest)
        //--admob--//
        val rootView = findViewById<View>(android.R.id.content)
        val textInputLayouts = Utils.findViewsWithType(
            rootView, TextInputLayout::class.java)
        binding.btnantt.setOnClickListener{
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
                eixo2()
            }
        }



/*//-spinner-//
        val tipocar = resources.getStringArray(R.array.spinner)
        val spinner = findViewById<Spinner>(R.id.mySpinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, tipocar)
            spinner.adapter = adapter
            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>,
                    view: View, position: Int, id: Long
                ) {
                    recebe = (tipocar[position].also { binding.txtantt2.text = it })
                    /*Toast.makeText(this@TelaAntt,
                        getString(R.string.selected_item) + " " +
                                "" + tipocar[position], Toast.LENGTH_SHORT).show()*/
                }
                override fun onNothingSelected(parent: AdapterView<*>) {
                }
            }
        }
//-spinner-//

 */
        /*binding.btnantt.setOnClickListener {

                eixo2()
            }*/
        }

 private fun closekeyboard(){
     val view:View? = currentFocus
     view?.let{
         val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
         imm.hideSoftInputFromWindow(it.windowToken,0)
     }
 }

    private fun nTw(view: View) {
    try {
        val url =//thiago de campinas
            "https://wa.me//5519982250900?text=Olá,%20Estou%20usando%20o%20aplicativo%20©Hora%20Parada%20e%20estou%20precisando%20de%20seu%20auxilio%20para%20receber%20diarias%20referente%20a%20lei%2013.103/2015."
        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)).setPackage("com.whatsapp"))
    } catch (e: Exception) {/*todo*/
    }
}

fun eixo2(){
    //--pegao eixo--//
    val ei = binding.neixos.text.toString()
    var eixos: string = ei.toInt()
   //--fim do eixo--//--pega a distancia
    val distancia = binding.distancia.text.toString()
    val dis = distancia.toDouble()
   //--fim da distancia--

    // GRANEL SOLIDO
    val TAGS: Double = (GS02 * dis)
    val MGS02 = DEC.format(TAGS)
    val GS1: Double = GS2
    val CCGS = DEC.format(GS1)
    val SGS02 = (TAGS+GS1)
    val TGS02 = DEC.format(SGS02)
    //-GRANEL LIQUIDO--//
    val TAGL: Double = (GL02 * dis)
    val MGL02 = DEC.format(TAGL)
    val GL1: Double = GL2
    val CCGL = DEC.format(GL1)
    val SGL02 = (TAGL+GL1)
    val TGL02 = DEC.format(SGL02)
    //--FRIGORIFICA--//
    val TAFA: Double = (FA02 * dis)
    val MFA02 = DEC.format(TAFA)
    val FA1: Double = FA2
    val CCFA = DEC.format(FA1)
    val SFA02 = (TAFA+FA1)
    val TFA02 = DEC.format(SFA02)
    //container
    val TACO: Double = (CO02 * dis)
    val MCO02 = DEC.format(TACO)
    val CO1: Double = CO2
    val CCCO = DEC.format(CO1)
    val SCO02 = (TACO+CO1)
    val TCO02 = DEC.format(SCO02)
    //carga geral
    val TACG: Double = (CG02 * dis)
    val MCG02 = DEC.format(TACG)
    val CG1: Double = CG2
    val CCCG = DEC.format(CG1)
    val SCG02 = (TACG+CG1)
    val TCG02 = DEC.format(SCG02)
    //neogranel
    val TANE: Double = (NE02 * dis)
    val MNE02 = DEC.format(TANE)
    val NE1: Double = NE2
    val CCNE = DEC.format(NE1)
    val SNE02 = (TANE+NE1)
    val TNE02 = DEC.format(SNE02)
    //perigosa solida
    val TAPGS: Double = (PGS02 * dis)
    val MPGS02 = DEC.format(TAPGS)
    val PGS1: Double = PGS2
    val CCPGS = DEC.format(PGS1)
    val SPGS02 = (TAPGS+PGS1)
    val TPGS02 = DEC.format(SPGS02)
    //perigosa liquida
    val TAPGL: Double = (PGL02 * dis)
    val MPGL02 = DEC.format(TAPGL)
    val PGL1: Double = PGL2
    val CCPGL = DEC.format(PGL1)
    val SPGL02 = (TAPGL+PGL1)
    val TPGL02 = DEC.format(SPGL02)
    //perigosa fria
    val TAPFA: Double = (PFA02 * dis)
    val MPFA02 = DEC.format(TAPFA)
    val PFA1: Double = PFA2
    val CCPFA = DEC.format(PFA1)
    val SPFA02 = (TAPFA+PFA1)
    val TPFA02 = DEC.format(SPFA02)
    //perigosa conteiner
    val TAPCO: Double = (PCO02 * dis)
    val MPCO02 = DEC.format(TAPCO)
    val PCO1: Double = PCO2
    val CCPCO = DEC.format(PCO1)
    val SPCO02 = (TAPCO+PCO1)
    val TPCO02 = DEC.format(SPCO02)
    //perigosa geral
    val TAPCG: Double = (PCG02 * dis)
    val MPCG02 = DEC.format(TAPCG)
    val PCG1: Double = PCG2
    val CCPCG = DEC.format(PCG1)
    val SPCG02 = (TAPCG+PCG1)
    val TPCG02 = DEC.format(SPCG02)
    //pressurizada
    val TACGP: Double = (CGP02 * dis)
    val MCGP02 = DEC.format(TACGP)
    val CGP1: Double = CGP2
    val CCCGP = DEC.format(CGP1)
    val SCGP02 = (TACGP+CGP1)
    val TCGP02 = DEC.format(SCGP02)
    //--fim--//
//--3 EIXOS--//
// GRANEL SOLIDO
    val TAGS3: Double = (GS03 * dis)
    val MGS03 = DEC.format(TAGS3)
    val GS13: Double = GS3
    val CCGS3 = DEC.format(GS13)
    val SGS03 = (TAGS3+GS13)
    val TGS03 = DEC.format(SGS03)
    //-GRANEL LIQUIDO--//
    val TAGL3: Double = (GL03 * dis)
    val MGL03 = DEC.format(TAGL3)
    val GL13: Double = GL3
    val CCGL3 = DEC.format(GL13)
    val SGL03 = (TAGL3+GL13)
    val TGL03 = DEC.format(SGL03)
    //--FRIGORIFICA--//
    val TAFA3: Double = (FA03 * dis)
    val MFA03 = DEC.format(TAFA3)
    val FA13: Double = FA3
    val CCFA3 = DEC.format(FA13)
    val SFA03 = (TAFA3+FA13)
    val TFA03 = DEC.format(SFA03)
    //container
    val TACO3: Double = (CO03 * dis)
    val MCO03 = DEC.format(TACO3)
    val CO13: Double = CO3
    val CCCO3 = DEC.format(CO13)
    val SCO03 = (TACO3+CO13)
    val TCO03 = DEC.format(SCO03)
    //carga geral
    val TACG3: Double = (CG03 * dis)
    val MCG03 = DEC.format(TACG3)
    val CG13: Double = CG3
    val CCCG3 = DEC.format(CG13)
    val SCG03 = (TACG3+CG13)
    val TCG03 = DEC.format(SCG03)
    //neogranel
    val TANE3: Double = (NE03 * dis)
    val MNE03 = DEC.format(TANE3)
    val NE13: Double = NE3
    val CCNE3 = DEC.format(NE13)
    val SNE03 = (TANE3+NE13)
    val TNE03 = DEC.format(SNE03)
    //perigosa solida
    val TAPGS3: Double = (PGS03 * dis)
    val MPGS03 = DEC.format(TAPGS3)
    val PGS13: Double = PGS3
    val CCPGS3 = DEC.format(PGS13)
    val SPGS03 = (TAPGS3+PGS13)
    val TPGS03 = DEC.format(SPGS03)
    //perigosa liquida
    val TAPGL3: Double = (PGL03 * dis)
    val MPGL03 = DEC.format(TAPGL3)
    val PGL13: Double = PGL3
    val CCPGL3 = DEC.format(PGL13)
    val SPGL03 = (TAPGL3+PGL13)
    val TPGL03 = DEC.format(SPGL03)
    //perigosa fria
    val TAPFA3: Double = (PFA03 * dis)
    val MPFA03 = DEC.format(TAPFA3)
    val PFA13: Double = PFA3
    val CCPFA3 = DEC.format(PFA13)
    val SPFA03 = (TAPFA3+PFA13)
    val TPFA03 = DEC.format(SPFA03)
    //perigosa conteiner
    val TAPCO3: Double = (PCO03 * dis)
    val MPCO03 = DEC.format(TAPCO3)
    val PCO13: Double = PCO3
    val CCPCO3 = DEC.format(PCO13)
    val SPCO03 = (TAPCO3+PCO13)
    val TPCO03 = DEC.format(SPCO03)
    //perigosa geral
    val TAPCG3: Double = (PCG03 * dis)
    val MPCG03 = DEC.format(TAPCG3)
    val PCG13: Double = PCG3
    val CCPCG3 = DEC.format(PCG13)
    val SPCG03 = (TAPCG3+PCG13)
    val TPCG03 = DEC.format(SPCG03)
    //pressurizada
    val TACGP3: Double = (CGP03 * dis)
    val MCGP03 = DEC.format(TACGP3)
    val CGP13: Double = CGP3
    val CCCGP3 = DEC.format(CGP13)
    val SCGP03 = (TACGP3+CGP13)
    val TCGP03 = DEC.format(SCGP03)
    //--4 EIXOS--//
// GRANEL SOLIDO
    val TAGS4: Double = (GS04 * dis)
    val MGS04 = DEC.format(TAGS4)
    val GS14: Double = GS4
    val CCGS4 = DEC.format(GS14)
    val SGS04 = (TAGS4+GS14)
    val TGS04 = DEC.format(SGS04)
    //-GRANEL LIQUIDO--//
    val TAGL4: Double = (GL04 * dis)
    val MGL04 = DEC.format(TAGL4)
    val GL14: Double = GL4
    val CCGL4 = DEC.format(GL14)
    val SGL04 = (TAGL4+GL14)
    val TGL04 = DEC.format(SGL04)
    //--FRIGORIFICA--//
    val TAFA4: Double = (FA04 * dis)
    val MFA04 = DEC.format(TAFA4)
    val FA14: Double = FA4
    val CCFA4 = DEC.format(FA14)
    val SFA04 = (TAFA4+FA14)
    val TFA04 = DEC.format(SFA04)
    //container
    val TACO4: Double = (CO04 * dis)
    val MCO04 = DEC.format(TACO4)
    val CO14: Double = CO4
    val CCCO4 = DEC.format(CO14)
    val SCO04 = (TACO4+CO14)
    val TCO04 = DEC.format(SCO04)
    //carga geral
    val TACG4: Double = (CG04 * dis)
    val MCG04 = DEC.format(TACG4)
    val CG14: Double = CG4
    val CCCG4 = DEC.format(CG14)
    val SCG04 = (TACG4+CG14)
    val TCG04 = DEC.format(SCG04)
    //neogranel
    val TANE4: Double = (NE04 * dis)
    val MNE04 = DEC.format(TANE4)
    val NE14: Double = NE4
    val CCNE4 = DEC.format(NE14)
    val SNE04 = (TANE4+NE14)
    val TNE04 = DEC.format(SNE04)
    //perigosa solida
    val TAPGS4: Double = (PGS04 * dis)
    val MPGS04 = DEC.format(TAPGS4)
    val PGS14: Double = PGS4
    val CCPGS4 = DEC.format(PGS14)
    val SPGS04 = (TAPGS4+PGS14)
    val TPGS04 = DEC.format(SPGS04)
    //perigosa liquida
    val TAPGL4: Double = (PGL04 * dis)
    val MPGL04 = DEC.format(TAPGL4)
    val PGL14: Double = PGL4
    val CCPGL4 = DEC.format(PGL14)
    val SPGL04 = (TAPGL4+PGL14)
    val TPGL04 = DEC.format(SPGL04)
    //perigosa fria
    val TAPFA4: Double = (PFA04 * dis)
    val MPFA04 = DEC.format(TAPFA4)
    val PFA14: Double = PFA4
    val CCPFA4 = DEC.format(PFA14)
    val SPFA04 = (TAPFA4+PFA14)
    val TPFA04 = DEC.format(SPFA04)
    //perigosa conteiner
    val TAPCO4: Double = (PCO04 * dis)
    val MPCO04 = DEC.format(TAPCO4)
    val PCO14: Double = PCO4
    val CCPCO4 = DEC.format(PCO14)
    val SPCO04 = (TAPCO4+PCO14)
    val TPCO04 = DEC.format(SPCO04)
    //perigosa geral
    val TAPCG4: Double = (PCG04 * dis)
    val MPCG04 = DEC.format(TAPCG4)
    val PCG14: Double = PCG4
    val CCPCG4 = DEC.format(PCG14)
    val SPCG04 = (TAPCG4+PCG14)
    val TPCG04 = DEC.format(SPCG04)
    //pressurizada
    val TACGP4: Double = (CGP04 * dis)
    val MCGP04 = DEC.format(TACGP4)
    val CGP14: Double = CGP4
    val CCCGP4 = DEC.format(CGP14)
    val SCGP04 = (TACGP4+CGP14)
    val TCGP04 = DEC.format(SCGP04)
    //--5 EIXOS--//
// GRANEL SOLIDO
    val TAGS5: Double = (GS05 * dis)
    val MGS05 = DEC.format(TAGS5)
    val GS15: Double = GS5
    val CCGS5 = DEC.format(GS15)
    val SGS05 = (TAGS5+GS15)
    val TGS05 = DEC.format(SGS05)
    //-GRANEL LIQUIDO--//
    val TAGL5: Double = (GL05 * dis)
    val MGL05 = DEC.format(TAGL5)
    val GL15: Double = GL5
    val CCGL5 = DEC.format(GL15)
    val SGL05 = (TAGL5+GL15)
    val TGL05 = DEC.format(SGL05)
    //--FRIGORIFICA--//
    val TAFA5: Double = (FA05 * dis)
    val MFA05 = DEC.format(TAFA5)
    val FA15: Double = FA5
    val CCFA5 = DEC.format(FA15)
    val SFA05 = (TAFA5+FA15)
    val TFA05 = DEC.format(SFA05)
    //container
    val TACO5: Double = (CO05 * dis)
    val MCO05 = DEC.format(TACO5)
    val CO15: Double = CO5
    val CCCO5 = DEC.format(CO15)
    val SCO05 = (TACO5+CO15)
    val TCO05 = DEC.format(SCO05)
    //carga geral
    val TACG5: Double = (CG05 * dis)
    val MCG05 = DEC.format(TACG5)
    val CG15: Double = CG5
    val CCCG5 = DEC.format(CG15)
    val SCG05 = (TACG5+CG15)
    val TCG05 = DEC.format(SCG05)
    //neogranel
    val TANE5: Double = (NE05 * dis)
    val MNE05 = DEC.format(TANE5)
    val NE15: Double = NE5
    val CCNE5 = DEC.format(NE15)
    val SNE05 = (TANE5+NE15)
    val TNE05 = DEC.format(SNE05)
    //perigosa solida
    val TAPGS5: Double = (PGS05 * dis)
    val MPGS05 = DEC.format(TAPGS5)
    val PGS15: Double = PGS5
    val CCPGS5 = DEC.format(PGS15)
    val SPGS05 = (TAPGS5+PGS15)
    val TPGS05 = DEC.format(SPGS05)
    //perigosa liquida
    val TAPGL5: Double = (PGL05 * dis)
    val MPGL05 = DEC.format(TAPGL5)
    val PGL15: Double = PGL5
    val CCPGL5 = DEC.format(PGL15)
    val SPGL05 = (TAPGL5+PGL15)
    val TPGL05 = DEC.format(SPGL05)
    //perigosa fria
    val TAPFA5: Double = (PFA05 * dis)
    val MPFA05 = DEC.format(TAPFA5)
    val PFA15: Double = PFA5
    val CCPFA5 = DEC.format(PFA15)
    val SPFA05 = (TAPFA5+PFA15)
    val TPFA05 = DEC.format(SPFA05)
    //perigosa conteiner
    val TAPCO5: Double = (PCO05 * dis)
    val MPCO05 = DEC.format(TAPCO5)
    val PCO15: Double = PCO5
    val CCPCO5 = DEC.format(PCO15)
    val SPCO05 = (TAPCO5+PCO15)
    val TPCO05 = DEC.format(SPCO05)
    //perigosa geral
    val TAPCG5: Double = (PCG05 * dis)
    val MPCG05 = DEC.format(TAPCG5)
    val PCG15: Double = PCG5
    val CCPCG5 = DEC.format(PCG15)
    val SPCG05 = (TAPCG5+PCG15)
    val TPCG05 = DEC.format(SPCG05)
    //pressurizada
    val TACGP5: Double = (CGP05 * dis)
    val MCGP05 = DEC.format(TACGP5)
    val CGP15: Double = CGP5
    val CCCGP5 = DEC.format(CGP15)
    val SCGP05 = (TACGP5+CGP15)
    val TCGP05 = DEC.format(SCGP05)
    //--6 EIXOS--//
// GRANEL SOLIDO
    val TAGS6: Double = (GS06 * dis)
    val MGS06 = DEC.format(TAGS6)
    val GS16: Double = GS6
    val CCGS6 = DEC.format(GS16)
    val SGS06 = (TAGS6+GS16)
    val TGS06 = DEC.format(SGS06)
    //-GRANEL LIQUIDO--//
    val TAGL6: Double = (GL06 * dis)
    val MGL06 = DEC.format(TAGL6)
    val GL16: Double = GL6
    val CCGL6 = DEC.format(GL16)
    val SGL06 = (TAGL6+GL16)
    val TGL06 = DEC.format(SGL06)
    //--FRIGORIFICA--//
    val TAFA6: Double = (FA06 * dis)
    val MFA06 = DEC.format(TAFA6)
    val FA16: Double = FA6
    val CCFA6 = DEC.format(FA16)
    val SFA06 = (TAFA6+FA16)
    val TFA06 = DEC.format(SFA06)
    //container
    val TACO6: Double = (CO06 * dis)
    val MCO06 = DEC.format(TACO6)
    val CO16: Double = CO6
    val CCCO6 = DEC.format(CO16)
    val SCO06 = (TACO6+CO16)
    val TCO06 = DEC.format(SCO06)
    //carga geral
    val TACG6: Double = (CG06 * dis)
    val MCG06 = DEC.format(TACG6)
    val CG16: Double = CG6
    val CCCG6 = DEC.format(CG16)
    val SCG06 = (TACG6+CG16)
    val TCG06 = DEC.format(SCG06)
    //neogranel
    val TANE6: Double = (NE06 * dis)
    val MNE06 = DEC.format(TANE6)
    val NE16: Double = NE6
    val CCNE6 = DEC.format(NE16)
    val SNE06 = (TANE6+NE16)
    val TNE06 = DEC.format(SNE06)
    //perigosa solida
    val TAPGS6: Double = (PGS06 * dis)
    val MPGS06 = DEC.format(TAPGS6)
    val PGS16: Double = PGS6
    val CCPGS6 = DEC.format(PGS16)
    val SPGS06 = (TAPGS6+PGS16)
    val TPGS06 = DEC.format(SPGS06)
    //perigosa liquida
    val TAPGL6: Double = (PGL06 * dis)
    val MPGL06 = DEC.format(TAPGL6)
    val PGL16: Double = PGL6
    val CCPGL6 = DEC.format(PGL16)
    val SPGL06 = (TAPGL6+PGL16)
    val TPGL06 = DEC.format(SPGL06)
    //perigosa fria
    val TAPFA6: Double = (PFA06 * dis)
    val MPFA06 = DEC.format(TAPFA6)
    val PFA16: Double = PFA6
    val CCPFA6 = DEC.format(PFA16)
    val SPFA06 = (TAPFA6+PFA16)
    val TPFA06 = DEC.format(SPFA06)
    //perigosa conteiner
    val TAPCO6: Double = (PCO06 * dis)
    val MPCO06 = DEC.format(TAPCO6)
    val PCO16: Double = PCO6
    val CCPCO6 = DEC.format(PCO16)
    val SPCO06 = (TAPCO6+PCO16)
    val TPCO06 = DEC.format(SPCO06)
    //perigosa geral
    val TAPCG6: Double = (PCG06 * dis)
    val MPCG06 = DEC.format(TAPCG6)
    val PCG16: Double = PCG6
    val CCPCG6 = DEC.format(PCG16)
    val SPCG06 = (TAPCG6+PCG16)
    val TPCG06 = DEC.format(SPCG06)
    //pressurizada
    val TACGP6: Double = (CGP06 * dis)
    val MCGP06 = DEC.format(TACGP6)
    val CGP16: Double = CGP6
    val CCCGP6 = DEC.format(CGP16)
    val SCGP06 = (TACGP6+CGP16)
    val TCGP06 = DEC.format(SCGP06)
//--7 EIXOS--//
// GRANEL SOLIDO
    val TAGS7: Double = (GS07 * dis)
    val MGS07 = DEC.format(TAGS7)
    val GS17: Double = GS7
    val CCGS7 = DEC.format(GS17)
    val SGS07 = (TAGS7+GS17)
    val TGS07 = DEC.format(SGS07)
    //-GRANEL LIQUIDO--//
    val TAGL7: Double = (GL07 * dis)
    val MGL07 = DEC.format(TAGL7)
    val GL17: Double = GL7
    val CCGL7 = DEC.format(GL17)
    val SGL07 = (TAGL7+GL17)
    val TGL07 = DEC.format(SGL07)
    //--FRIGORIFICA--//
    val TAFA7: Double = (FA07 * dis)
    val MFA07 = DEC.format(TAFA7)
    val FA17: Double = FA7
    val CCFA7 = DEC.format(FA17)
    val SFA07 = (TAFA7+FA17)
    val TFA07 = DEC.format(SFA07)
    //container
    val TACO7: Double = (CO07 * dis)
    val MCO07 = DEC.format(TACO7)
    val CO17: Double = CO7
    val CCCO7 = DEC.format(CO17)
    val SCO07 = (TACO7+CO17)
    val TCO07 = DEC.format(SCO07)
    //carga geral
    val TACG7: Double = (CG07 * dis)
    val MCG07 = DEC.format(TACG7)
    val CG17: Double = CG7
    val CCCG7 = DEC.format(CG17)
    val SCG07 = (TACG7+CG17)
    val TCG07 = DEC.format(SCG07)
    //neogranel
    val TANE7: Double = (NE07 * dis)
    val MNE07 = DEC.format(TANE7)
    val NE17: Double = NE7
    val CCNE7 = DEC.format(NE17)
    val SNE07 = (TANE7+NE17)
    val TNE07 = DEC.format(SNE07)
    //perigosa solida
    val TAPGS7: Double = (PGS07 * dis)
    val MPGS07 = DEC.format(TAPGS7)
    val PGS17: Double = PGS7
    val CCPGS7 = DEC.format(PGS17)
    val SPGS07 = (TAPGS7+PGS17)
    val TPGS07 = DEC.format(SPGS07)
    //perigosa liquida
    val TAPGL7: Double = (PGL07 * dis)
    val MPGL07 = DEC.format(TAPGL7)
    val PGL17: Double = PGL7
    val CCPGL7 = DEC.format(PGL17)
    val SPGL07 = (TAPGL7+PGL17)
    val TPGL07 = DEC.format(SPGL07)
    //perigosa fria
    val TAPFA7: Double = (PFA07 * dis)
    val MPFA07 = DEC.format(TAPFA7)
    val PFA17: Double = PFA7
    val CCPFA7 = DEC.format(PFA17)
    val SPFA07 = (TAPFA7+PFA17)
    val TPFA07 = DEC.format(SPFA07)
    //perigosa conteiner
    val TAPCO7: Double = (PCO07 * dis)
    val MPCO07 = DEC.format(TAPCO7)
    val PCO17: Double = PCO7
    val CCPCO7 = DEC.format(PCO17)
    val SPCO07 = (TAPCO7+PCO17)
    val TPCO07 = DEC.format(SPCO07)
    //perigosa geral
    val TAPCG7: Double = (PCG07 * dis)
    val MPCG07 = DEC.format(TAPCG7)
    val PCG17: Double = PCG7
    val CCPCG7 = DEC.format(PCG17)
    val SPCG07 = (TAPCG7+PCG17)
    val TPCG07 = DEC.format(SPCG07)
    //pressurizada
    val TACGP7: Double = (CGP07 * dis)
    val MCGP07 = DEC.format(TACGP7)
    val CGP17: Double = CGP7
    val CCCGP7 = DEC.format(CGP17)
    val SCGP07 = (TACGP7+CGP17)
    val TCGP07 = DEC.format(SCGP07)
//--9 EIXOS--//
// GRANEL SOLIDO
    val TAGS9: Double = (GS09 * dis)
    val MGS09 = DEC.format(TAGS9)
    val GS19: Double = GS9
    val CCGS9 = DEC.format(GS19)
    val SGS09 = (TAGS9+GS19)
    val TGS09 = DEC.format(SGS09)
    //-GRANEL LIQUIDO--//
    val TAGL9: Double = (GL09 * dis)
    val MGL09 = DEC.format(TAGL9)
    val GL19: Double = GL9
    val CCGL9 = DEC.format(GL19)
    val SGL09 = (TAGL9+GL19)
    val TGL09 = DEC.format(SGL09)
    //--FRIGORIFICA--//
    val TAFA9: Double = (FA09 * dis)
    val MFA09 = DEC.format(TAFA9)
    val FA19: Double = FA9
    val CCFA9 = DEC.format(FA19)
    val SFA09 = (TAFA9+FA19)
    val TFA09 = DEC.format(SFA09)
    //container
    val TACO9: Double = (CO09 * dis)
    val MCO09 = DEC.format(TACO9)
    val CO19: Double = CO9
    val CCCO9 = DEC.format(CO19)
    val SCO09 = (TACO9+CO19)
    val TCO09 = DEC.format(SCO09)
    //carga geral
    val TACG9: Double = (CG09 * dis)
    val MCG09 = DEC.format(TACG9)
    val CG19: Double = CG9
    val CCCG9 = DEC.format(CG19)
    val SCG09 = (TACG9+CG19)
    val TCG09 = DEC.format(SCG09)
    //neogranel
    val TANE9: Double = (NE09 * dis)
    val MNE09 = DEC.format(TANE9)
    val NE19: Double = NE9
    val CCNE9 = DEC.format(NE19)
    val SNE09 = (TANE9+NE19)
    val TNE09 = DEC.format(SNE09)
    //perigosa solida
    val TAPGS9: Double = (PGS09 * dis)
    val MPGS09 = DEC.format(TAPGS9)
    val PGS19: Double = PGS9
    val CCPGS9 = DEC.format(PGS19)
    val SPGS09 = (TAPGS9+PGS19)
    val TPGS09 = DEC.format(SPGS09)
    //perigosa liquida
    val TAPGL9: Double = (PGL09 * dis)
    val MPGL09 = DEC.format(TAPGL9)
    val PGL19: Double = PGL9
    val CCPGL9 = DEC.format(PGL19)
    val SPGL09 = (TAPGL9+PGL19)
    val TPGL09 = DEC.format(SPGL09)
    //perigosa fria
    val TAPFA9: Double = (PFA09 * dis)
    val MPFA09 = DEC.format(TAPFA9)
    val PFA19: Double = PFA9
    val CCPFA9 = DEC.format(PFA19)
    val SPFA09 = (TAPFA9+PFA19)
    val TPFA09 = DEC.format(SPFA09)
    //perigosa conteiner
    val TAPCO9: Double = (PCO09 * dis)
    val MPCO09 = DEC.format(TAPCO9)
    val PCO19: Double = PCO9
    val CCPCO9 = DEC.format(PCO19)
    val SPCO09 = (TAPCO9+PCO19)
    val TPCO09 = DEC.format(SPCO09)
    //perigosa geral
    val TAPCG9: Double = (PCG09 * dis)
    val MPCG09 = DEC.format(TAPCG9)
    val PCG19: Double = PCG9
    val CCPCG9 = DEC.format(PCG19)
    val SPCG09 = (TAPCG9+PCG19)
    val TPCG09 = DEC.format(SPCG09)
    //pressurizada
    val TACGP9: Double = (CGP09 * dis)
    val MCGP09 = DEC.format(TACGP9)
    val CGP19: Double = CGP9
    val CCCGP9 = DEC.format(CGP19)
    val SCGP09 = (TACGP9+CGP19)
    val TCGP09 = DEC.format(SCGP09)
    //--fim--//
  when (eixos) {
      2 -> binding.txtantt.text =
          "Granel sólido  = $TGS02\n" +
                  "Ganel Líquido  = $TGL02\n" +
                  "Frigorificada ou Aquecida = $TFA02\n" +
                  "Conteinerizada = $TCO02\n" +
                  "Carga Geral = $TCG02\n" +
                  "Neogranel = $TNE02\n" +
                  "Perigosa (Granel Sólida) = $TPGS02\n" +
                  "Perigosa (Granel Líquido) = $TPGL02\n" +
                  "Perigosa (Frigorifica) = $TPFA02\n" +
                  "Perigosa (Conteinerizada) = $TPCO02\n" +
                  "Perigosa (Carga Geral) = $TPCG02\n" +
                  "Carga Granel Pressurizada = $TCGP02\n"
      3 -> binding.txtantt.text =
          "Granel sólido  = $TGS03\n" +
                  "Ganel Líquido  = $TGL03\n" +
                  "Frigorificada ou Aquecida = $TFA03\n" +
                  "Conteinerizada = $TCO03\n" +
                  "Carga Geral = $TCG03\n" +
                  "Neogranel = $TNE03\n" +
                  "Perigosa (Granel Sólida) = $TPGS03\n" +
                  "Perigosa (Granel Líquido) = $TPGL03\n" +
                  "Perigosa (Frigorifica) = $TPFA03\n" +
                  "Perigosa (Conteinerizada) = $TPCO03\n" +
                  "Perigosa (Carga Geral) = $TPCG03\n" +
                  "Carga Granel Pressurizada = $TCGP03\n"
      4 -> binding.txtantt.text =
          "Granel sólido  = $TGS04\n" +
                  "Ganel Líquido  = $TGL04\n" +
                  "Frigorificada ou Aquecida = $TFA04\n" +
                  "Conteinerizada = $TCO04\n" +
                  "Carga Geral = $TCG04\n" +
                  "Neogranel = $TNE04\n" +
                  "Perigosa (Granel Sólida) = $TPGS04\n" +
                  "Perigosa (Granel Líquido) = $TPGL04\n" +
                  "Perigosa (Frigorifica) = $TPFA04\n" +
                  "Perigosa (Conteinerizada) = $TPCO04\n" +
                  "Perigosa (Carga Geral) = $TPCG04\n" +
                  "Carga Granel Pressurizada = $TCGP04\n"
      5 -> binding.txtantt.text =
          "Granel sólido  = $TGS05\n" +
                  "Ganel Líquido  = $TGL05\n" +
                  "Frigorificada ou Aquecida = $TFA05\n" +
                  "Conteinerizada = $TCO05\n" +
                  "Carga Geral = $TCG05\n" +
                  "Neogranel = $TNE05\n" +
                  "Perigosa (Granel Sólida) = $TPGS05\n" +
                  "Perigosa (Granel Líquido) = $TPGL05\n" +
                  "Perigosa (Frigorifica) = $TPFA05\n" +
                  "Perigosa (Conteinerizada) = $TPCO05\n" +
                  "Perigosa (Carga Geral) = $TPCG05\n" +
                  "Carga Granel Pressurizada = $TCGP05\n"
      6 -> binding.txtantt.text =
          "Granel sólido  = $TGS06\n" +
                  "Ganel Líquido  = $TGL06\n" +
                  "Frigorificada ou Aquecida = $TFA06\n" +
                  "Conteinerizada = $TCO06\n" +
                  "Carga Geral = $TCG06\n" +
                  "Neogranel = $TNE06\n" +
                  "Perigosa (Granel Sólida) = $TPGS06\n" +
                  "Perigosa (Granel Líquido) = $TPGL06\n" +
                  "Perigosa (Frigorifica) = $TPFA06\n" +
                  "Perigosa (Conteinerizada) = $TPCO06\n" +
                  "Perigosa (Carga Geral) = $TPCG06\n" +
                  "Carga Granel Pressurizada = $TCGP06\n"
      7 -> binding.txtantt.text =
          "Granel sólido  = $TGS07\n" +
                  "Ganel Líquido  = $TGL07\n" +
                  "Frigorificada ou Aquecida = $TFA07\n" +
                  "Conteinerizada = $TCO07\n" +
                  "Carga Geral = $TCG07\n" +
                  "Neogranel = $TNE07\n" +
                  "Perigosa (Granel Sólida) = $TPGS07\n" +
                  "Perigosa (Granel Líquido) = $TPGL07\n" +
                  "Perigosa (Frigorifica) = $TPFA07\n" +
                  "Perigosa (Conteinerizada) = $TPCO07\n" +
                  "Perigosa (Carga Geral) = $TPCG07\n" +
                  "Carga Granel Pressurizada = $TCGP07\n"
      9 -> binding.txtantt.text =
          "Granel sólido  = $TGS09\n" +
                  "Ganel Líquido  = $TGL09\n" +
                  "Frigorificada ou Aquecida = $TFA09\n" +
                  "Conteinerizada = $TCO09\n" +
                  "Carga Geral = $TCG09\n" +
                  "Neogranel = $TNE09\n" +
                  "Perigosa (Granel Sólida) = $TPGS09\n" +
                  "Perigosa (Granel Líquido) = $TPGL09\n" +
                  "Perigosa (Frigorifica) = $TPFA09\n" +
                  "Perigosa (Conteinerizada) = $TPCO09\n" +
                  "Perigosa (Carga Geral) = $TPCG09\n" +
                  "Carga Granel Pressurizada = $TCGP09\n"
      1,8,10 -> binding.txtantt.text = "Não contemplado pela tabela"
 }
}
}//fim da classe
