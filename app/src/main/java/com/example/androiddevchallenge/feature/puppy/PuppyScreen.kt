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
package com.example.androiddevchallenge.feature.puppy

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.Sex
import com.example.androiddevchallenge.data.Size
import com.example.androiddevchallenge.ui.theme.TearDropShape
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyScreen(puppyViewModel: PuppyViewModel) {
    val state = puppyViewModel.puppy.collectAsState()

    Box(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Column(modifier = Modifier.padding(32.dp)) {
            Box(
                modifier = Modifier
                    .shadow(4.dp, TearDropShape)
            ) {

                CoilImage(
                    state.value?.imageUrl!!,
                    "Image of ${state.value?.name}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .aspectRatio(1f)
                        .background(Color.White)
                        .fillMaxWidth(),
                    fadeIn = true
                )

                Text(
                    text = state.value?.name!!,
                    fontSize = 48.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = MaterialTheme.colors.primary.copy(alpha = 0.5f))
                        .padding(16.dp, 4.dp)
                        .align(Alignment.BottomEnd),
                    color = Color.White,
                    textAlign = TextAlign.End
                )
            }

            Spacer(modifier = Modifier.height(32.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    Modifier
                        .width(96.dp)
                        .height(96.dp)
                        .clip(TearDropShape)
                        .shadow(4.dp, TearDropShape)
                        .background(MaterialTheme.colors.secondary)
                ) {
                    Text(
                        text = state.value?.aga!!.toString(),
                        fontSize = 36.sp,
                        color = MaterialTheme.colors.onSecondary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )

                    Text(
                        text = "Age",
                        fontSize = 28.sp,
                        color = MaterialTheme.colors.onSecondary,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .padding(12.dp, 0.dp),
                        textAlign = TextAlign.Right
                    )
                }

                Box(
                    Modifier
                        .width(96.dp)
                        .height(96.dp)
                        .clip(TearDropShape)
                        .background(MaterialTheme.colors.secondary)
                ) {
                    val sex = if (state.value?.sex == Sex.Male) {
                        "M"
                    } else {
                        "F"
                    }
                    Text(
                        text = sex,
                        color = MaterialTheme.colors.onSecondary,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )

                    Text(
                        text = "Sex",
                        fontSize = 28.sp,
                        color = MaterialTheme.colors.onSecondary,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .padding(12.dp, 0.dp),
                        textAlign = TextAlign.Right
                    )
                }

                Box(
                    Modifier
                        .width(96.dp)
                        .height(96.dp)
                        .clip(TearDropShape)
                        .background(MaterialTheme.colors.secondary)
                ) {
                    val size = when (state.value?.size) {
                        Size.Small -> "S"
                        Size.Medium -> "M"
                        else -> "L"
                    }
                    Text(
                        text = size,
                        fontSize = 36.sp,
                        color = MaterialTheme.colors.onSecondary,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.align(Alignment.Center)
                    )

                    Text(
                        text = "Size",
                        fontSize = 28.sp,
                        color = MaterialTheme.colors.onSecondary,
                        modifier = Modifier
                            .align(Alignment.BottomCenter)
                            .fillMaxWidth()
                            .padding(12.dp, 0.dp),
                        textAlign = TextAlign.Right
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                fontSize = 22.sp,
                text =
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque dictum placerat est sed dictum. Suspendisse consectetur nisi semper consequat rutrum. Pellentesque efficitur, eros ac gravida rhoncus, augue leo placerat justo, ac fringilla nisl enim a odio. Vivamus vehicula euismod risus vitae ullamcorper. Morbi est dui, pharetra quis venenatis eu, malesuada eget elit. Aenean aliquet nisi eu eros volutpat, ac luctus eros feugiat. Donec faucibus interdum lectus vel suscipit. Aenean euismod libero at tellus posuere, in congue tellus egestas.\n" +
                    "\n" +
                    "Vestibulum in felis ut felis tincidunt auctor ut sit amet odio. In hac habitasse platea dictumst. Suspendisse varius, orci non blandit dictum, est lacus venenatis mauris, at ultrices urna mauris vel urna. Interdum et malesuada fames ac ante ipsum primis in faucibus. Duis interdum pellentesque fermentum. Ut ut porta enim. Cras quis ex feugiat, dapibus lectus eu, aliquet turpis.\n" +
                    "\n" +
                    "Morbi rutrum pellentesque urna, in consequat felis blandit et. Morbi tincidunt, est sed eleifend euismod, nulla ex suscipit odio, vitae varius sapien nisl ut odio. Morbi ullamcorper elit hendrerit, congue enim vel, posuere sapien. Integer convallis semper nibh, sed tempus nibh tristique quis. Cras sed vestibulum sapien, non vehicula ipsum. Cras tincidunt aliquam odio, vel mattis nisi lacinia dignissim. Integer hendrerit arcu vitae odio lacinia, et blandit justo condimentum. Ut at auctor eros. Aenean mattis mi vel magna scelerisque ornare.\n" +
                    "\n" +
                    "In tincidunt, ante non efficitur ornare, sem velit venenatis ante, in tristique sapien enim id ante. Sed ex justo, feugiat in leo at, dapibus convallis nibh. Etiam pharetra scelerisque erat, vitae ullamcorper ante commodo at. Mauris nec libero mauris. In vulputate egestas sem, pretium tempor tellus auctor eget. Maecenas suscipit arcu nec ligula mattis, suscipit maximus metus finibus. Suspendisse et turpis ut leo aliquam tincidunt in non neque. Vivamus lacinia leo ut lacus tristique pretium. In hac habitasse platea dictumst. Praesent commodo magna sit amet aliquam malesuada. Vivamus ultricies nibh non ante vestibulum dignissim.\n" +
                    "\n" +
                    "Donec facilisis in magna at auctor. Sed efficitur a nisi eu dapibus. Nullam mi ex, varius nec tincidunt eu, egestas vel nibh. Donec lacus ipsum, pretium commodo commodo ut, accumsan in felis. Praesent vitae malesuada erat. Sed sapien ex, tincidunt eu nisl in, congue tristique felis. Duis erat tellus, gravida eu ex nec, malesuada lacinia tellus. In hac habitasse platea dictumst. Ut molestie suscipit justo at mattis. Nam pulvinar neque sagittis tortor tempor convallis. Donec placerat gravida eros, nec commodo leo faucibus eu. Quisque dignissim lorem eu purus ultricies varius nec vel diam. Phasellus scelerisque sit amet orci non pharetra. Pellentesque sagittis lectus nec est dapibus, id eleifend ex porta. Morbi vitae enim eu lacus tempus sagittis. "
            )
        }
    }
}
