package ch.heigvd.daa.labo1

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ch.heigvd.daa.labo1.contract.PickNameContract

private const val SAVED_STATE_NAME_KEY = "NAME"

class MainActivity : AppCompatActivity() {

    private var name: String? = null
    private lateinit var welcomeTextView: TextView
    private lateinit var editButton: Button

    // Collect the username through the contract with the EditName class
    private val manageUsername = registerForActivityResult(PickNameContract()) {
        if (it != null) {
            name = it
            updateWelcomeText()
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        name = savedInstanceState?.getString(SAVED_STATE_NAME_KEY)

        setContentView(R.layout.activity_main)

        // Retrieve button and textView
        welcomeTextView = findViewById(R.id.welcome)
        editButton = findViewById(R.id.edit_button)

        updateWelcomeText()

        editButton.setOnClickListener {
            manageUsername.launch(name)
        }
    }

    private fun updateWelcomeText() {
        welcomeTextView.text =
            if (name == null) getString(R.string.ask_for_name)
            else getString(R.string.welcome_user, name)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(SAVED_STATE_NAME_KEY, name)
    }

}
