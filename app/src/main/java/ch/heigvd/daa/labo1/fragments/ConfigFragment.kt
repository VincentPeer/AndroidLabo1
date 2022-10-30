/**
 * Exercice 3
 * @author Damien Maier, Vincent Peer, Jean-François Pasche
 */

package ch.heigvd.daa.labo1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ch.heigvd.daa.labo1.R

// the fragment initialization parameters
private const val STEP_NUMBER_KEY = "step_number"

/**
 * [Fragment] representing a config step.
 *
 * Use the [ConfigFragment.newInstance] factory method to
 * create an instance of this fragment with a chosen step number.
 *
 * If the fragment is created without the factory method, its step number is 1.
 */
class ConfigFragment : Fragment() {

    /**
     * Displays a config step that actually is just a text with the config step number
     *
     * The step number can be provided with the argument key `STEP_NUMBER_KEY`. The default is 1.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_config, container, false).apply {
            // We set the TextView content for the step number.
            // As the state of the fragment is not preserved,
            // this should be done only the first time the fragment is created.
            // The content of the TextView is preserved when it is recreated.
            if (savedInstanceState == null)
                // The step number is retrieved from the argument.
                // If it does not exist, we set it to 1.
                this.findViewById<TextView>(R.id.step_nb).text = (arguments?.getInt(STEP_NUMBER_KEY) ?: 1).toString()
        }
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment with a specific step number.
         *
         * @param step_number The step number of config process.
         * @return A new instance of fragment ConfigFragment.
         */
        @JvmStatic
        fun newInstance(step_number: Int) =
            ConfigFragment().apply {
                arguments = Bundle().apply {
                    putInt(STEP_NUMBER_KEY, step_number)
                }
            }
    }
}