package br.com.vitor.duastelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class tela2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela2)

        // recebendo valores da tela MainActivity que veio com o putExtra
        val string: String? = intent.getStringExtra("Chave")

        val texto = findViewById(R.id.textView2) as TextView
        texto.setText(string)

        // Volta para a tela 1
        val btnVoltar = findViewById(R.id.btnVoltar) as Button
        btnVoltar.setOnClickListener {
            this.finish()
        }

        // Vai para a tela 3
        val btnNext = findViewById(R.id.btnGoTo3) as Button
        btnNext.setOnClickListener{
            val intent = Intent(this,Tela3::class.java) // Diz que tenho uma intenção de abrir uma nova tela, nesse caso a tela 2
            startActivity(intent)
        }
    }
}