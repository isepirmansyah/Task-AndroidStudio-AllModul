package com.example.tugashadiahtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugashadiahtask.Adapter.TransaksiAdapter
import com.example.tugashadiahtask.Model.DividerItemDecoration
import com.example.tugashadiahtask.Model.Transaksi

class RiwayatSelesaiFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var transaksiList: MutableList<Transaksi>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_riwayat_selesai, container, false)

        recyclerView = view.findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val itemDecorator = DividerItemDecoration()
        recyclerView.addItemDecoration(itemDecorator)

        transaksiList = mutableListOf(
            Transaksi(
                shortenTitle("Pembelian Makanan", 15),
                "1 Januari 2023",
                "Rp. 50.000",
                R.drawable.credit_card_rafiki
            ),
            Transaksi(
                shortenTitle("Pembayaran Tagihan Listrik", 15),
                "5 Februari 2023",
                "Rp. 200.000",
                R.drawable.credit_card_rafiki
            ),
            Transaksi(
                shortenTitle("Belanja Fashion", 15),
                "10 Maret 2023",
                "Rp. 300.000",
                R.drawable.credit_card_rafiki
            ),
            Transaksi(
                shortenTitle("Pembelian Tiket Konser", 15),
                "15 April 2023",
                "Rp. 150.000",
                R.drawable.credit_card_rafiki
            ),
            Transaksi(
                shortenTitle("Pembayaran Internet", 15),
                "20 Mei 2023",
                "Rp. 180.000",
                R.drawable.credit_card_rafiki
            ),
            Transaksi(
                shortenTitle("Pengeluaran Transportasi", 15),
                "25 Juni 2023",
                "Rp. 100.000",
                R.drawable.credit_card_rafiki
            ),
            Transaksi(
                shortenTitle("Pembelian Buku", 15),
                "30 Juli 2023",
                "Rp. 120.000",
                R.drawable.credit_card_rafiki
            ),
            Transaksi(
                shortenTitle("Pembayaran Asuransi", 15),
                "5 Agustus 2023",
                "Rp. 250.000",
                R.drawable.credit_card_rafiki
            ),
            Transaksi(
                shortenTitle("Pengeluaran Hiburan", 15),
                "10 September 2023",
                "Rp. 80.000",
                R.drawable.credit_card_rafiki
            ),
            Transaksi(
                shortenTitle("Pembelian Barang Elektronik", 15),
                "15 Oktober 2023",
                "Rp. 400.000",
                R.drawable.credit_card_rafiki
            )
        )

        val adapter = TransaksiAdapter(transaksiList)
        recyclerView.adapter = adapter

        return view
    }

    private fun shortenTitle(title: String, maxLength: Int): String {
        return if (title.length > maxLength) {
            val shortenedTitle = title.substring(0, maxLength - 3) + "..."
            shortenedTitle
        } else {
            title
        }
    }
}
