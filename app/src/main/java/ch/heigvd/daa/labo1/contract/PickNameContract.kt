package ch.heigvd.daa.labo1.contract

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import ch.heigvd.daa.labo1.EditName

/**
 * Contract between the main activity and a class to edit a name
 * We collect the name of a user and bring it back to the main class
 */
class PickNameContract : ActivityResultContract<String?, String?>() {
    // Establish an intent with the second class and give the key we wait
    override fun createIntent(context: Context, input: String?) =
        Intent(context, EditName::class.java).apply {
            putExtra(EditName.ASK_FOR_NAME_RESULT_KEY, input)
        }

    // Receive the response from the contract and collect the key
    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if (resultCode != Activity.RESULT_OK) {
            return null
        }
        return intent?.getStringExtra(EditName.ASK_FOR_NAME_RESULT_KEY)
    }
}