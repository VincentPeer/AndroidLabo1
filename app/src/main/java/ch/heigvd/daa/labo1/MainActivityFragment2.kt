package ch.heigvd.daa.labo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

private const val ARG_COUNTER = "param_counter"

// Useful doc about saving back stack state
// https://developer.android.com/guide/fragments/saving-state

class MainActivityFragment2 : AppCompatActivity() {

    // Counter to attribute number to config steps
    private var counter:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_fragment2)
        if(savedInstanceState != null) {
            // Restore activity state
            counter = savedInstanceState.getInt(ARG_COUNTER)
        } else {
            // Create initial fragment if no saved instance available
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_config, ConfigFragment.newInstance(counter))
                .commit()
        }

        // Retrieve references to buttons
        val btnBack = findViewById<Button>(R.id.btn_back)
        val btnClose = findViewById<Button>(R.id.btn_close)
        val btnNext = findViewById<Button>(R.id.btn_next)

        // Configure next btn action
        btnNext.setOnClickListener {
            ++counter
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_config, ConfigFragment.newInstance(counter))
                .addToBackStack(null)
                .commit()
        }

        // Configure back btn action
        btnBack.setOnClickListener {
            if (--counter == 0) {
                closeConfig()
            } else {
               supportFragmentManager.popBackStack()
            }
        }

        // Configure close btn action
        btnClose.setOnClickListener {
            closeConfig()
        }

    }

    // Custom saving
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_COUNTER, counter)
    }

    /**
     * Action to trigger when closing config panel
     */
    private fun closeConfig() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }

}