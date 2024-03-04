import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun App() {
    document.getElementById("loading-text")?.remove()
    MaterialTheme {
        Scaffold(
            modifier = Modifier,
            topBar = {
                TopAppBar(
                    title = { Title() },
                    navigationIcon = {
                        Text(
                            text = "Home",
                            modifier = Modifier.clickable {
                                document.location?.replace("https://yamins.ir")
                            }
                        )
                    }
                )
            },
            content = {
                Surface(
                    content = {
                        Column(
                            modifier = Modifier.fillMaxWidth().padding(16.dp).verticalScroll(rememberScrollState()),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            content = {
                                Text(window.status)
                                Text("Page is under construction")
                                var showing by remember { mutableStateOf(false) }
                                Button(
                                    content = { Text("Don't click me") },
                                    onClick = { showing = !showing }
                                )
                                if (showing) {
                                    for (i in 1..1000) {
                                        Text("Page is under construction $i")
                                    }
                                }
                            }
                        )
                    }
                )
            }
        )
    }
}

@Preview
@Composable
private fun Title() {
    Text(
        text = "Blog",
        fontSize = 30.sp
    )
}