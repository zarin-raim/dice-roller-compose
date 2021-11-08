package com.zarinraim.dicerollercompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.zarinraim.dicerollercompose.ui.theme.DiceRollerComposeTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    DiceRoller()
                }
            }
        }
    }
}

@Composable
fun DiceRoller(
) {
    val rolledDice = remember { mutableStateOf(1) }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val painter = remember { mutableStateOf(R.drawable.empty_dice) }

            Image(
                painter = painterResource(id = painter.value),
                contentDescription = "rolled ${rolledDice.value}"
            )

            Button(onClick = {
                rolledDice.value = Random.nextInt(DICE_SIDES) + 1
                painter.value = when (rolledDice.value) {
                    DICE_1 -> R.drawable.dice_1
                    DICE_2 -> R.drawable.dice_2
                    DICE_3 -> R.drawable.dice_3
                    DICE_4 -> R.drawable.dice_4
                    DICE_5 -> R.drawable.dice_5
                    DICE_6 -> R.drawable.dice_6
                    else -> R.drawable.empty_dice
                }
            }) {
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

private const val DICE_SIDES = 6
private const val DICE_1 = 1
private const val DICE_2 = 2
private const val DICE_3 = 3
private const val DICE_4 = 4
private const val DICE_5 = 5
private const val DICE_6 = 6
