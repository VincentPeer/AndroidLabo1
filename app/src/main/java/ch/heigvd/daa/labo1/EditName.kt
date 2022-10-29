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

        // Retrieve button and text-field references
        val saveButton = findViewById<Button>(R.id.save_button)
        val textField = findViewById<EditText>(R.id.edit_name)

        // Set the username in the text field
        textField.setText(intent?.getStringExtra(ASK_FOR_NAME_RESULT_KEY))

        // Wait that the user press the save button and
        // put the name in the intend to read it from the main activity
        saveButton.setOnClickListener {
            val fieldValue = textField.text.toString()
            val data = Intent()
            data.putExtra(ASK_FOR_NAME_RESULT_KEY, fieldValue)
            setResult(RESULT_OK, data)
            finish()
        }
    }

    // Key for the name
    companion object {
        val ASK_FOR_NAME_RESULT_KEY = "NAME_KEY"
    }
}