# Jetpack Compose.md

# Intro

Jetpack Compose is a suite of libraries within the AndroidX ecosystem. For more information, see our [project page](https://developer.android.com/jetpackcompose)

## Syntax

Jetpack Compose uses composable functions instead of XML layouts to define UI components. You can see this in action in the demos, like `androidx.ui.material.demos.ButtonDemo.kt`. More information can be found in the [compiler README](https://android.googlesource.com/platform/frameworks/support/+/androidx-master-dev/compose/README.md).

You may notice some parts of the codebase use an XML-like syntax. This was an exploration done early on in the project, and we have since decided to move away from it. Usages of this syntax will eventually be converted to use the standard kotlin DSL instead.

## Compiler
Composable functions are built using a custom Kotlin compiler plugin. More information about the compiler plugin is available in [this README](https://android.googlesource.com/platform/frameworks/support/+/androidx-master-dev/compose/README.md).

## Structure
### Current version
### Namespace
### Modules
# Examples
# Cookbook
# References

[Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)

# Collaborate

If you find any issue or want to collaborate, please report or fork this repo.
