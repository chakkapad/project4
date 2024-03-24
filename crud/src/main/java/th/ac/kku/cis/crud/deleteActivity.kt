package th.ac.kku.cis.crud

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import th.ac.kku.cis.crud.databinding.ActivityDeletaBinding

class DeleteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDeletaBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // เชื่อมโยงไปยังเลย์เอาท์ด้วย DataBinding
        binding = ActivityDeletaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // กำหนดการทำงานเมื่อปุ่มลบถูกคลิก
        binding.deleteButton.setOnClickListener {
            val phone = binding.deletePhone.text.toString()
            if (phone.isNotEmpty())
                deleteData(phone) // เรียกเมธอดเพื่อลบข้อมูล
            else
                Toast.makeText(this, "Please enter the phone number", Toast.LENGTH_SHORT).show()
        }
    }

    // เมธอดสำหรับลบข้อมูลจากฐานข้อมูล
    private fun deleteData(phone: String){
        // ระบุตำแหน่งของ Firebase Realtime Database
        database = FirebaseDatabase.getInstance().getReference("Users")

        // ลบข้อมูลโดยใช้หมายเลขโทรศัพท์เป็นคีย์
        database.child(phone).removeValue().addOnSuccessListener {
            // เมื่อลบข้อมูลสำเร็จ
            binding.deletePhone.text.clear() // เคลียร์ช่องป้อนข้อมูล
            Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show() // แสดงข้อความ Deleted
        }.addOnFailureListener {
            // เมื่อไม่สามารถลบข้อมูลได้
            Toast.makeText(this, "Unable to delete", Toast.LENGTH_SHORT).show() // แสดงข้อความ Unable to delete
        }
    }
}
