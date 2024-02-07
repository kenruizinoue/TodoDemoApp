# TodoDemoApp

<p align="center">
  <img src="./screenshot.png" width="300" />
</p>

## Medium Article

This project is accompanied by a comprehensive Medium article that details the process of integrating UI Tests into a Todo App using Android Compose. You can read the article [here](https://medium.com/deuk/todo-app-series-mastering-ui-tests-with-jetpack-compose-and-dagger-hilt-19e8c3352559).

## Overview

TodoDemoApp is an Android application developed with Jetpack Compose and Room Database, showcasing advanced Android app development techniques. Includes Hilt for dependency injection, significantly improving the architecture and testability of the app.

Key aspects of the project now include:

- **Integration of Room Database for Persistent Data Storage**: Utilizing Room Database for robust data persistence, essential for maintaining app state.
- **Implementation of ViewModel**: Managing UI-related data in a lifecycle-conscious way with ViewModel, ensuring data persistence across configuration changes.
- **Usage of Kotlin Coroutines Flow**: Employing Kotlin coroutines Flow for efficient database operations, enhancing app responsiveness.
- **Incorporation of Hilt for Dependency Injection**: Enhancing the app's architecture and testing capabilities by integrating Hilt, enabling more maintainable code and isolated testing environments.
- **Comprehensive UI Testing with Android Compose**: Detailed UI testing implementation, improved with Hilt for dependency injection, offering a step-by-step guide on writing and running isolated UI tests.
- **Strategic Use of Test Tags and Content Descriptions in Compose**: Demonstrating test tags and content descriptions within Compose for UI component identification in tests.


## Getting Started

1. Clone the repository to your local machine.
2. Open the project in Android Studio (preferably the latest version for full Compose support).
3. Run the app on an emulator or physical device to see the app in action.

## License

MIT License

Copyright (c) [2024] [Ken Ruiz Inoue]

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.