package ch.heigvd.daa.labo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class EditName : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_name)


        val editButton = findViewById<Button>(R.id.save_button)
        val textField = findViewById<EditText>(R.id.edit_name)

        textField.setText(intent?.getStringExtra(ASK_FOR_NAME_RESULT_KEY))

        editButton.setOnClickListener {
            val fieldValue = textField.text.toString()

            val data = Intent()
            data.putExtra(ASK_FOR_NAME_RESULT_KEY, fieldValue)
            setResult(RESULT_OK, data)
            finish()
        }
    }

    companion object {
        val ASK_FOR_NAME_RESULT_KEY = "NAME_KEY"
    }
}