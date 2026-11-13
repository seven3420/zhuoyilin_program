package cn.edu.sicnu.cs.stu.zhuoyilin.zhuoyilin_program

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HistoryAdapter(private val list: List<HistoryBean>) :
    RecyclerView.Adapter<HistoryAdapter.VH>() {

    inner class VH(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        val tv: TextView = itemView.findViewById(R.id.tv_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_history, parent, false)
        return VH(v)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.tv.text = list[position].record
    }

    override fun getItemCount(): Int = list.size
}
