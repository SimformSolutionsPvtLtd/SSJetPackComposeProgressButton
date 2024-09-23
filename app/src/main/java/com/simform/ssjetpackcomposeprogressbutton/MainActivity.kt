package com.simform.ssjetpackcomposeprogressbutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simform.ssjetpackcomposeprogressbutton.utils.COMMON_BORDER_WIDTH
import com.simform.ssjetpackcomposeprogressbutton.utils.COMMON_CORNER_RADIUS
import com.simform.ssjetpackcomposeprogressbutton.utils.COMMON_HEIGHT
import com.simform.ssjetpackcomposeprogressbutton.utils.COMMON_WIDTH
import com.simform.ssjetpackcomposeprogressbutton.utils.FONT_SIZE
import com.simform.ssjetpackcomposeprogressbutton.utils.TOP_BUTTON_HEIGHT
import com.simform.ssjetpackcomposeprogressbutton.utils.TOP_BUTTON_RADIUS
import com.simform.ssjetpackcomposeprogressbutton.utils.FORTY
import com.simform.ssjetpackcomposeprogressbutton.utils.ONE_FLOAT
import com.simform.ssjetpackcomposeprogressbutton.utils.TWELVE
import com.simform.ssjetpackcomposeprogressbutton.utils.TWO
import com.simform.ssjetpackcomposeprogressbutton.utils.ZERO
import com.simform.ssjetpackcomposeprogressbuttonlibrary.R.drawable
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonState
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSButtonType
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSCustomLoadingEffect
import com.simform.ssjetpackcomposeprogressbuttonlibrary.SSJetPackComposeProgressButton
import com.simform.ssjetpackcomposeprogressbuttonlibrary.utils.ten

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SSLoadingButtonExample()
        }
    }
}

@Composable
fun SSLoadingButtonExample() {
    var roundedProgressState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var wheelState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var zoomInOutState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var clockState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var roundedProgressState2: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var spiralState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var ssTextButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var textWithRightButton: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var textWithIconState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var blinkingIcon: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var customRotationButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var customZoomButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }
    var customEffectButtonState: SSButtonState by remember { mutableStateOf(SSButtonState.IDLE) }

    Column {
        Spacer(modifier = Modifier.size((TWELVE * TWO).dp))
        Row(
            Modifier
                .padding(ZERO.dp, ZERO.dp, ZERO.dp, FORTY.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = {
                    roundedProgressState = SSButtonState.SUCCESS
                    wheelState = SSButtonState.SUCCESS
                    zoomInOutState = SSButtonState.SUCCESS
                    clockState = SSButtonState.SUCCESS
                    roundedProgressState2 = SSButtonState.SUCCESS
                    spiralState = SSButtonState.SUCCESS
                    ssTextButtonState = SSButtonState.SUCCESS
                    textWithIconState = SSButtonState.SUCCESS
                    textWithRightButton = SSButtonState.SUCCESS
                    blinkingIcon = SSButtonState.SUCCESS
                    customRotationButtonState = SSButtonState.SUCCESS
                    customZoomButtonState = SSButtonState.SUCCESS
                    customEffectButtonState = SSButtonState.SUCCESS
                },
                modifier = Modifier
                    .padding(TWELVE.dp)
                    .weight(ONE_FLOAT)
                    .height(TOP_BUTTON_HEIGHT.dp),shape = RoundedCornerShape(TOP_BUTTON_RADIUS.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.light_blue)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.on_success),
                    color = Color.White,
                    fontSize = FONT_SIZE.sp
                )
            }
            Button(
                onClick = {
                    roundedProgressState = SSButtonState.FAILURE
                    wheelState = SSButtonState.FAILURE
                    zoomInOutState = SSButtonState.FAILURE
                    clockState = SSButtonState.FAILURE
                    roundedProgressState2 = SSButtonState.FAILURE
                    spiralState = SSButtonState.FAILURE
                    ssTextButtonState = SSButtonState.FAILURE
                    textWithIconState = SSButtonState.FAILURE
                    textWithRightButton = SSButtonState.FAILURE
                    blinkingIcon = SSButtonState.FAILURE
                    customRotationButtonState = SSButtonState.FAILURE
                    customEffectButtonState = SSButtonState.FAILURE
                    customZoomButtonState = SSButtonState.FAILURE
                },
                modifier = Modifier
                    .padding(TWELVE.dp)
                    .weight(1f)
                    .height(TOP_BUTTON_HEIGHT.dp),shape = RoundedCornerShape(TOP_BUTTON_RADIUS.dp),
                elevation = ButtonDefaults.elevatedButtonElevation(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.light_blue)
                )
            ) {
                Text(
                    text = stringResource(id = R.string.on_failure),
                    color = Color.White,
                    fontSize = FONT_SIZE.sp
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .scrollable(
                    state = ScrollableState { 0f },
                    orientation = Orientation.Vertical,
                    enabled = true
                )
                .padding(0.dp, 0.dp, 10.dp, 0.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            //Various example of SSLoadingButton
            item {
                SSJetPackComposeProgressButton(
                    assetColor = colorResource(id = R.color.pink),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    buttonBorderStroke = BorderStroke(
                        COMMON_BORDER_WIDTH.dp,
                        SolidColor(colorResource(id = R.color.pink))
                    ),
                    type = SSButtonType.CIRCLE,
                    onClick = { roundedProgressState2 = SSButtonState.LOADING },
                    buttonState = roundedProgressState2,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    padding = PaddingValues(TWELVE.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Home),
                    shouldAutoMoveToIdleState = false
                )
                SSJetPackComposeProgressButton(
                    assetColor = colorResource(id = R.color.pink),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    buttonBorderStroke = BorderStroke(
                        COMMON_BORDER_WIDTH.dp, SolidColor(colorResource(id = R.color.pink))
                    ),
                    type = SSButtonType.WHEEL,
                    onClick = { wheelState = SSButtonState.LOADING },
                    buttonState = wheelState,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    padding = PaddingValues(TWELVE.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
                )
                SSJetPackComposeProgressButton(
                    assetColor = colorResource(id = R.color.pink),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    buttonBorderStroke = BorderStroke(
                        COMMON_BORDER_WIDTH.dp,
                        SolidColor(colorResource(id = R.color.pink))
                    ),
                    type = SSButtonType.ZOOM_IN_OUT_CIRCLE,
                    onClick = { zoomInOutState = SSButtonState.LOADING },
                    buttonState = zoomInOutState,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    padding = PaddingValues(TWELVE.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
                )
                SSJetPackComposeProgressButton(
                    assetColor = colorResource(id = R.color.pink),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    buttonBorderStroke = BorderStroke(
                        COMMON_BORDER_WIDTH.dp,
                        SolidColor(colorResource(id = R.color.pink))
                    ),
                    type = SSButtonType.CLOCK,
                    onClick = { clockState = SSButtonState.LOADING },
                    buttonState = clockState,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    padding = PaddingValues(TWELVE.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
                )
                SSJetPackComposeProgressButton(
                    assetColor = colorResource(id = R.color.pink),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    buttonBorderStroke = BorderStroke(
                        COMMON_BORDER_WIDTH.dp,
                        SolidColor(colorResource(id = R.color.pink))
                    ),
                    type = SSButtonType.SPIRAL,
                    onClick = { spiralState = SSButtonState.LOADING },
                    buttonState = spiralState,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    padding = PaddingValues(TWELVE.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Home)
                )
                SSJetPackComposeProgressButton(
                    assetColor = Color.White,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.pink),
                        disabledContainerColor = colorResource(id = R.color.pink)
                    ),
                    type = SSButtonType.CIRCLE,
                    onClick = { roundedProgressState = SSButtonState.LOADING },
                    buttonState = roundedProgressState,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    padding = PaddingValues(TWELVE.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Person)
                )
                SSJetPackComposeProgressButton(
                    assetColor = Color.Yellow,
                    type = SSButtonType.CLOCK,
                    onClick = { blinkingIcon = SSButtonState.LOADING },
                    buttonState = blinkingIcon,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    blinkingIcon = true,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.FavoriteBorder),
                    padding = PaddingValues(TWELVE.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.pink),
                        disabledContainerColor = colorResource(id = R.color.pink)
                    ),
                    hourHandColor = colorResource(id = R.color.handColor)
                )
                SSJetPackComposeProgressButton(
                    assetColor = Color.White,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.pink),
                        disabledContainerColor = colorResource(id = R.color.pink)
                    ),
                    type = SSButtonType.ZOOM_IN_OUT_CIRCLE,
                    onClick = { ssTextButtonState = SSButtonState.LOADING },
                    buttonState = ssTextButtonState,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    padding = PaddingValues(TWELVE.dp),
                    text = stringResource(id = R.string.stylish_text),
                    fontStyle = FontStyle.Italic,
                    fontSize = FONT_SIZE.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Monospace,
                    cornerRadius = COMMON_CORNER_RADIUS,
                    textModifier = Modifier.padding(TWELVE.dp),
                )
                SSJetPackComposeProgressButton(
                    assetColor = Color.White,
                    type = SSButtonType.WHEEL,
                    onClick = { textWithIconState = SSButtonState.LOADING },
                    buttonState = textWithIconState,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    leftImagePainter = rememberVectorPainter(image = Icons.Default.Star),
                    text = stringResource(id = R.string.left_icon),
                    fontFamily = FontFamily.SansSerif,
                    textModifier = Modifier.padding(TWELVE.dp),
                    fontSize = FONT_SIZE.sp,
                    fontWeight = FontWeight.Bold,
                    blinkingIcon = true,
                    padding = PaddingValues(TWELVE.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.pink),
                        disabledContainerColor = colorResource(id = R.color.pink)
                    )
                )
                SSJetPackComposeProgressButton(
                    assetColor = Color.White,
                    type = SSButtonType.SPIRAL,
                    onClick = { textWithRightButton = SSButtonState.LOADING },
                    buttonState = textWithRightButton,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    rightImagePainter = rememberVectorPainter(image = Icons.Default.Star),
                    text = stringResource(id = R.string.right_icon),
                    fontFamily = FontFamily.Serif,
                    textModifier = Modifier.padding(TWELVE.dp),
                    fontSize = FONT_SIZE.sp,
                    fontWeight = FontWeight.Bold,
                    padding = PaddingValues(TWELVE.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.pink),
                        disabledContainerColor = colorResource(id = R.color.pink)
                    )
                )
                Spacer(modifier = Modifier.size(COMMON_HEIGHT.dp))
                SSJetPackComposeProgressButton(
                    type = SSButtonType.CUSTOM,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    onClick = { customRotationButtonState = SSButtonState.LOADING },
                    assetColor = colorResource(id = R.color.pink),
                    buttonState = customRotationButtonState,
                    successIconPainter = painterResource(id = R.drawable.custom_success),
                    failureIconPainter = painterResource(id = R.drawable.custom_fail),
                    customLoadingEffect = SSCustomLoadingEffect(
                        rotation = true,
                        zoomInOut = false,
                        colorChanger = false
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    padding = PaddingValues(TWELVE.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    text = stringResource(id = R.string.simform),
                    textModifier = Modifier.padding(ten.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = FONT_SIZE.sp,
                    leftImagePainter = painterResource(id = drawable.simform_logo),
                    buttonBorderStroke = BorderStroke(
                        COMMON_BORDER_WIDTH.dp,
                        colorResource(id = R.color.pink)
                    )
                )
                SSJetPackComposeProgressButton(
                    type = SSButtonType.CUSTOM,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    onClick = { customZoomButtonState = SSButtonState.LOADING },
                    assetColor = colorResource(id = R.color.pink),
                    buttonState = customZoomButtonState,
                    successIconPainter = painterResource(id = R.drawable.custom_success),
                    failureIconPainter = painterResource(id = R.drawable.custom_fail),
                    customLoadingEffect = SSCustomLoadingEffect(
                        rotation = false,
                        zoomInOut = true,
                        colorChanger = false
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    padding = PaddingValues(TWELVE.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    text = stringResource(id = R.string.simform),
                    textModifier = Modifier.padding(ten.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = FONT_SIZE.sp,
                    leftImagePainter = painterResource(id = drawable.simform_logo),
                    buttonBorderStroke = BorderStroke(
                        COMMON_BORDER_WIDTH.dp,
                        colorResource(id = R.color.pink)
                    )
                )
                SSJetPackComposeProgressButton(
                    type = SSButtonType.CUSTOM,
                    width = COMMON_WIDTH.dp,
                    height = COMMON_HEIGHT.dp,
                    onClick = { customEffectButtonState = SSButtonState.LOADING },
                    assetColor = colorResource(id = R.color.pink),
                    buttonState = customEffectButtonState,
                    successIconPainter = painterResource(id = R.drawable.custom_success),
                    failureIconPainter = painterResource(id = R.drawable.custom_fail),
                    customLoadingEffect = SSCustomLoadingEffect(
                        rotation = false,
                        zoomInOut = false,
                        colorChanger = true
                    ),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White,
                        disabledContainerColor = Color.White
                    ),
                    padding = PaddingValues(ten.dp),
                    cornerRadius = COMMON_CORNER_RADIUS,
                    text = stringResource(id = R.string.simform),
                    textModifier = Modifier.padding(ten.dp),
                    fontWeight = FontWeight.Bold,
                    fontSize = FONT_SIZE.sp,
                    successIconColor = colorResource(id = R.color.dark_green),
                    failureIconColor = colorResource(id = R.color.colorPrimaryDark),
                    leftImagePainter = painterResource(id = drawable.simform_logo),
                    buttonBorderStroke = BorderStroke(
                        COMMON_BORDER_WIDTH.dp,
                        colorResource(id = R.color.pink)
                    )
                )
                Spacer(modifier = Modifier.size(COMMON_WIDTH.dp))
                Spacer(modifier = Modifier.size(COMMON_WIDTH.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SSLoadingButtonExample()
}