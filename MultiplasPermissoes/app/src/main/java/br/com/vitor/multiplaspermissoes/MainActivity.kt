package br.com.vitor.multiplaspermissoes

import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import br.com.vitor.multiplaspermissoes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object{
        var PERMISSIONS = arrayOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.RECORD_AUDIO,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )
    }

    private lateinit var valores: Array<String>
    private fun hasPermision(context: Context, permissions: Array<String>):
            Boolean = permissions.all {
                ActivityCompat.checkSelfPermission(context, it) ==
                        PackageManager.PERMISSION_GRANTED
    }

    private fun hasPermision2(context: Context, permissions: Array<String>):
            Array<String> =
            permissions.filter {
                ActivityCompat.checkSelfPermission(context, it) ==
                    PackageManager.PERMISSION_DENIED
            }.toTypedArray()


    private val requestMultiplePermissions =
        registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions())
        {
            permissions ->
            permissions.entries.forEach {
                Log.d("PERMISSAO", "${it.key} = ${it.value}")
                binding.btnGravar.isEnabled = it.value
                if(!it.value){
                    Log.e("ERR perm", "${it.key} sem permissao")
                    return@forEach // cai fora do foreach
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)

        binding.btnPermissoes.setOnClickListener{
            binding.txtStatus.text = "Ola Alunos"
            var checkPermission: Boolean = hasPermision(this, PERMISSIONS)
            Log.d("TESTE HAS",checkPermission.toString())
            if(!checkPermission){
                var lista = hasPermision2(this, PERMISSIONS))
                requestMultiplePermissions.launch(lista)
            }
        }
    }
}