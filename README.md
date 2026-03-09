# Robotics Scouting App

This is a scouting tool for robotics competitions, designed to capture and export match data through a Jetpack Compose interface.

---

## 

### `MainActivity.kt`

The application's entry point and permission handler.

* **Permission Management**: Requests critical system privileges on startup, including `WRITE_EXTERNAL_STORAGE` and `MANAGE_EXTERNAL_STORAGE`, to enable data saving.
* **Theme Integration**: Wraps the entire UI in the custom `TELEOPTheme`.
* **Root UI**: Hosts the `Surfaces` composable, which initializes the navigation graph and fills the device screen.

### `QR.kt`

Handles the exporting of data and the conversion of scouting stats into a portable string.

* **`ExportButton`**: A central component that aggregates all collected data from various match phases (Pre-Match through Notes) into a single, tilde-delimited (`~`) string.
* **QR Generation**: Uses the `QRCodeWriter` from the ZXing library to transform the exported data string into a scannable `ImageBitmap`.
* **Local Storage**: Includes `writeToFile`, which saves the match data as a `.txt` file in the device's Downloads directory.

---

## App Structure

The project is organized into modules for clarity and maintainability:

| Directory | Purpose |
| --- | --- |
| **`navigation/`** | Defines `BottomNavItem` and the `NavHost` logic for switching match phases. |
| **`ui/Screens/`** | Contains phase-specific logic for `PreMatch`, `Auton`, `TeleOp`, `EndGame`, and `Notes`. |
| **`ui/theme/`** | Manages the visual identity, including custom colors, typography, and Material 3 theming. |

---

## Data Export Format

The app uses a standardized string format for scanning into a master spreadsheet:
`ScouterName~Team#~Match#~NoteStart~Taxi~AutonPickups~...~GeneralNotes~PenaltyPoints`.
