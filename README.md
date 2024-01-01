# TodoDemoApp

<p align="center">
  <img src="./screenshot.png" width="300" />
</p>

## Medium Article

This project is accompanied by a Medium article that explains the implementation of a Todo App UI using Android Compose. You can read the article [here](https://medium.com/@kenruizinoue/intermediate-android-compose-todo-app-ui-1d808ef7882d).

## Overview

TodoDemoApp is an Android application built entirely using Jetpack Compose, focusing on demonstrating the capabilities of Compose in creating dynamic and interactive user interfaces. It showcases best practices in UI design and implementation, catering to both beginners and experienced developers.

The app utilizes Kotlin's robustness and Compose's flexibility to offer a user-friendly interface. Its design prioritizes adaptability and interactivity, with features like:

- Adaptive Color Scheme and Dynamic Icons: The UI dynamically changes colors and icons based on the Todo item's status, providing clear visual feedback to users.
- Interactive Elements with Ripple Effects: Enhances the user experience with interactive components that respond elegantly to user interactions.
- Modularized Composables: The app maintains a clean separation of concerns, with UI elements organized into distinct composables for easier management and scalability.

## Main Components

- Shared Resources: Centralized constants and icons for cohesive design.
- `TodoItemUi()`: Composable function for rendering individual Todo items with interactive features.
- `TodoInputBar()`: A combination of TextField and FloatingActionButton for task addition.
- `TodoItemsContainer()`: A LazyColumn setup to efficiently list and manage Todo items.

## Getting Started

1. Clone the repository to your local machine.
2. Open the project in Android Studio (preferably the latest version for full Compose support).
3. Run the app on an emulator or physical device to see the app in action.
