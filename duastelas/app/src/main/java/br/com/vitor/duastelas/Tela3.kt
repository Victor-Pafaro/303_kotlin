package br.com.vitor.duastelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Tela3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela3)

        val btnVoltarTela2 = findViewById(R.id.btnVoltar3) as Button
        btnVoltarTela2.setOnClickListener {
            this.finish()
        }

        val btnVoltaTela1 = findViewById(R.id.btnBack1) as Button
        btnVoltaTela1.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java) // Diz que tenho uma intenção de abrir uma nova tela, nesse caso a tela 2
            startActivity(intent)
        }
    }
}