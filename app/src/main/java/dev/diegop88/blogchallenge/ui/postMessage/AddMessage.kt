package dev.diegop88.blogchallenge.ui.postMessage

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import dev.diegop88.blogchallenge.R

@Composable
internal fun AddMessage(
    onClick: () -> Unit,
) {
    Box {
        FloatingActionButton(onClick = onClick) {
            Icon(
                painter = painterResource(id = R.drawable.add_message),
                contentDescription = "Add new message"
            )
        }
    }
}
