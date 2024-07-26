package dev.diegop88.blogchallenge.ui.postMessage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavController
import dev.diegop88.blogchallenge.ui.error.Error
import dev.diegop88.blogchallenge.utils.Navigation
import org.koin.androidx.compose.koinViewModel

@Composable
internal fun PostMessage(
    navController: NavController,
    viewModel: PostMessageViewModel = koinViewModel(),
) {
    var user by remember {
        mutableStateOf("Diego")
    }
    var subject by remember {
        mutableStateOf("")
    }
    var message by remember {
        mutableStateOf("")
    }

    val state = viewModel.postState

    when (state) {
        is PostState.Error -> Error(throwable = state.throwable)
        is PostState.Success -> {
            LaunchedEffect(Unit) {
                navController.navigate(Navigation.HOME)
            }
        }

        else -> Unit
    }

    Dialog(onDismissRequest = {}) {
        Card {
            Column(
                modifier = Modifier.padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                OutlinedTextField(
                    value = user,
                    placeholder = {
                        Text("User")
                    },
                    singleLine = true,
                    onValueChange = {
                        user = it
                    },
                )
                OutlinedTextField(
                    value = subject,
                    placeholder = {
                        Text("Subject")
                    },
                    singleLine = true,
                    onValueChange = {
                        subject = it
                    },
                )
                OutlinedTextField(
                    value = message,
                    placeholder = {
                        Text("Message")
                    },
                    singleLine = true,
                    onValueChange = {
                        message = it
                    },
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        modifier = Modifier.weight(1f),
                        onClick = { viewModel.postMessage(user, subject, message) }) {
                        if (state is PostState.Loading) {
                            CircularProgressIndicator(
                                modifier = Modifier
                                    .height(24.dp)
                                    .aspectRatio(1f),
                                color = Color.White,
                            )
                        } else {
                            Text("Post message")
                        }
                    }
                    Button(
                        modifier = Modifier.weight(1f),
                        enabled = state == PostState.IDLE,
                        onClick = { navController.navigate(Navigation.HOME) }) {
                        Text(text = "Cancel")
                    }
                }
            }
        }
    }
}
