package com.ersafra.horaparada05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ersafra.horaparada05.databinding.ActivityTelaCalculoBinding
import com.ersafra.horaparada05.databinding.ActivityTelaResultadoBinding


private lateinit var binding: ActivityTelaResultadoBinding

class TelaResultado : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTelaResultadoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}