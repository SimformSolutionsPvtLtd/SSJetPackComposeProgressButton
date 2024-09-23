package com.simform.ssjetpackcomposeprogressbuttonlibrary

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size

/**
 * @param data Set the data to load.
 * @param drawable Set the placeholder drawable to use when the request starts.
 **/
@Composable
fun gifPainter(data: Any?, drawable: Drawable?): Painter {
    val context = LocalContext.current
    val imageLoader = remember {
        ImageLoader.Builder(context)
            .components {
                if (SDK_INT >= Build.VERSION_CODES.P) {
                    add(ImageDecoderDecoder.Factory())
                } else {
                    add(GifDecoder.Factory())
                }
            }
            .build()
    }

    return rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data(data)
            .placeholder(drawable)
            .size(Size.ORIGINAL)
            .build(),
        imageLoader = imageLoader
    )
}