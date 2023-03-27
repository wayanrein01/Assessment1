package org.d3if2085.assessment1

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.d3if2085.assessment1.databinding.ListItemBinding

class MainAdapter(private val data: List<Riwayat>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(
        private val binding: ListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(riwayat: Riwayat) = with(binding) {
            tv2Angka1.text = riwayat.angka1
            tv2Angka2.text = riwayat.angka2
            tv2Operasi.text = riwayat.operasi
            tv2Hasil.text = riwayat.hasil
        }
    }
}