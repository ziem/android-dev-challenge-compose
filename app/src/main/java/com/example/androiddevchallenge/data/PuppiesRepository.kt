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
package com.example.androiddevchallenge.data

import javax.inject.Inject

// TODO
class PuppiesRepository @Inject constructor() {
    suspend fun getPuppy(puppyId: Int): Puppy = getPuppies().find { it.id == puppyId }!!

    suspend fun getPuppies(): List<Puppy> = listOf(
        Puppy(1, "Cookie", "https://images.unsplash.com/photo-1591856419156-3979c9edd30f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=934&q=80"), // "https://images.unsplash.com/photo-1591856419156-3979c9edd30f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=934&q=80"
        Puppy(2, "Sky", "https://images.unsplash.com/photo-1591946614720-90a587da4a36?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80"),
        Puppy(3, "Apollo", "https://images.unsplash.com/photo-1591946532546-4160f60a5311?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80"),
        Puppy(4, "Rebel", "https://images.unsplash.com/photo-1591769225440-811ad7d6eab3?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80"),
        Puppy(5, "Rose", "https://images.unsplash.com/photo-1577447161356-a9e4dcca6964?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80"),
        Puppy(6, "Bingo", "https://images.unsplash.com/photo-1577175824945-ebc75a6b804e?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
        Puppy(7, "Radar", "https://images.unsplash.com/photo-1591768575198-88dac53fbd0a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
        Puppy(8, "Rambo", "https://images.unsplash.com/photo-1591703257157-da4ba2364b47?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80"),
        Puppy(9, "Zeus", "https://images.unsplash.com/photo-1591703025506-69e1f5611d93?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1351&q=80"),
        Puppy(10, "Bandit", "https://images.unsplash.com/photo-1577447217290-a609cd45101f?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80"),
        Puppy(11, "Rex", "https://images.unsplash.com/photo-1576873689386-2e0e972d7198?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80"),
        Puppy(12, "Smokey", "https://images.unsplash.com/photo-1576873600563-bd4dbc65d58d?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=634&q=80"),
        Puppy(13, "Lucky", "https://images.unsplash.com/photo-1577176062321-fd144393ba4c?ixid=MXwxMjA3fDB8MHxwcm9maWxlLXBhZ2V8NDN8fHxlbnwwfHx8&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"),
    )
}
