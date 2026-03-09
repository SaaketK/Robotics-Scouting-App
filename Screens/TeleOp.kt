//TELEOP FILE
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

var bText = 75
var mText = 30
var padding = 60
var ampCountT = 0
var speakCountT = 0
var floor = false
var missedNote = 0
var deliNote = 0

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun App(onNavigateToAutons: () -> Unit, onNavigateToEndGame: () -> Unit,  navController: NavHostController, modes: List<BottomNavItem>) {
    var ampCountTs by rememberSaveable { mutableIntStateOf(ampCountT) }
    var speakCountTs by rememberSaveable { mutableIntStateOf(speakCountT) }
    var floors by rememberSaveable { mutableStateOf(floor ) }
    var missedNotes by rememberSaveable { mutableIntStateOf(missedNote) }
    var deliNotes by rememberSaveable { mutableIntStateOf(deliNote) }

    Scaffold(
        Modifier,
        topBar = {
            TopAppBar(
                title = {
                    androidx.compose.material.Text(text = "Team $teamnum || Match $matchnum || Tele-Op")
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
                        label = { Text(item.name,  color = Color.White) },
                        selected = selectedItem == 2,
                        onClick = { selectedItem = index; navController.navigate(item.route) }
                    )
                } }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(
                        start = (padding * 0).dp,
                        top = (padding / 4).dp,
                        end = (padding * 0).dp,
                        bottom = padding.dp
                    ), verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                    Text(text = "TELE-OP", fontSize = bText.sp)
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                    Text(text = "Pick-Up Locations", fontSize = 40.sp)
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                    Text(text = "Floor: ", fontSize = mText.sp)
                    Checkbox(modifier = Modifier.scale(scaleMultiplier), checked = floors, onCheckedChange = {floors = it; floor = floors} )
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center){
                    Text(text = "Scoring", fontSize = 40.sp)
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = { if( ampCountTs == 0){

                        } else{
                            ampCountTs--
                        }
                        }) {
                        Text(text = "-", fontSize = buttText.sp)
                    }
                    Text(text = "  Amp Notes Scored: $ampCountTs  ", fontSize = mText.sp)
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = { ampCountTs++}) {
                        Text(text = "+", fontSize = buttText.sp)
                    }
                    ampCountT = ampCountTs
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = { if( speakCountTs == 0){

                        } else{
                            speakCountTs--
                        }
                        }) {
                        Text(text = "-", fontSize = buttText.sp)
                    }
                    Text(text = "Speaker Notes Scored: $speakCountTs", fontSize = mText.sp)
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = { speakCountTs++}) {
                        Text(text = "+", fontSize = buttText.sp)
                    }
                    speakCountT = speakCountTs
                }
                Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = { if( missedNotes == 0){

                        } else{
                            missedNotes--
                        }
                        }) {
                        Text(text = "-", fontSize = buttText.sp)
                    }
                    Text(text = "Speaker Notes Missed: $missedNotes", fontSize = mText.sp)
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = { missedNotes++}) {
                        Text(text = "+", fontSize = buttText.sp)
                    }
                    missedNote = missedNotes
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ){
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = {
                            if (deliNotes == 0) {

                            } else {
                                deliNotes--; deliNote = deliNotes
                            }
                        }) {
                        Text(text = "-", fontSize = buttText.sp)
                    }
                    Text(text = "      Notes Delivered: $deliNotes     ", fontSize = mText.sp)
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = { deliNotes++; deliNote = deliNotes }
                    ){
                        Text(text = "+", fontSize = buttText.sp)
                    }
                }
            }
        }
    )
}





