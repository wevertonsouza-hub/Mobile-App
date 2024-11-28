import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Home() {
    var dolar by remember { mutableStateOf("")
    }

    var real by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = Color.Blue
            ) {
                Text(
                    text = "Conversor de Moeda",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = "5,94 Real Brasileiro",
                fontSize = 25.sp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 20.dp, top = 50.dp)
            )

            Text(
                text = "Última atualização · 27 de novembro às 22:00 UTC",
                fontSize = 14.sp,
                modifier = Modifier.padding(start = 20.dp, top = 10.dp, end = 20.dp)
            )

            OutlinedTextField(
                value = dolar,
                onValueChange = { dolar = it

                    if (dolar.isEmpty()){
                        dolar = ""
                        real = ""
                    }else{
                        val valorConvertido = dolar.toDouble() * 5.94
                        real = valorConvertido.toString()
                    }


                },
                label = { Text("Dólar Americano") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.DarkGray,
                    cursorColor = Color.Blue,
                    backgroundColor = Color.White,
                    focusedLabelColor = Color.DarkGray,
                    textColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                maxLines = 1,
                textStyle = TextStyle(
                    fontSize = 18.sp
                )
            )

            OutlinedTextField(
                value = real,
                onValueChange = { real = it
                },
                label = { Text("Real Brasileiro") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Blue,
                    unfocusedBorderColor = Color.DarkGray,
                    cursorColor = Color.Blue,
                    backgroundColor = Color.White,
                    focusedLabelColor = Color.DarkGray,
                    textColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                maxLines = 1,
                textStyle = TextStyle(
                    fontSize = 18.sp
                )
            )
        }
    }
}
