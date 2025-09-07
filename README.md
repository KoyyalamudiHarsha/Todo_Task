TodoTask
TodoTask is a simple, modern TODO list management application for Android, built to showcase a robust, production-ready architecture using the latest Jetpack libraries.

Overview
This application provides essential TODO list functionalities, including adding, searching, and deleting tasks. It is designed with a clean, intuitive user interface and a focus on providing a great user experience, with features like swipe-to-delete for single items and a contextual multi-select mode for bulk actions.

✨ Features
Add & View Tasks: Easily add new tasks and view them in a clean, scrollable list.

Real-time Search: Filter the task list instantly by typing in the search bar (with a 500ms debounce for performance).

Swipe-to-Delete: Quickly delete a single task with a simple swipe gesture.

Multi-Select Mode: Long-press any item to enter a contextual action mode to select and delete multiple tasks at once.

Empty State: A helpful message is displayed when the task list is empty.

Error Handling: A Snackbar message appears for specific error conditions (e.g., trying to add a task with the title "Error").

Modern UI: A clean, responsive UI built entirely with Jetpack Compose and Material 3, including a theme that adapts to system light/dark modes.

🛠️ Tech Stack & Architecture
This project is built with a modern technology stack and follows the principles of Clean Architecture to ensure a separation of concerns, making the codebase scalable, maintainable, and testable.

Tech Stack
Language: 100% Kotlin

UI: Jetpack Compose for declarative UI development.

Asynchronicity: Kotlin Coroutines & Flow for managing background threads and handling streams of data.

Architecture: MVVM (Model-View-ViewModel) on top of a layered Clean Architecture.

Dependency Injection: Hilt for managing dependencies.

Persistence: Room for local database storage.

Navigation: Jetpack Navigation for Compose to handle screen transitions.

Styling: Material 3 for UI components and theming.

Architecture
The application is structured into three distinct layers: UI, Domain, and Data.

+-------------------------------------------------------------------------+
|      UI Layer (Jetpack Compose, ViewModel)                              |
|          |         ^                                                    |
| (Observes State) |         | (Sends Events)                                 |
|          v         |                                                    |
+-------------------------------------------------------------------------+
|      Domain Layer (UseCases, Repository Interfaces)                     |
|          |                                                              |
|          v                                                              |
+-------------------------------------------------------------------------+
|      Data Layer (Repository Implementation, Room Database)              |
+-------------------------------------------------------------------------+
