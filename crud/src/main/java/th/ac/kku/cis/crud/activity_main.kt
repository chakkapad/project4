package th.ac.kku.cis.crud

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import th.ac.kku.cis.crud.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // เชื่อมโยงไปยังเลย์เอาท์ด้วย DataBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // กำหนดการทำงานเมื่อปุ่ม Update ถูกคลิก
        binding.mainUpdate.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, UpdateActivity::class.java)
            startActivity(intent) // เรียกเปิด UpdateActivity
        })

        // กำหนดการทำงานเมื่อปุ่ม Delete ถูกคลิก
        binding.mainDelete.setOnClickListener(View.OnClickListener {
            val intent = Intent(this@MainActivity, DeleteActivity::class.java)
            startActivity(intent) // เรียกเปิด DeleteActivity
        })
    }
}
