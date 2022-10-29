package ch.heigvd.daa.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import ch.heigvd.daa.labo1.contract.PickNameContract

class MainActivity : AppCompatActivity() {

    var name : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve button's reference
        val editButton = findViewById<Button>(R.id.edit_button)

        // Wait the user to press the edit button and collect the name
        editButton.setOnClickListener{
            manageUsername.launch(name)
        }
    }

    // Collect the username through the contract with the EditName class
    private val manageUsername = registerForActivityResult(PickNameContract()) {
        val fieldValue = findViewById<TextView>(R.id.welcome)
        fieldValue.text = String.format("Bienvenue %s", it);
        name = "$it";
    }

}
