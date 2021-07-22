# SSJetPackComposeProgressButton
### _SSJetPackComposeProgressButton is an elegant button with a different loading animations._

[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)][git-repo-url] [![](https://jitpack.io/v/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton.svg)](https://jitpack.io/#SimformSolutionsPvtLtd/SSJetPackComposeProgressButton) [![Kotlin Version](https://img.shields.io/badge/Kotlin-v1.5.10-blue.svg)](https://kotlinlang.org) [![Platform](https://img.shields.io/badge/Platform-Android-green.svg?style=flat)](https://www.android.com/) [![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

## Features
- Android’s modern toolkit - Jetpack Compose support.
- Newly designed loading animation make your app attractive.
- Blinking icon button for your hot-feature.
- Button with text, right and left icon.
- Different types of state makes it easy to manage button. (Idle, Loading, Success, Failure)
- Fully customized button (Corner radius, background, colors, animation speed etc.)

# 🎬 Preview

| On Success | On Failure |
|--|--|
| ![](https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/main/gif/success.gif) | ![](https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/main/gif/failure.gif) |

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
	        implementation 'com.github.SimformSolutionsPvtLtd:SSJetPackComposeProgressButton:1.0.4'
	}
	```

## Usage
* Just use SSLoadingButton where you want button.

	```kotlin
        var submitButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
        SSJetPackComposeProgressButton(
            type = SSButtonType.CLOCK,
            width = 300.dp,
            height = 50.dp,
            onClick = {
                //Perform action on click of button and make it state to LOADING
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
### All Attributes
------------------------

| Attribute | Description | Default |
| --- | --- | --- |
| `type` | Choose type of animation from:[CIRCLE, WHEEL, ZOOM_IN_OUT_CIRCLE, CLOCK, SPIRAL] | None |
| `width` | Width to be applied to the button. | None |
| `height` | Height to be applied to the button. | None |
| `onClick` | Will be called when the user clicks the button. | None |
| `assetColor` | Color to be applied to icon and text inside button. | None |
| `buttonState` | Represent the state of button from IDLE, LOADING, SUCCESS, FAILIURE from SSButtonState. | None |
| `buttonBorderStroke` | Border to draw around the button. | None |
| `blinkingIcon` | Icon will be blink with size and color. | `false` |
| `cornerRadius` | Corner radius to be applied to the button. | `20` |
| `speedMillis` | Speed of the animation while changing the state. | `1000` |
| `enabled` | Controls the enabled state of the button. | `true` |
| `elevation` | It is used to resolve the elevation for this button in different. | `ButtonDefaults.elevation()` |
| `colors` | Colors that will be used to resolve the background and content color for this button in different states | `ButtonDefaults.buttonColors()` |
| `padding` | The spacing values to apply internally between the container and the content. | `PaddingValues(0.dp)` |
| `alphaValue` | The alpha of the drawn area. | `1f` |
| `leftImagePainter` | Painter to draw inside this left Icon. | `null` |
| `rightImagePainter` | Painter to draw inside this right Icon. | `null` |
| `successIconPainter` | Painter to draw inside this success state Icon. | `rememberVectorPainter(image = Icons.Default.Done)` |
| `failureIconPainter` | Painter to draw inside this failiure state Icon. | `rememberVectorPainter(image = Icons.Outlined.Info)` |
| `text` | The text to be displayed. | `null` |
| `textModifier` | To apply to this text layout node. | `Modifier` |
| `fontSize` | The size of glyphs to use when painting the text. | `TextUnit.Unspecified` |
| `fontStyle` | The typeface variant to use when drawing the letters (e.g., italic). | `null` |
| `fontFamily` | The font family to be used when rendering the text. | `null` |
| `fontWeight` | The typeface thickness to use when painting the text (e.g., [FontWeight.Bold]). | `null` |
| `hourHandColor` | Color will be apply to hour hand in clock type animation only. | `Color.Black` |
| `customLoadingIconPainter` | painter [Painter] to draw your custom loading icon. | `painterResource(id = R.drawable.simform_logo)` |
| `customLoadingEffect` | Custom loading animation type like roation, zoom in out etc. | `SSCustomLoadingEffect( rotation = false, zoomInOut = false, colorChanger = false)` |
| `customLoadingPadding` | Spacing between button border and loading icon. | `0` |

## Customization
* You can customize loading icon and animation effect according to your requirement.You can apply multiple animation effect from roationm, zoom-in-out and color changer.

	```kotlin
        var submitButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
        SSJetPackComposeProgressButton(
            type = SSButtonType.CLOCK,
            width = 300.dp,
            height = 50.dp,
            onClick = {
                //Perform action on click of button and make it state to LOADING
                submitButtonState = SSButtonState.LOADING
            },
            assetColor = Color.Red,
            buttonState = submitButtonState,
            successIconPainter = painterResource(id = R.drawable.custom_success),
            failureIconPainter = painterResource(id = R.drawable.custom_fail),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            padding = PaddingValues(six.dp),
            text = stringResource(id = R.string.simform),
            textModifier = Modifier.padding(ten.dp),
            fontWeight = FontWeight.Bold,
            leftImagePainter = painterResource(id = R.drawable.simform_logo),
            buttonBorderStroke = BorderStroke(two.dp, colorResource(id = R.color.pink)),
            customLoadingIconPainter = painterResource(id = R.drawable.simform_logo),
            customLoadingEffect = SSCustomLoadingEffect(
                rotation = false,
                zoomInOut = true,
                colorChanger = false
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

# 🎬 Custom loading animation

| On Success | On Failure |
|--|--|
| ![](https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/main/gif/custom_success.gif) | ![](https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/main/gif/custom_fail.gif) |


## Find this library useful? ❤️
Support it by joining __[stargazers]__ for this repository.⭐

## 🤝 How to Contribute

Whether you're helping us fix bugs, improve the docs, or a feature request, we'd love to have you! 💪
Check out our __[Contributing Guide]__ for ideas on contributing.

## Bugs and Feedback
For bugs, feature requests, and discussion please use __[GitHub Issues]__.

## License
```
Copyright 2021 Simform Solutions

 Licensed under the Apache License, Version 2.0 (the "License");
 you may not use this file except in compliance with the License.
 You may obtain a copy of the License at
    http://www.apache.org/licenses/LICENSE-2.0
 Unless required by applicable law or agreed to in writing, software
 distributed under the License is distributed on an "AS IS" BASIS,
 WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 See the License for the specific language governing permissions and limitations under the License.
```

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)
   [git-repo-url]: <https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton.git>
   [stargazers]: <https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/stargazers>
   [Contributing Guide]: <https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/blob/main/CONTRIBUTING.md>
   [GitHub Issues]: <https://github.com/SimformSolutionsPvtLtd/SSJetPackComposeProgressButton/issues>
