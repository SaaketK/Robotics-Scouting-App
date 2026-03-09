//NOTES FILE
package com.example.teleop.ui.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.teleop.ui.ExportButton
import com.example.teleop.ui.navigation.BottomNavItem
import com.example.teleop.ui.theme.Purple40
import com.example.teleop.ui.theme.Purple80

var bNotes = ""
var gNotes = ""
var deliver = false
var pp = ""

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Notes(onNavigateToEndGames: () -> Unit,  navController: NavHostController, modes: List<BottomNavItem>) {
    var delivers by rememberSaveable { mutableStateOf(deliver) }
    var bNotess by rememberSaveable { mutableStateOf(bNotes) }
    var gNotess by rememberSaveable { mutableStateOf(gNotes) }
    var pps by rememberSaveable { mutableStateOf(pp) }

    Scaffold(
        Modifier,
        topBar = {
            TopAppBar(
                title = {
                    androidx.compose.material.Text(text = "Team $teamnum || Match $matchnum || Notes")
                },
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 10.dp
            )
        },
        bottomBar = {
            var selectedItem by remember { mutableStateOf(selectedScreen) }
            BottomNavigation {
                modes.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = { Icon(item.Icon, null) },
                        label = { Text(item.name, color = Color.White) },
                        selected = selectedItem == 4,
                        onClick = { selectedItem = index; navController.navigate(item.route) }
                    )
                } }
        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = (padding * 0).dp,
                    top = (padding / 4).dp,
                    end = (padding * 0).dp,
                    bottom = padding.dp
                ), verticalArrangement = Arrangement.SpaceEvenly) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "NOTES/OTHER", fontSize = 75.sp)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Delivery Bot: ", fontSize = mText.sp)
                    Checkbox(
                        modifier = Modifier.scale(scaleMultiplier),
                        checked = delivers, onCheckedChange = { delivers = it})
                    deliver = delivers
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Break Notes: ", fontSize = mText.sp)
                    TextField(
                        modifier = Modifier.border(
                            BorderStroke(
                                width = 4.dp,
                                brush = Brush.horizontalGradient(listOf(Purple80, Purple40))
                            ),
                        ),
                        value = bNotess,
                        onValueChange = { bNotess = it; bNotes = it },
                        label = { Text(text = "Structure/Robot damage notes") }, maxLines = 7 )
                    bNotes = bNotess
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "General Notes: ", fontSize = mText.sp)
                    TextField(
                        modifier = Modifier.border(
                            BorderStroke(
                                width = 4.dp,
                                brush = Brush.horizontalGradient(listOf(Purple40, Purple80))
                            ),
                        ),
                        value = gNotess,
                        onValueChange = { gNotess = it; gNotes = it },
                        label = { Text(text = "Anything important") }, maxLines = 7)
                    gNotes = gNotess
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Penalty Points: ", fontSize = mText.sp)
                    TextField(
                        modifier = Modifier.border(
                            BorderStroke(
                                width = 4.dp,
                                brush = Brush.horizontalGradient(listOf(Purple80, Purple40))
                            ),
                        ),
                        value = pps,
                        onValueChange = { pps = it; pp = pps },
                        label = { Text(text = "Opposing Alliance's Penalty Pts") },
                        maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.Center
                ) {
                    val context = LocalContext.current
                    ExportButton(modifier = Modifier.size(buttSize.dp), context = context)
                }
            }
        }
    )
}

