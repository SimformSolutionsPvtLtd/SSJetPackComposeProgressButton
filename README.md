![alt text](https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/main/gif/banner.png)

# SSJetPackComposeProgressButton
### _SSJetPackComposeProgressButton is an elegant button with a different loading animations which makes your app attractive._

[![CI Status](https://img.shields.io/github/v/release/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton?style=flat)](https://travis-ci.org/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton) [![](https://jitpack.io/v/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton.svg)](https://jitpack.io/#SimformSolutionsPvtLtd/SSJetPackComposeProgressButton) [![Kotlin Version](https://img.shields.io/badge/Kotlin-v2.0.0-blue.svg)](https://kotlinlang.org) [![Platform](https://img.shields.io/badge/Platform-Android-green.svg?style=flat)](https://www.android.com/) [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21) [![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-SSJetPackComposeProgressButton-green.svg?style=flat )]( https://android-arsenal.com/details/1/8302 )

## Features
- Android’s modern toolkit - Jetpack Compose support.
- Newly designed loading animation make your app attractive.
- Blinking icon button for your hot-feature.
- Button with text, right and left icon.
- Different types of state makes it easy to manage button. (Idle, Loading, Success, Failure)
- Fully customized button (Corner radius, background, colors, animation speed etc.)
- Customize button loading animation with your logo and special animation effect.
- Supports displaying GIFs via URL or local file in the button's loading state.
- Supports swipe to animate buttons.

# 🎬 Preview

| On Success                                                                                                                                                                                                                                                                                    | On Failure                                                                                                                                                                                                                                                                                    |
|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <a href="https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/579c837bbb3a9d3d11523368c96229dac6a9e287/app/src/main/java/com/simform/ssjetpackcomposeprogressbutton/base/BaseProgressButton.kt#L30" target="_blank"><img src="/gif/success.gif" height="850px"/></a> | <a href="https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/579c837bbb3a9d3d11523368c96229dac6a9e287/app/src/main/java/com/simform/ssjetpackcomposeprogressbutton/base/BaseProgressButton.kt#L30" target="_blank"><img src="/gif/failure.gif" height="850px"/></a> |

# 🎬 Swipeable Buttons

| On Success                                                                                                                                                                                                                                                                                                           | On Failure                                                                                                                                                                                                                                                                                                           |
|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <a href="https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/579c837bbb3a9d3d11523368c96229dac6a9e287/app/src/main/java/com/simform/ssjetpackcomposeprogressbutton/base/BaseSwipeAbleProgressButton.kt#L30" target="_blank"><img src="/gif/swipeToAnimateSuccess.gif" height="450px"/></a> | <a href="https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/579c837bbb3a9d3d11523368c96229dac6a9e287/app/src/main/java/com/simform/ssjetpackcomposeprogressbutton/base/BaseSwipeAbleProgressButton.kt#L30" target="_blank"><img src="/gif/swipeToAnimateFailure.gif" height="450px"/></a> |

# 🎬 Customized loading animation

| On Success                                                                                                                                                                                                                                                                                                 | On Failure                                                                                                                                                                                                                                                                                              |
|------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| <a href="https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/579c837bbb3a9d3d11523368c96229dac6a9e287/app/src/main/java/com/simform/ssjetpackcomposeprogressbutton/base/BaseCustomProgressButton.kt#L27" target="_blank"><img src="/gif/custom_success.gif" height="450px"/></a> | <a href="https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/579c837bbb3a9d3d11523368c96229dac6a9e287/app/src/main/java/com/simform/ssjetpackcomposeprogressbutton/base/BaseCustomProgressButton.kt#L27" target="_blank"><img src="/gif/custom_fail.gif" height="450px"/></a> |

## Installation
1. Add it in your root build.gradle at the end of repositories:

	```groovy
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
	```

* Add the dependency in your app's build.gradle file

	```groovy
	dependencies {
	        implementation 'com.github.SimformSolutionsPvtLtd:SSJetPackComposeProgressButton:<LATEST_TAG>'
	}
	```

## Usage
* Just use SSJetPackComposeProgressButton where you want button.

	```kotlin
    var submitButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    SSJetPackComposeProgressButton(
        type = SSButtonType.CLOCK,
        width = 300.dp,
        height = 50.dp,
        onClick = {
            //Perform action on click of button and make it's state to LOADING
            submitButtonState = SSButtonState.LOADING
        },
        assetColor = Color.Red,
        buttonState = submitButtonState
    )
	```
	```kotlin
	// On Success change submitButtonState to success state
    submitButtonState = SSButtonState.SUCCESS
	```
	```kotlin
    // On Failure change submitButtonState to failure state
    submitButtonState = SSButtonState.FAILIURE
	```
## Migration guide from release [v1.0.9](https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/releases/tag/1.0.9)
- Added support displaying GIFs via URL or local file in the button's loading state. 
- Added `blinkingIconColor` to animate with your custom color.
- You can now apply different tints by using these updated variables:
  `leftImageIconTintColor`
  `rightImageTintColor`
  `successIconTintColor`
  `failureIconTintColor`
  These variables allow you to customize tints as per your specific requirements, while defaulting to `null` if not specified.
- Changed default `cornerRadius` value to `0` from `20`.
- Renamed `blinkingIcon` to `isBlinkingIcon` in `SSJetPackComposeProgressButton`.
- Renamed `colorChanger` in `fadeInOut` in `SSCustomLoadingEffect`.
- Removed `buttonBorderStroke` and instead use `buttonBorderWidth`, `buttonBorderColor` and
  `animatedButtonBorderColor` to offer more control over button borders.
- Removed default values for `successIconPainter` and `failureIconPainter` and set to `null` to offer 
  more control over what is displayed when animation is completed.
- Removed default value for `customLoadingIconPainter` and set to `null` to offer
  more control over what is displayed when animation is in progress.

## Customization
* You can customize loading icon and animation effect according to your requirement.You can apply 
multiple animation effect from rotation, zoom-in-out and fade-in-out too.

	```kotlin

    var submitButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    SSJetPackComposeProgressButton(
                    type = SSButtonType.CUSTOM,
                    width = 480.dp,
                    height = 60.dp,
                    onClick = {
                        //Perform action on click of button and make it's state to LOADING
                        submitButtonState = SSButtonState.LOADING
                        CoroutineScope(Dispatchers.Default).launch {
                            // Do your heavy work once completed show success or failure
                            delay(2000) 
                            submitButtonState = SSButtonState.SUCCESS
                        }
                    },
                    cornerRadius = 20,
                    assetColor = Color.Red,
                    buttonState = submitButtonState,
                    successIconPainter = rememberVectorPainter(image = Icons.Default.Done),
                    successIconTintColor = LIGHT_PINK,
                    failureIconPainter = rememberVectorPainter(image = Icons.Outlined.Info),
                    failureIconTintColor = LIGHT_PINK,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    padding = PaddingValues(12.dp),
                    text = stringResource(id = R.string.app_name),
                    textModifier = Modifier.padding(10.dp),
                    fontWeight = FontWeight.Bold,
                    leftImagePainter = painterResource(id = R.drawable.baby_pink_android),
                    isBlinkingIcon = true,
                    blinkingIconColor = Color.White,
                    buttonBorderWidth = 3.dp,
                    animatedButtonBorderColor = LIGHT_PINK,
                    buttonBorderColor = LIGHT_PINK,
                    customLoadingIconPainter = painterResource(id = R.drawable.baby_pink_android),
                    customLoadingEffect = SSCustomLoadingEffect(
                        zoomInOut = true,
                    )
                )
	```
	```kotlin
	// On Success change submitButtonState to success state
    submitButtonState = SSButtonState.SUCCESS
	```
	```kotlin
    // On Failure change submitButtonState to failure state
    submitButtonState = SSButtonState.FAILIURE
	```

### All Attributes
------------------------

| Attribute                               | Description                                                                                                                                                    | Default                                                                             |
|-----------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------|
| `type`                                  | Choose type of animation from:[CIRCLE, WHEEL, ZOOM_IN_OUT_CIRCLE, CLOCK, SPIRAL, CUSTOM]                                                                       | None                                                                                |
| `width`                                 | Width to be applied to the button.                                                                                                                             | None                                                                                |
| `height`                                | Height to be applied to the button.                                                                                                                            | None                                                                                |
| `onClick`                               | Will be called when the user clicks the button.                                                                                                                | None                                                                                |
| `assetColor`                            | Color to be applied to icon and text inside button.                                                                                                            | None                                                                                |
| `buttonState`                           | Represent the state of button from IDLE, LOADING, SUCCESS, FAILIURE from SSButtonState.                                                                        | None                                                                                |
| `buttonBorderWidth`                     | Border width to draw around the button.                                                                                                                        | `0.dp`                                                                              |
| `buttonBorderColor`                     | Border color to be applied around the button.                                                                                                                  | `0.dp`                                                                              |
| `animatedButtonBorderColor`             | Border color to be applied around the button when button is in LOADING state.                                                                                  | `0.dp`                                                                              |
| `isBlinkingIcon`                        | Icon will be blink with size and color.                                                                                                                        | `false`                                                                             |
| `blinkingIconColor`                     | Color which will be used with Icon tintColor when `isBlinkingIcon` is enabled.                                                                                 | `null`                                                                              |
| `cornerRadius`                          | Corner radius to be applied to the button.                                                                                                                     | `20`                                                                                |
| `speedMillis`                           | Speed of the animation while changing the state.                                                                                                               | `1000`                                                                              |
| `enabled`                               | Controls the enabled state of the button.                                                                                                                      | `true`                                                                              |
| `elevation`                             | It is used to resolve the elevation for this button in different.                                                                                              | `ButtonDefaults.elevatedButtonElevation()`                                          |
| `colors`                                | Colors that will be used to resolve the background and content color for this button in different states                                                       | `ButtonDefaults.buttonColors()`                                                     |
| `padding`                               | The spacing values to apply internally between the container and the content.                                                                                  | `PaddingValues(0.dp)`                                                               |
| `alphaValue`                            | The alpha of the drawn area.                                                                                                                                   | `1f`                                                                                |
| `leftImagePainter`                      | Painter to draw inside this left Icon.                                                                                                                         | `null`                                                                              |
| `leftImageTintColor`                    | Color to be applied to left image.                                                                                                                             | `null`                                                                              |
| `rightImagePainter`                     | Painter to draw inside this right Icon.                                                                                                                        | `null`                                                                              |
| `rightImageTintColor`                   | Color to be applied to right image.                                                                                                                            | `null`                                                                              |
| `successIconPainter`                    | Painter to draw inside this success state Icon.                                                                                                                | `null`                                                                              |
| `successIconTintColor`                  | Color to be applied to success icon.                                                                                                                           | `null`                                                                              |
| `failureIconPainter`                    | Painter to draw inside this failure state Icon.                                                                                                                | `null`                                                                              |
| `failureIconTintColor`                  | Color to be applied to failure icon.                                                                                                                           | `null`                                                                              |
| `text`                                  | The text to be displayed.                                                                                                                                      | `null`                                                                              |
| `textModifier`                          | To apply to this text layout node.                                                                                                                             | `Modifier`                                                                          |
| `fontSize`                              | The size of glyphs to use when painting the text.                                                                                                              | `TextUnit.Unspecified`                                                              |
| `fontStyle`                             | The typeface variant to use when drawing the letters (e.g., italic).                                                                                           | `null`                                                                              |
| `fontFamily`                            | The font family to be used when rendering the text.                                                                                                            | `null`                                                                              |
| `fontWeight`                            | The typeface thickness to use when painting the text (e.g., [FontWeight.Bold]).                                                                                | `null`                                                                              |
| `hourHandColor`                         | Color will be apply to hour hand in clock type animation only.                                                                                                 | `Color.Black`                                                                       |
| `customLoadingIconPainter`              | painter [Painter] to draw your custom loading icon.                                                                                                            | `painterResource(id = R.drawable.simform_logo)`                                     |
| `customLoadingEffect`                   | Custom loading animation type like roation, zoom in out etc.                                                                                                   | `SSCustomLoadingEffect( rotation = false, zoomInOut = false, colorChanger = false)` |
| `customLoadingPadding`                  | Spacing between button border and loading icon.                                                                                                                | `0.dp`                                                                              |
| `shouldAutoMoveToIdleState`             | In case of success/failure state after defined time it move back to idle state.                                                                                | `true`                                                                              |
| `swipeAbleButtonPadding`                | Spacing for swipeAble button icon.                                                                                                                             | `true`                                                                              |
| `swipeAbleButtonThreshold`              | Threshold for swipe button, once this threshold will reach it will consider button as loading state based on `shouldAutomateSwipeToAnimate`.                   | `0.5f`                                                                              |
| `shouldAutomateSwipeToAnimate`          | Based on this it will determine if button should move to loading state once `swipeAbleButtonThreshold` has been reached or should wait for user to stop swipe. | `false`                                                                             |
| `onSwipeAbleButtonDragPercentageUpdate` | This will give callback of the progress update when the swipe is in progress.                                                                                  | None                                                                                |
| `onSwiped`                              | This will give callback once swipe is reached at threshold and button moves to loading state.                                                                  | None                                                                                |

## Our JetPackCompose Sample
[SSComposeCookBook](https://github.com/SimformSolutionsPvtLtd/SSComposeCookBook) :  A Collection of major Jetpack compose UI components which are commonly used.

## Find this library useful? ❤️
Support it by joining __[stargazers]__ for this repository.⭐

## How to Contribute🤝

Whether you're helping us fix bugs, improve the docs, or a feature request, we'd love to have you! 💪
Check out our __[Contributing Guide]__ for ideas on contributing.

## Bugs and Feedback
For bugs, feature requests, and discussion please use __[GitHub Issues]__.

## Medium Blog
For more info go to __[Progress Button using JetPack Compose : SSJetPackComposeProgressButton](https://medium.com/simform-engineering/progress-button-using-jetpack-compose-ssjetpackcomposeprogressbutton-fbc187d1370e)__

## Awesome Mobile Libraries
- Check out our other available [awesome mobile libraries](https://github.com/SimformSolutionsPvtLtd/Awesome-Mobile-Libraries)

## License
Distributed under the MIT License. See [LICENSE](https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/main/LICENSE) for details.

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)
   [git-repo-url]: <https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton.git>
   [stargazers]: <https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/stargazers>
   [Contributing Guide]: <https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/main/CONTRIBUTING.md>
   [GitHub Issues]: <https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/issues>
