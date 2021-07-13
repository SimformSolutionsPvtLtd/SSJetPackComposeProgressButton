package com.simform.ssloadingbuttonandroid

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class JoinButton {
    @Composable
    fun JoinButton(onClick: (Boolean) -> Unit = {}) {

    }

    enum class JoinButtonState {
        IDLE,
        PRESSED
    }

    @Preview
    @Composable
    fun JoinButtonPreview() {
        JoinButton(onClick = {})
    }

}