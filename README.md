# ImageLoadingNavigation

A modern Android application built with Jetpack Compose that demonstrates image loading and navigation.

## Screenshots

| Destinations | Gallery | Error State |
| :---: | :---: | :---: |
| <img src="https://github.com/user-attachments/assets/faf7c36a-b8a4-4e95-bf94-f2d03f551172" width="300" /> | <img src="https://github.com/user-attachments/assets/c6733425-2a7b-4d86-94ba-8eef116fce82" width="300" /> | <img src="https://github.com/user-attachments/assets/3452ef4c-eb0e-46cd-846c-2efd8270c79c" width="300" /> |

## Features

- **Jetpack Compose**: UI built entirely with modern declarative components.
- **Navigation**: Seamless transitions between screens using Compose Navigation.
- **Image Loading**: Efficient image fetching and caching using Coil.
- **Error Handling**: Graceful error states and feedback.

## Architecture

The project follows the **Clean Architecture** principles and is organized by features to ensure scalability, maintainability, and testability.

- **Presentation Layer**: Contains UI components (Jetpack Compose) and ViewModels.
- **Domain Layer**: Contains business logic, use cases, and repository interfaces.
- **Data Layer**: Implements repositories and handles data sources (Network, Local database, etc.).

## Package Structure

```text
com.johnkenedy.imageloadingnavigation
├── app                 # Application entry point, DI setup, and global navigation
├── core                # Shared UI components, themes, and base classes
└── gallery             # Gallery feature
    ├── data            # Repository implementations and data sources
    ├── domain          # Use cases, models, and repository interfaces
    ├── presentation    # UI screens, components, and ViewModels
    └── di              # Dependency injection modules for the gallery feature
```

## Tech Stack

- [Kotlin](https://kotlinlang.org/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Compose Navigation](https://developer.android.com/jetpack/compose/navigation)
- [Coil](https://coil-kt.github.io/coil/)
- [Koin](https://insert-koin.io/) (Dependency Injection)
- [Material 3](https://m3.material.io/)

## Getting Started

1. Clone the repository.
2. Open in Android Studio.
3. Build and run the app.
