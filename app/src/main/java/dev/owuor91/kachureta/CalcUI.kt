package dev.owuor91.kachureta

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextAlign.Companion
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun CalcUI() {
  var num1 by remember { mutableStateOf("") }
  var num2 by remember { mutableStateOf("") }
  var result by remember { mutableStateOf("") }
  val operators = mutableListOf("+", "-", "*", "/")
  var err by remember { mutableStateOf("") }
  
  Column(modifier = Modifier.padding(16.dp)) {
    OutlinedTextField(
      value = num1,
      onValueChange = { num1 = it },
      label = { Text(text = "Number 1")},
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
      modifier = Modifier.fillMaxWidth()
    )
    if(err.isNotBlank()){
      Text(text = err, color = Color.Red, modifier = Modifier.align(Alignment.End))
    }
    
    Spacer(modifier = Modifier.height(8.dp))
    
    OutlinedTextField(
      value = num2,
      onValueChange = { num2 = it },
      label = { Text(text = "Number 2")},
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
      modifier = Modifier.fillMaxWidth()
    )
    if(err.isNotBlank()){
      Text(text = err, color = Color.Red, modifier = Modifier.align(Alignment.End))
    }
    
    Spacer(modifier = Modifier.height(8.dp))
    
    Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
      operators.forEach { operator->
        Button(onClick = {
          err = validateInput(num1, num2)
          if(err.isBlank()){
            result = calculate(num1, num2, operator)
          }
          
        }) {
          Text(text = operator)
        }
      }
    }
    Spacer(modifier = Modifier.height(16.dp))
    Text(text = result, textAlign = TextAlign.Center, color = Color.Black, fontSize = 22.sp, modifier = Modifier
      .align(Alignment.CenterHorizontally))
  }
}

fun calculate(num1: String, num2: String, operator: String): String{
  val n1 = num1.toDouble()
  val n2 = num2.toDouble()
  val calcRes = when(operator){
    "+" -> n1+n2
    "-" -> n1-n2
    "*" -> n1*n2
    "/" -> n1/n2
    else-> 0.0
  }
  return calcRes.toString()
}

fun validateInput(num1: String, num2: String): String{
  var error = ""
  if(num1.isBlank()){
    error = "num1 req"
  }
  if(num2.isBlank()){
    error = "num2 req"
  }
  return error
}