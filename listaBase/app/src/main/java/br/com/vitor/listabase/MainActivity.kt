package br.com.vitor.listabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lista 1
        val arrayAdapter : ArrayAdapter<*>
        val usuarios = arrayOf("São Paulo", "Minas Gerais", "Rio de Janeiro", "Parana", "Espirito Santo", "Bahia")

        // Lista 2
        val arrayAdapter2 : ArrayAdapter<*>
        val animais = arrayOf("Cachorro", "Coelho", "Cavalo", "Peixe", "Periquito");

        // acessa a lista apartir de um arquivo xml
        var mListView = findViewById<ListView>(R.id.userlist);

        // acessa a lista 2 apartir de um arquivo xml
        var mListView2 = findViewById<ListView>(R.id.animalsList);

        //cria o adpater

        arrayAdapter = ArrayAdapter(this,
        android.R.layout.simple_list_item_1, usuarios)
        mListView.adapter = arrayAdapter

        //cria o adpater

        arrayAdapter2 = ArrayAdapter(this,
        android.R.layout.simple_list_item_1, animais)
        mListView2.adapter = arrayAdapter2

    }
}