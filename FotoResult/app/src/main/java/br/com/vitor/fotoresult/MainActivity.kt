package br.com.vitor.fotoresult

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import br.com.vitor.fotoresult.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy{
        ActivityMainBinding.inflate((layoutInflater))
    }

    private val register = registerForActivityResult(
        ActivityResultContracts.TakePicturePreview()){
            image: Bitmap? ->
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // val binding = ActivityMainBinding.inflate(layoutInflater)


        //binding.button.setText("Click")
        binding.textView.text = "teste"
        binding.button.text = "click aqui"
        binding.button.setOnClickListener {
            register.launch(null)
        }



        setContentView(binding.root)

    }
}