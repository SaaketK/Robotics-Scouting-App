//AUTON FILE
package com.example.teleop.ui.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.teleop.ui.navigation.BottomNavItem


var taxi = false
var pickUpCount = 0
var ampCountA = 0
var speakCountA = 0
var buttText = 40
var buttSize = 80
const val scaleMultiplier = 2f

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Auton(onNavigateToApp: () -> Unit, onNavigateToPreMatch: () -> Unit, navController: NavHostController, modes: List<BottomNavItem>) {
    var taxis by rememberSaveable { mutableStateOf(taxi) }
    var pickUpCounts by rememberSaveable { mutableIntStateOf(pickUpCount) }
    var ampCountAs by rememberSaveable { mutableIntStateOf(ampCountA)}
    var speakCountAs by rememberSaveable { mutableIntStateOf(speakCountA) }


    Scaffold(
        Modifier,
        topBar = {
            TopAppBar(
                title = {
                    androidx.compose.material.Text(text = "Team $teamnum || Match $matchnum || Auton")
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
                        selected = selectedItem == 1,
                        onClick = { selectedItem = index; navController.navigate(item.route) },
                    )
                } }
        },
        content = {
            Column(modifier = Modifier.fillMaxSize().padding(start = (padding*0).dp, top = (padding/4).dp, end = (padding*0).dp, bottom = padding.dp), verticalArrangement = Arrangement.SpaceEvenly){
                Row(modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "AUTON", fontSize = bText.sp)
                }
                Row(modifier = Modifier
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center) {
                    Text(text = "Taxi:", fontSize = mText.sp)
                    Checkbox(
                        modifier = Modifier.scale(scaleMultiplier),
                        checked = taxis,
                        onCheckedChange = { taxis = it })
                    taxi = taxis
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
                    Button(
                        modifier = Modifier.size(buttSize.dp) ,
                        shape = CircleShape,
                        onClick = {  if(pickUpCounts == 0){
                    }
                    else {
                        pickUpCounts--
                    } },) {
                        Text(text = "-",
                            fontSize = buttText.sp
                        )
                    }
                    Text(" Notes Picked Up: $pickUpCounts", fontSize = mText.sp)
                    Button(modifier = Modifier.size(buttSize.dp), shape = CircleShape, onClick = { pickUpCounts++ }) {
                        Text(text = "+",
                            fontSize = buttText.sp)
                    }
                    pickUpCount = pickUpCounts
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = {
                        if(ampCountAs == 0){
                    }
                        else {
                            ampCountAs--
                        }
                    }) {
                        Text(text = "-", fontSize = buttText.sp )
                    }
                    Text(text = "      Amp Notes: $ampCountAs      ", fontSize = mText.sp)
                    Button(modifier = Modifier.size(buttSize.dp), shape = CircleShape, onClick = { ampCountAs++ }) {
                        Text(text = "+", fontSize = buttText.sp)
                    }
                    ampCountA = ampCountAs
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly) {
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = {
                            if(speakCountAs == 0){
                    }
                    else {
                        speakCountAs--
                    } }) {
                        Text(text = "-", fontSize = buttText.sp)
                    }
                    Text(text = "   Speaker Notes: $speakCountAs   ", fontSize = mText.sp)
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = { speakCountAs++ }) {
                        Text(text = "+", fontSize = buttText.sp)
                    }
                    speakCountA = speakCountAs
                }
            }
        }
    )
}

