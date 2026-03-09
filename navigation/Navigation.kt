//NAVIGATION FILE
package com.example.teleop.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.teleop.Screens
import com.example.teleop.ui.Screens.App
import com.example.teleop.ui.Screens.Auton
import com.example.teleop.ui.Screens.EndGame
import com.example.teleop.ui.Screens.Notes
import com.example.teleop.ui.Screens.PreMatch

val bottomNavItems =
    listOf<BottomNavItem>(
        BottomNavItem("PreMatch", Screens.PreMatch.route, Icon = Icons.Filled.AccountCircle),
        BottomNavItem( "Auton", Screens.Auton.route, Icon = Icons.Filled.Place),
        BottomNavItem("Teleop", Screens.Teleop.route, Icon = Icons.Filled.Build),
        BottomNavItem("EndGame", Screens.Endgame.route, Icon = Icons.Filled.Settings),
        BottomNavItem("Notes", Screens.Notes.route, Icon = Icons.Filled.Create))

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "PreMatch") {
        composable("PreMatch") {
            PreMatch(
                onNavigateToAuton = { navController.navigate("Auton") },
                navController,
                bottomNavItems
            )
        }
        composable("Auton") {
            Auton(
                onNavigateToPreMatch = { navController.navigate("PreMatch") },
                onNavigateToApp = { navController.navigate("App") },
                navController = navController,
                modes = bottomNavItems
            )
        }
        composable("App") {
            App(
                onNavigateToAutons = { navController.navigate("Auton") },
                onNavigateToEndGame = { navController.navigate("EndGame") },
                navController,
                bottomNavItems
            )
        }
        composable("EndGame") {
            EndGame(
                onNavigateToApps = { navController.navigate("App") },
                onNavigateToNotes = { navController.navigate("Notes") },
                navController,
                bottomNavItems
            )
        }
        composable("Notes") {
            Notes(
                onNavigateToEndGames = { navController.navigate("EndGame") },
                navController,
                bottomNavItems
            )
        }

    }
}


