# Navigation Module

This directory manages the application's navigation infrastructure, handling screen transitions and the data structure for the bottom navigation interface.

## File Overview

* **`BottomBar.kt`**: Defines the data model for navigation components. It uses the `BottomNavItem` data class to standardize the configuration for each screen, holding the display name, unique navigation route, and the `ImageVector` icon
* **`Navigation.kt`**: Serves as the central routing hub. It initializes the `NavHost`, mapping specific routes to their respective Composables (PreMatch, Auton, Teleop, EndGame, and Notes) and managing the navigation flow between them using the `bottomNavItems` list
