package ch.heigvd.daa.labo1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// the fragment initialization parameters
private const val ARG_PARAM1 = "step_number"

/**
 * [Fragment] representing a config step
 * Use the [ConfigFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfigFragment : Fragment() {

    private var step_number: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            // Restore the step number
            this. step_number = savedInstanceState.getInt(ARG_PARAM1)
        } else {
            // If no saved instance, create one with parameter
            arguments?.let {
                step_number = it.getInt(ARG_PARAM1)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_config, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Retrieve ref to GUI
        val stepNbView = view.findViewById<TextView>(R.id.step_nb)

        stepNbView.text = step_number.toString()

    }

    // Save the step number
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_PARAM1, step_number)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param step_number The step number of config process.
         * @return A new instance of fragment ConfigFragment.
         */
        @JvmStatic
        fun newInstance(step_number: Int) =
            ConfigFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, step_number)
                }
            }
    }
}