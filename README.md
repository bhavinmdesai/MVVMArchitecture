# MVVM Architecture

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.3.72-blue.svg)](https://kotlinlang.org)
[![AGP](https://img.shields.io/badge/AGP-4.0.1-blue?style=flat)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-6.5.1-blue?style=flat)](https://gradle.org)


This is a sample project that presents a modern, 2020 approach to
[Android](https://en.wikipedia.org/wiki/Android_(operating_system)) application development with MVVM design pattern and eventually up to date tech-stack.

The goal of the project is to demonstrate modern Android application
[Architecture](#architecture) that is modular, scalable, maintainable, and testable. This application may look quite simple,
but it has all of these small details that will set the rock-solid foundation for the larger app suitable for bigger teams
and long [application lifecycle](https://en.wikipedia.org/wiki/Application_lifecycle_management).

This project is being maintained to match current industry standards.

## Project characteristics

This project brings to table set of best practices, tools, and solutions:

* 100% [Kotlin](https://kotlinlang.org/)
* Model-View-ViewModel
* [Android Jetpack](https://developer.android.com/jetpack)
* A single-activity architecture (Coming soon) ([Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started))
* Reactive UI
* CI pipeline (Coming soon) ([GitHub Actions](https://github.com/features/actions))
* Unit Testing (Coming soon)
* Dependency Injection
* Material design

## Tech-stack

Min API level is set to [`21`](https://android-arsenal.com/api?level=21), so the presented approach is suitable for over
[94% of devices](https://developer.android.com/about/dashboards) running Android. This project takes advantage of many
popular libraries and tools of the Android ecosystem. Most of the libraries are in the stable version unless there is a
good reason to use non-stable dependency.

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations
    * [Koin](https://insert-koin.io/) - dependency injection
    * [Retrofit](https://square.github.io/retrofit/) - networking
    * [Jetpack](https://developer.android.com/jetpack)
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
        * [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
  *   [Coil](https://github.com/coil-kt/coil) - image loading library with Kotlin idiomatic API

## Getting started

There are a few ways to open this project.

### Android Studio

1. Android Studio -> File -> New -> From Version control -> Git
2. Enter `https://github.com/bhavinmdesai/MVVMArchitecture` into URL field

### Command-line + Android Studio

1. Run `https://github.com/bhavinmdesai/MVVMArchitecture`
2. Android Studio -> File -> Open

## Inspiration

This is project is a sample, to inspire you and should handle basic cases, but please take a look at
additional resources.

### Cheat sheet

* [Android Ecosystem Cheat Sheet](https://github.com/igorwojda/android-ecosystem-cheat-sheet) - board containing 200+ most important tools
* [Kotlin Coroutines - Use Cases on Android](https://github.com/LukasLechnerDev/Kotlin-Coroutine-Use-Cases-on-Android) - most popular coroutine usages

### Android projects

Other high-quality projects will help you to find solutions that work for your project:

* [Iosched](https://github.com/google/iosched) - official Android application from google IO 2019
* [Android Architecture Blueprints v2](https://github.com/googlesamples/android-architecture) - a showcase of various
  Android architecture approaches
* [Android sunflower](https://github.com/googlesamples/android-sunflower) complete `Jetpack` sample covering all
  libraries
* [GithubBrowserSample](https://github.com/googlesamples/android-architecture-components) - multiple small projects
  demonstrating usage of Android Architecture Components
* [Plaid](https://github.com/android/plaid) - a showcase of Android material design
* [Clean Architecture boilerplate](https://github.com/bufferapp/android-clean-architecture-boilerplate) - contains nice
  diagrams of Clean Architecture layers
* [Android samples](https://github.com/android) - official Android samples repository
* [Roxie](https://github.com/ww-tech/roxie) - solid example of `common state` approach together witch very good
  documentation
* [Kotlin Android template](https://github.com/cortinico/kotlin-android-template) - template that lets you create an Android/Kotlin project and be up and running in a few seconds. 

## Author

[![Follow me](https://img.shields.io/twitter/follow/bhavinmdesai?style=social)](https://twitter.com/bhavinmdesai)