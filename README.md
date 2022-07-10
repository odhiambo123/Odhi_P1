# Implement Basic_CRUD
##
- Implement CRUD
- Have a list
- List requirements:
  - Have a title
  - Search and sort
  - Data must load from backend (API endpoint)
  - Pagination
  - Click on list item -> show detail view
  - While list is loading -> show loader
  - If list is empty -> let user know is empty
- Form Requirement:
  - Must have a title
  - Every field must have a label
  - Field level validation
  - let user know if what's being typed is what is expected
  - can use text field next to field (red: error)
  - Disable submit button once clicked
  - Add a "BACK" or "CANCEL" button
  - Add a "CLEAR" button to clear form

- Add form level validation to make sure all required fields are filled out
- On submission of the form, once response is received add a response Toast
- Uniformity - all items follow same format to make sure its consistent


# Ongoing Goals for the project

## Tech stack & Open-source libraries

- Minimum SDK level 21
- [Kotlin](https://kotlinlang.org/) based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- [Hilt](https://dagger.dev/hilt/) for dependency injection.
- Jetpack
  - Lifecycle - Observe Android lifecycles and handle UI states upon the lifecycle changes.
  - ViewModel - Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
  - DataBinding - Binds UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
  - Room Persistence - Constructs Database by providing an abstraction layer over SQLite to allow fluent database access.
- Architecture
  - MVVM Architecture (View - DataBinding - ViewModel - Model)
  - [Bindables](https://github.com/skydoves/bindables) - Android DataBinding kit for notifying data changes to UI layers.
  - Repository Pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - Construct the REST APIs.
- [Sandwich](https://github.com/skydoves/Sandwich) - Construct a lightweight and modern response interface to handle network payload for Android.
- [Moshi](https://github.com/square/moshi/) - A modern JSON library for Kotlin and Java.
- [Glide](https://github.com/bumptech/glide), [GlidePalette](https://github.com/florent37/GlidePalette) - Loading images from network.
- [TransformationLayout](https://github.com/skydoves/transformationlayout) - implementing transformation motion animations.
- [WhatIf](https://github.com/skydoves/whatif) - Check nullable objects and empty collections more fluently.
- [Bundler](https://github.com/skydoves/bundler) - Android Intent & Bundle extensions, which insert and retrieve values elegantly.
- [Timber](https://github.com/JakeWharton/timber) - A logger with a small, extensible API.
- [Material-Components](https://github.com/material-components/material-components-android) - Material design components for building ripple animation, and CardView.
- [Turbine](https://github.com/cashapp/turbine) - A small testing library for kotlinx.coroutines Flow.
- Custom Views
  - [Rainbow](https://github.com/skydoves/rainbow) - An easy way to apply gradations and tinting for Android.
  - [AndroidRibbon](https://github.com/skydoves/androidribbon) - A simple way to implement a  beautiful ribbon with the shimmering on Android.
  - [ProgressView](https://github.com/skydoves/progressview) - A polished and flexible ProgressView, fully customizable with animations.
