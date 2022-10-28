package ch.heigvd.daa.labo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button

private const val ARG_COUNTER = "param_counter"


class MainActivityFragment2 : AppCompatActivity() {

    private var counter:Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState != null)
            counter = savedInstanceState.getInt(ARG_COUNTER)

        setContentView(R.layout.activity_main_fragment2)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_config, ConfigFragment.newInstance(counter))
            .commit()

        // Retrieve references to buttons
        val btnBack = findViewById<Button>(R.id.btn_back)
        val btnClose = findViewById<Button>(R.id.btn_close)
        val btnNext = findViewById<Button>(R.id.btn_next)

        btnNext.setOnClickListener {
            ++counter
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_config, ConfigFragment.newInstance(counter))
                .addToBackStack(null)
                .commit()
        }

        btnBack.setOnClickListener {
            if (--counter == 0) {
                closeConfig()
            } else {
                supportFragmentManager.popBackStack()
            }
        }

        btnClose.setOnClickListener {
            closeConfig()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Never called ... why ??? is it a bug ???
        super.onSaveInstanceState(outState)
        outState.putInt(ARG_COUNTER, counter)
//        outPersistentState.putInt(ARG_COUNTER, counter)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        counter = savedInstanceState.getInt(ARG_COUNTER)
    }


    private fun closeConfig() {
        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
    }


}