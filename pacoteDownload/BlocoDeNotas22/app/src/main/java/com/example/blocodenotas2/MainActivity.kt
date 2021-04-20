package com.example.blocodenotas2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.blocodenotas2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val preferencia = PreferenciaAnotacao(applicationContext) // recuperando o contexto da Preferencia anotacao.Kt
        val botaoSalvar = binding.fab

        botaoSalvar.setOnClickListener {

            val anotacaoRecuperado = binding.editContainer.editAnotacao.text.toString()

            if (anotacaoRecuperado == "") {  //estrutura de validação
                Toast.makeText(this, "Digite alguma coisa...", Toast.LENGTH_SHORT).show()
            }else{
                preferencia.SalvarAnotacao(anotacaoRecuperado)
                Toast.makeText(this, "Anotação foi salva com sucesso.", Toast.LENGTH_SHORT).show()


            }
        }

        val anotacao = preferencia.RecuperarAnotacao()
        if (anotacao != ""){
            binding.editContainer.editAnotacao.setText(anotacao)
        }
    }
}