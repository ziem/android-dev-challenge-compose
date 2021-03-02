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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.feature.puppies.PuppiesScreen
import com.example.androiddevchallenge.feature.puppies.PuppiesViewModel
import com.example.androiddevchallenge.feature.puppy.PuppyScreen
import com.example.androiddevchallenge.feature.puppy.PuppyViewModel
import com.example.androiddevchallenge.ui.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@ExperimentalFoundationApi
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Scaffold(topBar = {
            TopAppBar(title = {
                Row {
                    Image(painter = painterResource(id = R.drawable.ic_pets), contentDescription = "Pets icon")
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "Woof!")
                }
            })
        }, content = {
            NavGraph()
        })
    }
}

@ExperimentalFoundationApi
@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "puppies") {
        composable("puppies") { backStackEntry ->
            val puppiesViewModel: PuppiesViewModel =
                viewModel(null, HiltViewModelFactory(LocalContext.current, backStackEntry))
            PuppiesScreen(puppiesViewModel, navController)
        }
        composable(
            "puppy/{puppyId}",
            arguments = listOf(navArgument("puppyId") { type = NavType.IntType })
        ) { backStackEntry ->
            val puppyViewModel: PuppyViewModel = viewModel(null, HiltViewModelFactory(LocalContext.current, backStackEntry))
            PuppyScreen(puppyViewModel)
        }
    }
}

@ExperimentalFoundationApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@ExperimentalFoundationApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}