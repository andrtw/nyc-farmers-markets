package com.andrtw.nycfarmersmarkets.feature.detail.util

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import kotlin.math.roundToInt

class DottedShape(val step: Dp) : Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val stepPx = with(density) { step.toPx() }
            val stepsCount = (size.width / stepPx).roundToInt()
            val stepWidth = size.width / stepsCount
            val dotSize = Size(width = stepWidth / 2, height = size.height)

            for (i in 0 until stepsCount) {
                addRect(
                    Rect(
                        offset = Offset(x = i * stepWidth, y = 0f),
                        size = dotSize,
                    )
                )
            }

            close()
        }
        return Outline.Generic(path)
    }
}
