package cn.edu.sicnu.cs.stu.zhuoyilin.zhuoyilin_program

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)
        title = "计算历史记录"

        val rv: RecyclerView = findViewById(R.id.rv_history)
        rv.layoutManager = LinearLayoutManager(this)
        val adapter = HistoryAdapter(MainActivity.historyList)
        rv.adapter = adapter

        val btnBack: Button = findViewById(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
    }
}
