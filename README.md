# Jetpack Compose.md

## Intro

Jetpack Compose is a suite of libraries within the AndroidX ecosystem. For more information, see our [project page](https://developer.android.com/jetpackcompose)

## Syntax

Jetpack Compose uses composable functions instead of XML layouts to define UI components. You can see this in action in the demos, like `androidx.ui.material.demos.ButtonDemo.kt`. More information can be found in the [compiler README](https://android.googlesource.com/platform/frameworks/support/+/androidx-master-dev/compose/README.md).

You may notice some parts of the codebase use an XML-like syntax. This was an exploration done early on in the project, and we have since decided to move away from it. Usages of this syntax will eventually be converted to use the standard kotlin DSL instead.

## Compiler
Composable functions are built using a custom Kotlin compiler plugin. More information about the compiler plugin is available in [this README](https://android.googlesource.com/platform/frameworks/support/+/androidx-master-dev/compose/README.md).

## Structure
### Current version
  
The version used right now is: 0.1.0-dev11 You can take a look at the file:

[dependencies.gradle](https://github.com/cpinan/Android-Jetpack-Compose-Documentation/blob/master/dependencies.gradle)

### Dependencies

The actual dependency prefix is: *androidx.ui*

For the compiler is: *androidx.compose*

Take a look here for more detail:

[dependencies.gradle](https://github.com/cpinan/Android-Jetpack-Compose-Documentation/blob/master/dependencies.gradle)

### Modules

Right now we have the following dependencies:

* compose-runtime: Mandatory to run the current compose version

* ui-framework: Module that collects all demos across ui and packages them into one demo APK

* ui-layout: Base components exposed by the system as building blocks. This includes Draw, Layout, Text, etc.

* ui-material: Basic layout components

* ui-tooling: Preview component

* ui-animation: Wrappers and adapters for existing Android Views

* ui-animation-core: Animation components

* ui-core: Internal declarations for the animations system

* ui-platform: Set of UI components built according to the Material spec

* ui-text: Testing framework

* ui-text-core: Base Text composable

* ui-text-android: Text engine that contains base text components

* ui-test: Internal implementation that allows separation of android implementation from host-side tests

## Examples

[Compose Basic](https://github.com/cpinan/Android-Jetpack-Compose-Documentation/tree/master/JetpackComposeBasics)

[Compose Live Preview Example based on setup guide](https://github.com/cpinan/Android-Jetpack-Compose-Documentation/tree/master/JetpackComposeLivePreview)

[Compose Example Based on the Flutter Tutorial](https://github.com/cpinan/Android-Jetpack-Compose-Documentation/tree/master/FlutterDesigninCompose)

[Gmail Compose Sample based on Droidcon](https://github.com/cpinan/Android-Jetpack-Compose-Documentation/tree/master/ComposeGmail)

[Compose Basic UI Test](https://github.com/cpinan/Android-Jetpack-Compose-Documentation/tree/master/TestBasicCompose)

[GoogleMaps on Compose](https://github.com/Naibeck/Android-Jetpack-Compose-Documentation/tree/mapview-compose/GoogleMapCompose)
### Cookbook

Still in progress, here you can take a look at the work in progress:

[Cookbook Compose](https://github.com/cpinan/Android-Jetpack-Compose-Documentation/tree/master/JetpackComposeCookbook)

### Design examples:


## References

[Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)

[Compose 0.1 DevFest Lima](https://github.com/cpinan/Android-Jetpack-Composer)

[Droidcon Become a Composer](https://www.droidcon.com/media-detail?video=412304809)

[Compose Samples - Google](https://github.com/android/compose-samples)

## Collaborate

If you find any issue or want to collaborate, please report or fork this repo.

Thanks for your collaboration to:

[Kevin Gomez](https://github.com/Naibeck)
