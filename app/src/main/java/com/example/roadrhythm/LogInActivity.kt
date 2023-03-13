package com.example.roadrhythm

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.roadrhythm.ui.theme.RoadRhythmTheme
import com.example.roadrhythm.ui.theme.Typography

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LogInActivity(authViewModel: AuthViewModel) {
    Scaffold(
        content = {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.login_background),
                    contentDescription = "Log In Background",
                    modifier = Modifier.fillMaxSize()
                )
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center
                ) {
                    Spacer(modifier = Modifier.height(325.dp))
                    Text(
                        text = "Let's get \nyou started.",
                        style = MaterialTheme.typography.h1,
                        textAlign = TextAlign.Left,
                        modifier = Modifier.paddingFromBaseline(top = 64.dp)
                    )
                    Spacer(modifier = Modifier.height(75.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center // added horizontal arrangement to center the button
                    ) {
                        Button(
                            onClick = { authViewModel.login() },
                            modifier = Modifier
                                .width(300.dp)
                                .height(50.dp),
                            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondaryVariant),
                            shape = MaterialTheme.shapes.large
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.spotify_logo),
                                    contentDescription = "Spotify Logo",
                                    modifier = Modifier.size(30.dp)
                                )
                                Spacer(Modifier.width(7.dp))
                                Text(
                                    text = "CONTINUE WITH SPOTIFY",
                                    style = Typography.body1
                                )
                            }
                        }
                    }
                }
            }
        }
    )
}

@Preview
@Composable
fun LogInActivityPreview() {
    val authViewModel = AuthViewModel()

    RoadRhythmTheme {
        LogInActivity(authViewModel)
    }
}