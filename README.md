<h1 align="center"> WATCHOUT </h1></br>

<p align="center">
  <a href="https://android-arsenal.com/api?level=21"><img alt="MINIMUM API LEVEL" src="https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat"/></a>
</p>

<br>
<img src="/previews/preview0.jpg" alt="drawing" width="270px">
<img src="/previews/preview1.jpg" alt="drawing" width="270px">
<img src="/previews/preview2.jpg" alt="drawing" width="270px">
<img src="/previews/preview3.jpg" alt="drawing" width="270px"></br>
</p>

<br>
<img src="/previews/preview4.jpg" alt="drawing" width="270px">
<img src="/previews/preview5.jpg" alt="drawing" width="270px">
<img src="/previews/preview6.jpg" alt="drawing" width="270px">
<img src="/previews/preview7.jpg" alt="drawing" width="270px"></br>
</p>

A jetpack compose App consuming the STAR WARS API(Swapi) to help provide information about various aspects of STAR WARS

The purpose of this repository is to demonstrate below:
  - Working with the Star Wars API.
  - Implementing UI components with Jetpack Compose.
  - Implementation of Android architecture components with Jetpack libraries such as Hilt and Paging in Compose.
  - Handling threading with Kotlin Coroutines.
  - Handling different Modes(Dark/Light)

### Structural design pattern
The app is built with clean Architecture in mind leveraging structural pattern of MVVM (Model-View-ViewModel) where separation of concerns is key. The app consists of 3 layers
- WATCHOUT follow the official architecture guidance by Google
- With this approach each layer or package in the app has a different role/responsibility and sole reason is following the UDF(Unidirectional Data Flow)
- Architecture overview
  - DATA LAYERS - consists of repositories, which has the logics for accessing the data from the remote database or network with a principle of single source of truth.
  - DOMAIN LAYER - Is where all the business logic is, and acts as the bridge between DATA and PRESENTATION
  - PRESENTATION LAYER - Entails the UI elements that users can interact with and consists of viewModels that helps in managing the configuration changes

## Tech Stack and Libraries.
- Minimum SDK Level 21
- [Kotlin](https://developer.android.com/kotlin) - 100% Kotlin programming language. Google's first Android Development language.
- Jetpack Components:
    - [Jetpack Compose](https://developer.android.com/jetpack/compose) - Android’s modern toolkit for building native UI.
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) -The ViewModel class is designed to store and manage UI-related data in a lifecycle conscious way.
    - [Paging 3 library](https://developer.android.com/topic/libraries/architecture/paging/v3-overview) - 
    - [Dagger Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - A dependency injection library for Android, based on Annotations
    
- [Retrofit and Okhttp](https://square.github.io/retrofit) -  A REST client for Handling Network requests which provides responses in JSON
- [GSON](https://github.com/square/gson) - JSON Parser,used to parse requests on the data layer for Entities and understands Kotlin non-nullable and default parameters.
- [Kotlin Coroutines](https://developer.android.com/kotlin/coroutines) - A design pattern that help in handling concurrency simplifying how asynchronously is done.
- [Kotlin Flow](https://developer.android.com/kotlin/flow) - In coroutines, a flow is a type to sequentially emit multiple values.
- [Timber](https://github.com/JakeWharton/timber)- A logging library.
