package com.zarinraim.dicerollercompose

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.zarinraim.dicerollercompose.ui.theme.DiceRollerComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    DiceRoller(
                        onClickRollButton = { context ->
                            onCLickRollButton(context)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun DiceRoller(
    onClickRollButton: (Context) -> Unit = {}
) {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "1",
                fontSize = 30.sp
            )

            Button(onClick = {onClickRollButton(context)}) {
                Text(text = stringResource(id = R.string.roll))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DiceRollerComposeTheme {
        DiceRoller()
    }
}

private fun onCLickRollButton(context: Context) {
    Toast.makeText(context, "Buttons is clicked", Toast.LENGTH_LONG).show()
}
