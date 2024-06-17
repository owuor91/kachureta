package dev.owuor91.kachureta

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      CalcUI()
    }
  }
}

@Composable
fun MyOutlinedTextField(lbl: String) {
  var text by remember { mutableStateOf("") }
  OutlinedTextField(
    value = text,
    onValueChange = { text = it },
    label = { Text(text = lbl) },
    modifier = Modifier
      .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp)
      .fillMaxWidth(),
    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
  )
  
}

@Preview(showBackground = true)
@Composable
fun previewOutLine(){
  MyOutlinedTextField(lbl = "First Num")
}

