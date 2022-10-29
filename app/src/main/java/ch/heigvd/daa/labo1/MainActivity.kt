package ch.heigvd.daa.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ch.heigvd.daa.labo1.contract.PickNameContract

class MainActivity : AppCompatActivity() {

    private var name : String? = null
    private lateinit var welcomeTextView:TextView


    private val getName = registerForActivityResult(PickNameContract()) {
        if (it != null) {
            name = it
            welcomeTextView.text = getString(R.string.welcome_user, name)
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        welcomeTextView = findViewById(R.id.welcome)


        val editButton = findViewById<Button>(R.id.edit_button)
        editButton.setOnClickListener{

            getName.launch(name)
        }
    }
}
