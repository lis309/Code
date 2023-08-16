package co.edu.sena.basicscodelab

import android.app.BackgroundServiceStartNotAllowedException
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.edu.sena.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                Myapp(modifier = Modifier.fillMaxSize())
                // A surface container using the 'background' color from the theme
                /*Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MessageCard("Android")
                }//Surface*/
            }//BasicsCodelabTheme
        }//setContent
    }//onCreate
}//MainActivity

@Composable
fun OnboardingScreen(modifier: Modifier = Modifier) {
    // TODO: This state should be hoisted
    var shouldShowOnboarding by remember { mutableStateOf(true) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Welcome to the Basics Codelab!")
        Button(
            modifier = Modifier.padding(vertical = 24.dp),
            onClick = { shouldShowOnboarding = false }
        ) {
            Text("Continue")
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun OnboardingPreview() {
    BasicsCodelabTheme {
        OnboardingScreen()
    }
}

@Composable
private fun Myapp(modifier: Modifier = Modifier, names: List<String> = listOf("World","Compose")){
    Column(modifier = modifier.padding(vertical = 4.dp)) {
        for (name in names){
            MessageCard(name = name)
        }//for
    }//Column
    /*Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        MessageCard("Android")
    }//Surface*/
}//Myapp

@Composable
fun MessageCard(name: String) {

    val expanded = remember { mutableStateOf(false) }
    val extraPadding = if (expanded.value) 48.dp else 0.dp

    Surface(color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column (modifier = Modifier.weight(1f).padding(bottom = extraPadding) /*modifier = Modifier.fillMaxWidth().padding()*/) {
                Text(text = "Hello, ")
                Text(text = name)
            }//Column
            ElevatedButton(onClick = { expanded.value = !expanded.value }) {
                Text(if (expanded.value) "Show less" else "show more")
            }
        }//Row
    }//Surface
}//MessageCard

@Preview(showBackground = true,  widthDp = 320)
@Composable
fun Preview() {
    BasicsCodelabTheme {
        Myapp()
        //MessageCard("Android")
    }
}//DefaultPreview