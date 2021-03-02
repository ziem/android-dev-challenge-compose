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
package com.example.androiddevchallenge.feature.puppies

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.data.Puppy
import com.example.androiddevchallenge.ui.theme.TearDropShape
import dev.chrisbanes.accompanist.coil.CoilImage

@ExperimentalFoundationApi
@Composable
fun PuppiesScreen(
    puppiesViewModel: PuppiesViewModel = viewModel(),
    navController: NavHostController
) {
    val state by puppiesViewModel.puppies.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyVerticalGrid(
            GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp)
        ) {
            items(state) { puppy -> PuppyCell(puppy, navController) }
        }
    }
}

@Composable
fun PuppyCell(puppy: Puppy, navController: NavController) {
    Box(modifier = Modifier.padding(8.dp)) {
        Box(
            modifier = Modifier
                .shadow(4.dp, TearDropShape)
                .clickable { navController.navigate("puppy/${puppy.id}") }
        ) {
            CoilImage(
                puppy.imageUrl,
                "Image of ${puppy.name}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .background(Color.White)
                    .fillMaxWidth(),
                fadeIn = true
            )

            Text(
                text = puppy.name,
                fontSize = 22.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.primary.copy(alpha = 0.5f))
                    .padding(16.dp, 4.dp)
                    .align(Alignment.BottomEnd),
                color = Color.White,
                textAlign = TextAlign.End
            )
        }
    }
}
