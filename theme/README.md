# Theme Directory

This directory contains the visual configuration for the application, defining the color palette, typography, and overall theme. 

---

## File Overview

* **`Color.kt`**: Defines the specific hex codes for the application's color scheme. It includes light and dark color variants, as well as a specialized `dBackground` color used for a consistent background.
* **`Theme.kt`**: The central configuration for the app's visual style. It defines `DarkColorScheme` and `LightColorScheme` using the colors from `Color.kt`. 
* **System UI**: Automatically adjusting the status bar color and icon appearance based on the active theme.
* **Dark Mode**: Switching between color palettes based on the system's dark mode setting.


* **`Type.kt`**: Configures the application's typography. It sets default `TextStyle` attributes—such as `FontFamily`, `FontWeight`, and `fontSize` to make sure that the text is readable.

---

## Key Implementation Details

* **Material 3**: The theme uses `androidx.compose.material3` components, providing a modern design for the scouting interface.
* **Color Overrides**: Uses standard Material color slots (Primary, Secondary, Tertiary) and custom overrides like `onSecondary = Color.White`.
