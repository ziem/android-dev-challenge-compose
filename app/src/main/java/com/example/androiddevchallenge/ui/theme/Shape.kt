/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.theme

import androidx.compose.foundation.shape.GenericShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.unit.dp

val shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(4.dp),
    large = RoundedCornerShape(0.dp)
)

val TearDropShape = GenericShape { size, _ ->
    arcTo(
        rect = Rect(
            Offset(x = 0f, y = 0f),
            Size(width = size.width, height = size.height)
        ),
        startAngleDegrees = -270f,
        sweepAngleDegrees = 270f,
        forceMoveTo = false
    )

    lineTo(size.width, size.height)

    arcTo(
        rect = Rect(
            Offset(size.width - 128f, size.height - 128f),
            Size(128f, 128f)
        ),
        startAngleDegrees = 0f,
        sweepAngleDegrees = 90f,
        forceMoveTo = false
    )
}