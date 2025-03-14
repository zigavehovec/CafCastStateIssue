package com.test.cafcaststateissue

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.cast.framework.CastContext
import com.google.android.gms.cast.framework.CastState

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val castContext = CastContext.getSharedInstance(this)

        Log.d("MainActivity", "Cast state: ${castContext.castState.toCastStateString()}")
        castContext.addCastStateListener {
            Log.d("MainActivity", "Cast state changed: ${it.toCastStateString()}")
            Toast.makeText(
                this,
                "Cast state changed: ${it.toCastStateString()}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

private fun Int.toCastStateString() = CastState.toString(this)