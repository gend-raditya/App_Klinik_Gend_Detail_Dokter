package com.example.app_klinik

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_klinik.adapter.AdapterDokter
import com.example.app_klinik.adapter.AdapterHastag
import com.example.app_klinik.adapter.AdapterMenuIcon
import com.example.app_klinik.model.MockList
import com.example.app_klinik.model.MockList1
import com.example.app_klinik.model.MockList2
import com.example.app_klinik.model.ModelHastag
import com.example.app_klinik.model.ModelListDoctor
import com.example.app_klinik.model.ModelMenuIcon

class PageDisplayListActivity : AppCompatActivity() {
    private lateinit var rv_hastag : RecyclerView
    private lateinit var rv_icon : RecyclerView
    private lateinit var rv_dokter : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_page_display_list)

        rv_hastag = findViewById(R.id.rv_hastag)
        rv_icon = findViewById(R.id.rv_icon)
        rv_dokter = findViewById(R.id.rv_dokter)

        ///recycle view hastag
        rv_hastag.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true)
        val adapter = AdapterHastag(MockList1.getModel() as ArrayList<ModelHastag>,this)
        rv_hastag.adapter = adapter

        ///recyle view icon
        rv_icon.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,true)
        val adapter1 = AdapterMenuIcon(MockList.getModel() as ArrayList<ModelMenuIcon>,this)
        rv_icon.adapter = adapter1

        //recycle view dokter
        rv_dokter.layoutManager = GridLayoutManager(this, 1)
        val adapter2 = AdapterDokter(MockList2.getModel() as ArrayList<ModelListDoctor>, this)
        rv_dokter.adapter = adapter2
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}