package com.sambudisp.made.localization

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sambudisp.made.R
import kotlinx.android.synthetic.main.adapter_riwayat.view.*

class HistoryAdapter(
        private val listHistory: List<HistoryResponse>,
        private val listener: historyListener
) : RecyclerView.Adapter<historyHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): historyHolder {
        return historyHolder(
                LayoutInflater.from(p0.context).inflate(
                        R.layout.adapter_riwayat,
                        p0,
                        false
                )
        )
    }

    override fun getItemCount(): Int = listHistory.size

    override fun onBindViewHolder(p0: historyHolder, p1: Int) {
        p0.bindHistory(listHistory[p1], listener)
    }
}

interface historyListener {
    fun onHistoryClick(history: HistoryResponse)
}

class historyHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val nama = view.txt_nama_leasing_dp
    private val alamat = view.txt_alamat_leasing_dp
    private val jam = view.txt_open_closed

    fun bindHistory(history: HistoryResponse, listener: historyListener) {
        nama.text = history.nama
        alamat.text = history.alamat
        jam.text = history.jam

        itemView.setOnClickListener {
            listener.onHistoryClick(history)
        }

    }
}