package com.example.teleop

sealed class Screens(val route: String) {
    object PreMatch: Screens("PreMatch")
    object Auton: Screens("Auton")
    object Teleop: Screens("App")
    object Endgame: Screens("EndGame")
    object Notes: Screens("Notes")
}