package dev.diegop88.blogchallenge.ui.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import dev.diegop88.blogchallenge.R

@Composable
fun SearchUser(
    onSearchUser: (String) -> Unit,
) {
    var searchValue by remember {
        mutableStateOf("")
    }
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = searchValue,
            singleLine = true,
            trailingIcon = {
                Icon(
                    modifier = Modifier.clickable { onSearchUser(searchValue) },
                    painter = painterResource(id = R.drawable.search), contentDescription = "Search"
                )
            },
            keyboardActions = KeyboardActions(onSearch = { onSearchUser(searchValue) }),
            placeholder = { Text("Search messages from user") },
            onValueChange = {
                searchValue = it
            },
        )
    }
}
