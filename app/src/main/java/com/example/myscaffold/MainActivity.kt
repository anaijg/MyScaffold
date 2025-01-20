package com.example.myscaffold

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.myscaffold.ui.theme.MyScaffoldTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ViewContainer()
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter") // no hagas caso del innerPadding
@Preview(showBackground = true)
@Composable
fun ViewContainer() {
    Scaffold(
        topBar = { Toolbar()},
        content = { Content() },
        floatingActionButton = { FAB()},
        floatingActionButtonPosition = FabPosition.End,
        bottomBar = {}
    )
}

@Preview(showBackground = true)
@Composable
fun FAB() {
    val context = LocalContext.current
    FloatingActionButton(onClick = { Toast.makeText(context, "Suscríbete", Toast.LENGTH_SHORT).show()}) {
        Text(text = "+")
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun Toolbar() {
    TopAppBar(
        title = { Text(text = "Profile") },
        modifier = Modifier.background(Color(0xFF6650a4))
    )
}

@Preview(showBackground = true)
@Composable
fun Content() {
    Text(
        text = "Hola caracola"

    )
}

@Preview(showBackground = true)
@Composable
fun ContentPreview() {
    MyScaffoldTheme {
        Content()
    }
}