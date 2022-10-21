package ch.heigvd.daa.labo1.contract

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import ch.heigvd.daa.labo1.EditName

class PickNameContract : ActivityResultContract<String?, String?>() {
    override fun createIntent(context: Context, input: String?) =
        Intent(context, EditName::class.java).apply {
            putExtra(EditName.ASK_FOR_NAME_RESULT_KEY, input)
        }

    override fun parseResult(resultCode: Int, intent: Intent?): String? {
        if (resultCode != Activity.RESULT_OK) {
            return null
        }
        return intent?.getStringExtra(EditName.ASK_FOR_NAME_RESULT_KEY)
    }
}