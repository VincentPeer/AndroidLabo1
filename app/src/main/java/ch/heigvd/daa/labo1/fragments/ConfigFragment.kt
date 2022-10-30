package ch.heigvd.daa.labo1.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ch.heigvd.daa.labo1.R

// the fragment initialization parameters
private const val ARG_PARAM1 = "step_number"

/**
 * [Fragment] representing a config step
 * Use the [ConfigFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ConfigFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_config, container, false)

        if (savedInstanceState == null)
            view.findViewById<TextView>(R.id.step_nb).text = "${arguments?.getInt(ARG_PARAM1) ?: 1}"

        return view
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