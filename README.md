# Scaffold Top and Bottom Bar Example
A simple Jetpack Compose app example that demonstrates how to use `Scaffold` with a **Top App Bar**, **Bottom Navigation Bar**, **Floating Action Button (FAB)**, and **Snackbars**.  

---

## Features
- Top App Bar with a title.  
- Bottom Navigation Bar with three tabs: **Home**, **Settings**, and **Profile**.  
- Floating Action Button (FAB) that shows a snackbar when clicked.  
- SnackbarHost to display messages.  
- Central content area that updates based on the selected tab.  

---

## How it Works

### MainActivity
- Sets up the app theme (`ScaffoldTopBottomBarTheme`).  
- Uses a `Scaffold` with `ScaffoldWithNavigation()` as the main content.  

### ScaffoldWithNavigation
- Keeps track of the selected bottom navigation tab.  
- Defines a `SnackbarHostState` and coroutine scope for showing snackbars.  
- Contains the following scaffold elements:
  - **TopAppBar**: Displays the app title.  
  - **NavigationBar**: Displays tabs (`Home`, `Settings`, `Profile`) with selection state.  
  - **FloatingActionButton**: Triggers a snackbar message when clicked.  
  - **SnackbarHost**: Displays the snackbar messages.  
  - **Content Area**: A centered text showing the currently selected tab.

---
## How to Run the App

1. Clone this repository:
   ```bash
   git clone https://github.com/shanji361/ScaffoldTopBottomBar.git
   ```
2. Open the project in Android Studio.

3. Run the app on an emulator or a physical Android device.   
---

## References

- CS501 Course Materials — Lecture 3, Examples 16 and 24  
- [Android Developers: Snackbar](https://developer.android.com/develop/ui/compose/components/snackbar)
