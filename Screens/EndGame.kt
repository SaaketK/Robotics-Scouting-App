//ENDGAME FILE
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
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ExposedDropdownMenuDefaults
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.teleop.ui.navigation.BottomNavItem

var onStage = ""
var trap = 0
var harmony = false
var park = false

@OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EndGame(onNavigateToApps: () -> Unit, onNavigateToNotes: () -> Unit,  navController: NavHostController, modes: List<BottomNavItem>) {
    var onStages by rememberSaveable { mutableStateOf(onStage) }
    var traps by rememberSaveable { mutableIntStateOf(trap) }
    var harmonys by rememberSaveable { mutableStateOf(harmony) }
    var parks by rememberSaveable { mutableStateOf(park) }
    var isExpanded by rememberSaveable{ mutableStateOf( false)}

    Scaffold(
        Modifier,
        topBar = {
            TopAppBar(
                title = {
                    androidx.compose.material.Text(text = "Team $teamnum || Match $matchnum || Endgame")
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
                        selected = selectedItem == 3,
                        onClick = { selectedItem = index; navController.navigate(item.route) }
                    )
                } }
        },
        content = {
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 0.dp,
                    top = (padding / 4).dp,
                    end = (padding * 0).dp,
                    bottom = padding.dp
                ), verticalArrangement = Arrangement.SpaceEvenly) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "END-GAME", fontSize = 75.sp)
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "They were the ")
                    ExposedDropdownMenuBox(
                        expanded = isExpanded,
                        onExpandedChange = { isExpanded = it}
                    ){
                        TextField(
                            value = onStages,
                            onValueChange = {},
                            readOnly = true,
                            trailingIcon = {ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)},
                            modifier = Modifier.menuAnchor()
                        )
                        ExposedDropdownMenu(expanded = isExpanded, onDismissRequest = { isExpanded = false  }) {
                            DropdownMenuItem(
                                onClick = {
                                    onStages = "No Climb"
                                    isExpanded = false
                                }) {
                                Text(text = "No Climb")
                            }
                            DropdownMenuItem(
                                onClick = {
                                    onStages = "First"
                                    isExpanded = false
                                }) {
                                Text(text = "First")
                            }
                            DropdownMenuItem(
                                onClick = {
                                    onStages = "Second"
                                    isExpanded = false
                                }) {
                                Text(text = "Second")
                            }
                            DropdownMenuItem(
                                onClick = {
                                    onStages = "Third"
                                    isExpanded = false
                                }) {
                                Text(text = "Third")
                            }
                        }
                    }
                    Text(text = " team to climb the chain")
                    onStage = onStages
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = {
                        if(traps == 0){
                    }
                    else {
                        traps--
                    } }) {
                        Text(text = "-", fontSize = buttText.sp)
                    }
                    Text(text = " Trap Score: $traps ", fontSize = mText.sp)
                    Button(
                        modifier = Modifier.size(buttSize.dp),
                        shape = CircleShape,
                        onClick = {
                        if(traps == 3){
                    }
                        else{
                            traps++
                        }
                    }) {
                        Text(text = "+", fontSize = buttText.sp)
                    }
                    trap = traps
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "HARMONY:", fontSize = mText.sp)
                    Checkbox(
                        modifier = Modifier.scale(scaleMultiplier),
                        checked = harmonys, onCheckedChange = { harmonys = it })
                    harmony = harmonys
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "PARK:         ", fontSize = mText.sp)
                    Checkbox(
                        modifier = Modifier.scale(scaleMultiplier),
                        checked = parks, onCheckedChange = { parks = it })
                    park = parks
                }
            }
        }
    )
}

