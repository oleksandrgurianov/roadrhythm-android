package com.example.roadrhythm

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectVerticalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ExitToApp
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeActivity(authViewModel: AuthViewModel, gestureControl: GestureControl) {
    val expanded = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .background(Color.Black)
            .fillMaxSize()
            .padding(16.dp)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {

                        // TODO: Implement playPause() function

                    },
                    onDoubleTap = {

                        // TODO: Implement playNext() function

                    },

                    // TODO: Replace with triple tap recognition function
                    onLongPress = {

                        // TODO: Implement playPrevious() function

                    }

                )
            }
            .pointerInput(Unit) {
                detectVerticalDragGestures(
                    onVerticalDrag = { change, dragAmount ->
                        gestureControl.adjustVolume(change, dragAmount)
                    }
                )
            }
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 32.dp)
        ) {
            Box(Modifier.padding(10.dp)) {
                IconButton(
                    onClick = { },
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colors.secondary,
                            shape = MaterialTheme.shapes.large
                        )
                        .size(50.dp)
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Settings,
                        contentDescription = "Settings Dropdown",
                        modifier = Modifier
                            .clip(MaterialTheme.shapes.large)
                            .combinedClickable(
                                onLongClick = {
                                    gestureControl.vibrate()
                                    expanded.value = !expanded.value
                                }
                            ) { }
                            .padding(10.dp)
                            .size(30.dp),
                        tint = MaterialTheme.colors.primaryVariant
                    )
                }
            }
            Box {
                DropdownMenu(
                    expanded = expanded.value,
                    onDismissRequest = { expanded.value = false },
                    modifier = Modifier
                        .background(color = MaterialTheme.colors.background)
                        .padding(10.dp, 2.dp),
                ) {
                    IconButton(
                        onClick = { expanded.value = !expanded.value },
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colors.secondary,
                                shape = MaterialTheme.shapes.large
                            )
                            .rotate(if (expanded.value) 30f else 0f)
                            .size(50.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Settings,
                            contentDescription = "Settings Button",
                            modifier = Modifier.size(30.dp),
                            tint = MaterialTheme.colors.primaryVariant
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    IconButton(
                        onClick = { },
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colors.secondary,
                                shape = MaterialTheme.shapes.large
                            )
                            .size(50.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Info,
                            contentDescription = "Info Button",
                            modifier = Modifier.size(30.dp),
                            tint = MaterialTheme.colors.primaryVariant
                        )
                    }
                    Spacer(modifier = Modifier.height(60.dp))
                    IconButton(
                        onClick = { authViewModel.logout() },
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colors.secondary,
                                shape = MaterialTheme.shapes.large
                            )
                            .size(50.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.ExitToApp,
                            contentDescription = "Log Out Button",
                            modifier = Modifier.size(30.dp),
                            tint = MaterialTheme.colors.primaryVariant
                        )
                    }
                }
            }
        }
    }
}

/*@Preview
@Composable
fun HomeActivityPreview() {
    val authViewModel = AuthViewModel()
    val gestureControl = GestureControl()

    RoadRhythmTheme {
        HomeActivity(authViewModel, gestureControl)
    }
}*/
