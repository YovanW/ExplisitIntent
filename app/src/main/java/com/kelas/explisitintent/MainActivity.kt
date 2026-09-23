package com.kelas.explisitintent

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kelas.explisitintent.ui.theme.ExplisitIntentTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        var _btnExplisit1 = findViewById<Button>(R.id.btnExplisit1)
        val _dataKirim = findViewById<EditText>(R.id.dataKirim)
        val _btnExplisit2 = findViewById<Button>(R.id.btnExplisit2)
        val isiPegawai : ArrayList<Pegawai> = arrayListOf()
        val _btnExplisit3 = findViewById<Button>(R.id.btnImplisit3)
        val _btnExplisit4 = findViewById<Button>(R.id.btnExplisit4)

        _returnHasil = findViewById(R.id.returnHasil)

        isiPegawai.add(Pegawai(1,"Anita", "Test"))
        isiPegawai.add(Pegawai(2, "Tatik", "Marketing"))

        _btnExplisit1.setOnClickListener {
            val intent = Intent(
                this@MainActivity,
                MainActivity2::class.java)
            startActivity(intent)
        }

        _btnExplisit2.setOnClickListener {
            val intentWithData = Intent(
                this@MainActivity,
                MainActivity3::class.java
            ).apply {
                putExtra(MainActivity3.dataTerima, _dataKirim.text.toString())
            }
            startActivity(intentWithData)
        }

        _btnExplisit3.setOnClickListener {
            val intentWithObject = Intent(
                this@MainActivity,
                MainActivity4::class.java
            ).apply {
                putExtra(MainActivity4.dataPegawai, isiPegawai)
            }
            startActivity(intentWithObject)
        }

        _btnExplisit4.setOnClickListener {
            val intentWithResult = Intent(
                this@MainActivity,
                MainActivity5::class.java
            )
            resultLauncher.launch(
                intentWithResult
            )
        }

    }
    private lateinit var _returnHasil: TextView

    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK && result.data != null) {
            val selectedItem = result.data?.getStringExtra(
                MainActivity5.SelectedItem)
            _returnHasil.text = selectedItem
        }
    }
}