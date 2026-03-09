//QR FILE
package com.example.teleop.ui

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.window.Popup
import com.example.teleop.ui.Screens.ampCountA
import com.example.teleop.ui.Screens.ampCountT
import com.example.teleop.ui.Screens.bNotes
import com.example.teleop.ui.Screens.deliNote
import com.example.teleop.ui.Screens.deliver
import com.example.teleop.ui.Screens.floor
import com.example.teleop.ui.Screens.gNotes
import com.example.teleop.ui.Screens.harmony
import com.example.teleop.ui.Screens.matchnum
import com.example.teleop.ui.Screens.missedNote
import com.example.teleop.ui.Screens.name
import com.example.teleop.ui.Screens.noteStart
import com.example.teleop.ui.Screens.onStage
import com.example.teleop.ui.Screens.park
import com.example.teleop.ui.Screens.pickUpCount
import com.example.teleop.ui.Screens.pp
import com.example.teleop.ui.Screens.speakCountA
import com.example.teleop.ui.Screens.speakCountT
import com.example.teleop.ui.Screens.taxi
import com.example.teleop.ui.Screens.teamnum
import com.example.teleop.ui.Screens.trap
import com.google.zxing.BarcodeFormat
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import java.io.BufferedWriter
import java.io.FileNotFoundException
import java.io.FileWriter

@Composable
fun QRStuff(content:String): ImageBitmap {
    val writer = QRCodeWriter()

    val bitMatrix: BitMatrix = writer.encode(content, BarcodeFormat.QR_CODE, 488, 488)
    val width: Int = bitMatrix.getWidth()
    val height: Int = bitMatrix.getHeight()
    val bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565)
    for (x in 0 until width)
        for (y in 0 until height)
            bmp.setPixel(x, y, if (bitMatrix.get(x, y)) Color.BLACK else Color.WHITE)
    return bmp.asImageBitmap()
    //This function was not created by me, all credit to Stefano on stack overflow
}

@Composable
fun ExportButton(modifier: androidx.compose.ui.Modifier, context: Context){
    var exportString = ""

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        var popupControl by remember { mutableStateOf(false) }
        Button(onClick = {
            if(bNotes.isEmpty())
                bNotes = "N/A"
            if(gNotes.isEmpty())
                gNotes = "N/A"
            if(onStage.isEmpty()){
                onStage = "No Climb"
            if(pp.isEmpty()){
                pp = "0"
            }

            }

            exportString =
                "$name~$teamnum~$matchnum~$noteStart~$taxi~$pickUpCount~$ampCountA~$speakCountA~$floor~$ampCountT~$speakCountT~$missedNote~$deliNote~$onStage~$trap~$harmony~$park~$deliver~$bNotes~$gNotes~$pp".trim()

            try {
                if(!name.isEmpty()){
                    writeToFile(exportString)
                    popupControl = true
                } else{
                    Toast.makeText(context, "You didnt enter your name", Toast.LENGTH_SHORT).show()
                }
            } catch (e: FileNotFoundException) {
                Toast.makeText(context, "YOU DIDN'T ALLOW SYSTEM PRIVILEGES", Toast.LENGTH_SHORT)
                    .show()
            }
            Log.d("Export", "Exported")
        }) {
            Text(text = "Export")
        }
        if (popupControl){
            Popup(alignment = Alignment.TopCenter) {
                Image(bitmap = QRStuff(exportString), contentDescription = null)
            }
        }
        exportString =
            "$name~$teamnum~$matchnum~$noteStart~$taxi~$pickUpCount~$ampCountA~$speakCountA~$floor~$ampCountT~$speakCountT~$missedNote~$deliNote~$onStage~$trap~$harmony~$park~$deliver~$bNotes~$gNotes~$pp".trim()
    }
}


fun writeToFile(message: String) {
    val file = BufferedWriter(
        FileWriter(
            "/storage/emulated/0/${Environment.DIRECTORY_DOWNLOADS}/$teamnum-$matchnum.txt", false
        )
    )
    file.write("$message\n")
    file.close()
}
