package com.example.tugashadiahtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugashadiahtask.Adapter.PatientsAdapter
import com.example.tugashadiahtask.Model.MyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfileFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PatientsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        adapter = PatientsAdapter(emptyList()) { itemId ->
            navigateToDetail(itemId)
        }
        recyclerView.adapter = adapter

        fetchData()
    }

    private fun fetchData() {
        val service = ApiConfig.getInstance()
        val call = service.getAllPatients()

        call.enqueue(object : Callback<MyResponse> {
            override fun onResponse(call: Call<MyResponse>, response: Response<MyResponse>) {
                if (response.isSuccessful) {
                    val data = response.body()?.data

                    data?.let {
                        adapter.updateData(it)
                    }
                } else {

                }
            }

            override fun onFailure(call: Call<MyResponse>, t: Throwable) {
            }
        })
    }

    private fun navigateToDetail(itemId: Int) {

    }
}
