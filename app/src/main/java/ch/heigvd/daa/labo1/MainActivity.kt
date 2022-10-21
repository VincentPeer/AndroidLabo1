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

        val editButton = findViewById<Button>(R.id.edit_button)
        editButton.setOnClickListener{

            getName.launch(name)
        }
    }

    private val getName = registerForActivityResult(PickNameContract()) {
        val fieldValue = findViewById<TextView>(R.id.welcome)
        fieldValue.text = String.format("Bienvenue %s", it);
        name = "$it";
    }

}
