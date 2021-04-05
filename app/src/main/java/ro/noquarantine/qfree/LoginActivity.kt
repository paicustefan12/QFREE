package ro.noquarantine.qfree

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity() {

    val TAG = "Login Activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        Log.d(TAG, "onCreate called")

        loginBtn.setOnClickListener {
            val username = (findViewById<EditText>(R.id.username).text).toString()
            val password = (findViewById<EditText>(R.id.password).text).toString()

            if (username == "stefan.paicu" && password == "proiectAM") {
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Username or Password incorrect", Toast.LENGTH_SHORT).show()
                findViewById<EditText>(R.id.username).setText("")
                findViewById<EditText>(R.id.password).setText("")
            }

        }
    }

}