/**
 * Exercice 3
 * @author Damien Maier, Vincent Peer, Jean-François Pasche
 */

package ch.heigvd.daa.labo1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import ch.heigvd.daa.labo1.fragments.ConfigFragment


/**
 * Displays configuration steps with navigation buttons
 */
class MainActivityFragment2 : AppCompatActivity() {

    /**
     * Displays :
     * - The current configuration step number
     * - A next button that allows to go to the next step
     * - A back button that allows to go back to the previous step. If there is no previous step, the activity ends.
     * - A close button that ends the activity
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main_fragment2)

        // Configure next btn action
        findViewById<Button>(R.id.btn_next).setOnClickListener {
            // Transaction that puts the new step fragment into the container
            // The transaction is added to the backstack
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
            // Presses the phone back button
            onBackPressed()
        }

        // Configure close btn action
        findViewById<Button>(R.id.btn_close).setOnClickListener {
            finish()
        }
    }

    private fun nextStepNumber() = supportFragmentManager.backStackEntryCount + 2
}