//PREMATCH FILE
package com.example.teleop.ui.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.teleop.ui.navigation.BottomNavItem
import com.example.teleop.ui.theme.Purple40
import com.example.teleop.ui.theme.Purple80


var name = ""
var teamnum = ""
var matchnum = ""
var noteStart = false
var selectedScreen: Int = 0


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PreMatch(onNavigateToAuton: () -> Unit, navController: NavHostController, modes: List<BottomNavItem>){
    var names by remember { mutableStateOf(name) }
    var teamnums by remember { mutableStateOf(teamnum) }
    var matchnums by remember { mutableStateOf(matchnum) }
    var noteStarts by rememberSaveable { mutableStateOf(noteStart) }

    Scaffold(
        Modifier,
        topBar = {
            TopAppBar(
                title = {
                    androidx.compose.material.Text(text = "Team $teamnum || Match $matchnum || Pre-Match")
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
                        selected = selectedItem == 0,
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
                    Text(text = "PRE-MATCH", fontSize = bText.sp)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextField(
                        modifier = Modifier.background(
                            shape = RoundedCornerShape(50),
                            color = Color.Transparent
                        )
                            .border(
                                BorderStroke(
                                    width = 4.dp,
                                    brush = Brush.horizontalGradient(listOf(Purple80, Purple40))
                                ),
                            ),
                            value = names,
                            onValueChange = { names = it; name = it },
                            label = { Text("Your Name") },
                            maxLines = 1,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Uri,
                                autoCorrect = false
                            ),
                            colors = TextFieldDefaults.colors(
                                focusedIndicatorColor = Color.Transparent,
                                unfocusedIndicatorColor = Color.Transparent,
                            )
                        )
                    name = names
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextField(
                        modifier = Modifier.border(
                            BorderStroke(
                                width = 4.dp,
                                brush = Brush.horizontalGradient((listOf(Purple40, Purple80)))
                            ),
                        ),
                        value = teamnum,
                        onValueChange = { teamnums = it; teamnum = it },
                        label = { Text(text = "Team Number") }, maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                    teamnum = teamnums
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextField(
                        modifier = Modifier.border(
                          BorderStroke(
                              width = 4.dp,
                              brush = Brush.horizontalGradient(listOf(Purple80, Purple40))
                          ),
                        ),
                        value = matchnums,
                        onValueChange = { matchnums = it; matchnum = matchnums  },
                        label = { Text(text = "Match Number") }, maxLines = 1,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Note Start: ", fontSize = mText.sp)
                    Checkbox(
                        modifier = Modifier.scale(scaleMultiplier),
                        checked = noteStarts, onCheckedChange = { noteStarts = it })
                    noteStart = noteStarts
                }
            }
        }
    )
}


