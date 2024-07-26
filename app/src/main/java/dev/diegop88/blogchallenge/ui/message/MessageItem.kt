package dev.diegop88.blogchallenge.ui.message

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.diegop88.blogchallenge.domain.models.Message

@Composable
fun MessageItem(message: Message) {
    Card {
        Column(modifier = Modifier.padding(8.dp)) {
            Text(message.message, style = MaterialTheme.typography.labelLarge)
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(message.subject, style = MaterialTheme.typography.bodySmall)
                Text(message.user, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
