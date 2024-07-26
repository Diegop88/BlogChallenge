# Blog challenge for Lovevery

### Architecture

This app uses the following patterns and architecture:

- MVVM
- Repository pattern
- Clean architecture

There are three principal layers:

##### UI

This layer contains Activities, ViewModels and Compose files, it uses ViewModelScope and MutableState.

##### Data

This layer contains all the logic of Retrofit to retrieve the information from the API, and include
the repository class.

##### Domain

This layer contains all business logic and transformation of data

### Trade Offs

All the Domain and Data classes are enabled to create unit testing and mocks

### How to run the code

This app contains the following frameworks:

- Kotlin
- Kotlin Coroutines
- Retrofit
- Koin
- Jetpack Compose
- Jetpack Compose Navigation

Min SDK is 24 and uses the latest build gradle version for Android Studio Koala.

### 3rd party libraries

This app uses the following 3rd party libraries:

- Retrofit
- Retrofit GSON Converter
- Logging Interceptor
- Koin
