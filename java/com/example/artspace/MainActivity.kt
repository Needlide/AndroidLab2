package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ArtSpace()
                }
            }
        }
    }
}

@Composable
fun ArtSpace(modifier: Modifier = Modifier) {
    val images = listOf<Int>(R.drawable.image1, R.drawable.image2/*, R.drawable.image3, R.drawable.image4*/)
    val imagesText = listOf<String>("Description1", "Description2", "Description3", "Description4")
    
    var index by remember { mutableStateOf(0) }

    Column(modifier = Modifier.padding(8.dp))
    {
        Image(painter = painterResource(images[index]), contentDescription = "")

        Card (modifier = Modifier.padding(8.dp)) {
            Text(text = imagesText[index])
        }
        
        Row {
          Button(onClick = {
              if (index == 0) {
                  index = (images.size - 1)
              }
              else
                  index--
          }) {
              Text(text = "Previous")
          }
            Button(onClick = {
                if(index == (images.size - 1)) {
                    index = 0
                }
                else
                    index++
            }) {
                Text(text = "Next")
            }
        }
    }
}

