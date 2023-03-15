package br.com.vitor.duastelas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnGoToTela2 : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGoToTela2 = findViewById(R.id.btnGoToTela1);
        btnGoToTela2.setOnClickListener{
            val intent = Intent(this,tela2::class.java) // Diz que tenho uma intenção de abrir uma nova tela, nesse caso a tela 2
            intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
            intent.putExtra("Chave", "Ola tela 2") // Manda valores
            startActivity(intent)
        };
    }
}
