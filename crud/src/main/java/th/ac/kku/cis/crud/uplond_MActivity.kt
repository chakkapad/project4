package th.ac.kku.cis.crud

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import th.ac.kku.cis.crud.MainActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import th.ac.kku.cis.crud.databinding.ActivityUplondMactivityBinding

class uplond_MActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUplondMactivityBinding
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUplondMactivityBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_uplond_mactivity)

        binding.saveButton.setOnClickListener {
            val name = binding.uploadName.text.toString()
            val operator = binding.uploadOperator.text.toString()
            val location = binding.uploadLocation.text.toString()
            val phone = binding.uploadPhone.text.toString()

            databaseReference = FirebaseDatabase.getInstance().getReference("Phone Directory")
            val PhoneData = PhoneData(name, operator, location, phone)
            databaseReference.child(phone).setValue(PhoneData).addOnSuccessListener {
                binding.uploadName.text.clear()
                binding.uploadOperator.text.clear()
                binding.uploadLocation.text.clear()
                binding.uploadPhone.text.clear()

                Toast.makeText(this,"Saved", Toast.LENGTH_SHORT).show()
                val  intent = Intent(this@uplond_MActivity, MainActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this,"Failed", Toast.LENGTH_SHORT).show()

            }


        }
    }
}
