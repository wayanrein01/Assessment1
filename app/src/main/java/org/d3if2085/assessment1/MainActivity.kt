package org.d3if2085.assessment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import org.d3if2085.assessment1.databinding.ActivityMainBinding
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var listRiwayat = ArrayList<Riwayat>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHitung.setOnClickListener { hitung() }
        with(binding.recyclerView) {
            adapter = MainAdapter(listRiwayat)
            setHasFixedSize(true)
        }
    }

    private fun hitung() {
        val angka1 = binding.angka1.text.toString()
        if (TextUtils.isEmpty(angka1)) {
            Toast.makeText(this, R.string.angka1_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val angka2 = binding.angka2.text.toString()
        if (TextUtils.isEmpty(angka2)) {
            Toast.makeText(this, R.string.angka2_invalid, Toast.LENGTH_LONG).show()
            return
        }
        val operator = binding.selectOperasi.selectedItem.toString()

        val hasil = when (operator) {
            "+" -> angka1.toDouble() + angka2.toDouble()
            "-" -> angka1.toDouble() - angka2.toDouble()
            "*" -> angka1.toDouble() * angka2.toDouble()
            "/" -> if (angka2.toDouble() == 0.0) 0.0 else angka1.toDouble() / angka2.toDouble()
            else -> 0
        }

        listRiwayat.add(Riwayat(angka1, angka2, operator, hasil.toString()))

        with(binding.recyclerView) {
            adapter = MainAdapter(listRiwayat)
            setHasFixedSize(true)
        }

        binding.tvHasil.text = getString(R.string.hasil, hasil.toDouble())
    }
}