package com.example.app_klinik.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_klinik.PageDetailDokterActivity
import com.example.app_klinik.PageDisplayListActivity
import com.example.app_klinik.R
import com.example.app_klinik.model.ModelListDoctor

class AdapterDokter (
    val itemList: ArrayList<ModelListDoctor>,
    val getActivity: PageDisplayListActivity
): RecyclerView.Adapter<AdapterDokter.MyViewHolder>()
{
    class MyViewHolder (itemView: View):RecyclerView.ViewHolder(itemView){
        var itemGambar : ImageView
        var itemNama : TextView
        var itemSpesialis : TextView
        var itemReview : TextView
        var itemNilai : TextView

        init {
            itemGambar = itemView.findViewById(R.id.imgDokter) as ImageView
            itemNama = itemView.findViewById(R.id.txtNamaDokter) as TextView
            itemSpesialis = itemView.findViewById(R.id.txtSpesialis) as TextView
            itemReview = itemView.findViewById(R.id.txtReview) as TextView
            itemNilai = itemView.findViewById(R.id.txtNilai) as TextView
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val nView = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_dokter, parent,false)
        return MyViewHolder(nView)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemGambar.setImageResource(itemList[position].imgDoctor)
        holder.itemNama.setText(itemList[position].namaDoctor)
        holder.itemSpesialis.setText(itemList[position].spesDoctor)
        holder.itemReview.setText(itemList[position].jumlahReview)
        holder.itemNilai.setText(itemList[position].angkaRating)

        holder.itemView.setOnClickListener(){
            val intent = Intent(getActivity,PageDetailDokterActivity::class.java)

            intent.putExtra("gambar",itemList[position].imgDoctor)
            intent.putExtra("nama_dokter",itemList[position].namaDoctor)
            intent.putExtra("spesialis",itemList[position].spesDoctor)
            intent.putExtra("review",itemList[position].jumlahReview)
            intent.putExtra("nilai",itemList[position].angkaRating)

            getActivity.startActivity(intent)

        }

    }
}
