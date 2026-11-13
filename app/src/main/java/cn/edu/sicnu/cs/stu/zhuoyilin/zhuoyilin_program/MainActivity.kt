package cn.edu.sicnu.cs.stu.zhuoyilin.zhuoyilin_program

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var etNum1: EditText
    private lateinit var etNum2: EditText
    private lateinit var tvResult: TextView
    private val calculator = Calculator()

    companion object {
        val historyList = ArrayList<HistoryBean>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "卓怡霖 2024110152"

        supportActionBar?.elevation = 8f
        etNum1 = findViewById(R.id.et_num1)
        etNum2 = findViewById(R.id.et_num2)
        tvResult = findViewById(R.id.tv_result)

        val btnAdd: Button = findViewById(R.id.btn_add)
        val btnSub: Button = findViewById(R.id.btn_sub)
        val btnMul: Button = findViewById(R.id.btn_mul)
        val btnDiv: Button = findViewById(R.id.btn_div)
        // 新增：查看历史按钮
        val btnGoHistory: Button = findViewById(R.id.btn_go_history)

        btnAdd.setOnClickListener { calc("+") }
        btnSub.setOnClickListener { calc("-") }
        btnMul.setOnClickListener { calc("*") }
        btnDiv.setOnClickListener { calc("/") }
        // 按钮点击跳转历史页面
        btnGoHistory.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun calc(op: String) {
        val s1 = etNum1.text.toString().trim()
        val s2 = etNum2.text.toString().trim()
        if (s1.isEmpty() || s2.isEmpty()) {
            Toast.makeText(this, "请输入两个数字！", Toast.LENGTH_SHORT).show()
            return
        }
        val n1: Double
        val n2: Double
        try {
            n1 = s1.toDouble()
            n2 = s2.toDouble()
        } catch (e: Exception) {
            Toast.makeText(this, "数字格式错误！", Toast.LENGTH_SHORT).show()
            return
        }
        var record: String
        try {
            val res = when (op) {
                "+" -> calculator.add(n1, n2)
                "-" -> calculator.sub(n1, n2)
                "*" -> calculator.mul(n1, n2)
                "/" -> calculator.div(n1, n2)
                else -> 0.0
            }
            record = "$n1 $op $n2 = $res"
            tvResult.text = "结果：$res"
        } catch (e: ArithmeticException) {
            record = "$n1 / $n2 = 错误：除数不能为0"
            tvResult.text = record
        }
        historyList.add(HistoryBean(record))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_history) {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
