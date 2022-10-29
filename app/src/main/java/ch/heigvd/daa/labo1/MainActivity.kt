package ch.heigvd.daa.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ch.heigvd.daa.labo1.contract.PickNameContract

class MainActivity : AppCompatActivity() {

    private var name : String? = null
    private lateinit var welcomeTextView:TextView
    private lateinit var editButton:Button
    // Collect the username through the contract with the EditName class
    private val manageUsername = registerForActivityResult(PickNameContract()) {
        if (it != null) {
            name = it
            welcomeTextView.text = getString(R.string.welcome_user, name)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve button and textView
        welcomeTextView = findViewById(R.id.welcome)
        editButton = findViewById(R.id.edit_button)

        editButton.setOnClickListener{
            manageUsername.launch(name)
        }
    }

}
