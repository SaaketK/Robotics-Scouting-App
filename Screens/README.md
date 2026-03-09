# Screens Directory

This directory contains the Composable screen implementations for the scouting application. Each file represents a specific part of the robotics game, providing a user interface to capture the data

## File Overview

* **`PreMatch.kt`**: The starting page. It captures data including the **Scouter's Name**, **Team Number**, and **Match Number**, and if the robot started with a game piece.
* **`Auton.kt`**: Handles data for the 15 second autonomous period. It tracks whether the robot "taxied" (left the starting zone) and counts the number of notes picked up and scored in the Amp or Speaker.
* **`TeleOp.kt`**: Manages data collection for the driver operated period. It includes counters for notes scored in the Amp and Speaker, missed shots, notes delivered to teammates, and checks floor intake capabilities.
* **`EndGame.kt`**: Focuses on the final moments of the match. It uses a dropdown menu to track climbing order (First, Second, Third, or No Climb) and tracks Trap scores, Harmony, and Park status.
* **`Notes.kt`**: The final summary screen for a qualitiative analysis of the robot. It provides text fields for recording robot damage or general observations, tracks penalty points, and holds the **Export Button** to export the data as a QR Code.

---

## Implementation Details

* **States**: Screens use `rememberSaveable` and global variables to retain data during navigation and configuration changes.
* **Shared UI Components**: The screens use `Scaffold` for the layout and feature a `TopAppBar` that displays current information and a `BottomNavigation` bar for switching between phases.
* **Input Controls**: Uses a mix of custom circular `Button` incrementors, `Checkbox` toggles, and `TextField` inputs.
