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

## Reference
Lecture 3, Example 16 and 24 from the CS501 course materials.
https://developer.android.com/develop/ui/compose/components/snackbar
