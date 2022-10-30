package ch.heigvd.daa.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ch.heigvd.daa.labo1.fragments.ConfigFragment

private const val ARG_COUNTER = "param_counter"

// Useful doc about saving back stack state
// https://developer.android.com/guide/fragments/saving-state

class MainActivityFragment2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_fragment2)

        // Configure next btn action
        findViewById<Button>(R.id.btn_next).setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragment_container_config,
                    ConfigFragment.newInstance(nextStepNumber())
                )
                .addToBackStack(null)
                .commit()
        }

        // Configure back btn action
        findViewById<Button>(R.id.btn_back).setOnClickListener {
            onBackPressed()
        }

        // Configure close btn action
        findViewById<Button>(R.id.btn_close).setOnClickListener {
            finish()
        }
    }

    private fun nextStepNumber() = supportFragmentManager.backStackEntryCount + 2
}