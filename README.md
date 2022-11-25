# WATCHOUT
A jetpack compose App consuming the STAR WARS API(Swapi) to help provide information about various aspects in STAR WARS

### Structural design pattern
The app is built with clean Architecture in mind leveraging structural pattern of MVVM (Model-View-ViewModel) where separation of concerns is key.
- Package/Folder Structure
  - data
  - domain
  - presentation
  - utils

## Tech Stack.
- [Kotlin](https://developer.android.com/kotlin) - Kotlin programming language. Google's first Android Development language.
- Jetpack Components:
    - [Jetpack Compose](https://developer.android.com/jetpack/compose) - Android’s modern toolkit for building native UI.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) -The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
    - [Paging 3 library](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) - 
    - [Room database](https://developer.android.com/training/data-storage/room) - provides an abstraction layer over SQLite.
    
- [Retrofit](https://square.github.io/retrofit) -  A REST client for Handling Network requests which provides responses in JSON
- [GSON](https://github.com/square/gson) - JSON Parser,used to parse requests on the data layer for Entities and understands Kotlin non-nullable and default parameters.
- [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) - A design pattern that help in handling concurrency simplifying how asynchronously is done.
- [Kotlin Flow](https://developer.android.com/kotlin/flow) - In coroutines, a flow is a type to sequentially emit multiple values.
- [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - A dependency injection library for Android, based on Annotations
- [Coil](https://coil-kt.github.io/coil/compose/)- A simple image loading library for Android with Kotlin Coroutines.
- [Timber](https://github.com/JakeWharton/timber)- A logging library.
