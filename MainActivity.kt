//MAIN ACTIVITY FILE
package com.example.teleop

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.example.teleop.ui.navigation.Navigation
import com.example.teleop.ui.theme.TELEOPTheme
import android.Manifest
import android.os.Build
import androidx.annotation.RequiresApi


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TELEOPTheme {
               Surfaces()
            }
        }

        if ((ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) or ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) or ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_PHONE_STATE)
            ) or ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.MANAGE_EXTERNAL_STORAGE)
            != PackageManager.PERMISSION_GRANTED
        )
        {
            try {
                ActivityCompat.requestPermissions(
                    this,
                    arrayOf(
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.MANAGE_EXTERNAL_STORAGE
                    ),
                    100
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}

@Composable
fun Surfaces(){
    Surface(
        modifier = Modifier.fillMaxSize(),
        content = { Navigation() }
    )

}
