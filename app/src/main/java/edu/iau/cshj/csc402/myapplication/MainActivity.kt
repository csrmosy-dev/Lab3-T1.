package edu.iau.cshj.csc402.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.iau.cshj.csc402.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lab3Task1Screen()
                }
            }
        }
    }
}

@Composable
fun Lab3Task1Screen(modifier: Modifier = Modifier) {
    var isFollowing by remember { mutableStateOf(false) }
    var followersCount by remember { mutableStateOf(120) }

    val navy = Color(0xFF0B2545)
    val androidGreen = Color(0xFF3DDC84)
    val screenBackground = Color(0xFFF4F7FA)
    val cardWhite = Color(0xFFFFFFFF)
    val textGrey = Color(0xFF6B7A8F)
    val chipGreenBg = Color(0xFFDDF6E8)
    val chipGreenFg = Color(0xFF1E9E5A)

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(screenBackground)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(navy)
                .padding(horizontal = 20.dp, vertical = 16.dp)
        ) {
            Text(text = "CSC 402 Lab 3", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = "Task 1 - User Profile & State", color = Color(0xFFB8C4D6), fontSize = 12.sp)
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(3.dp)
                .background(androidGreen)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = cardWhite),
                elevation = CardDefaults.cardElevation(defaultElevation = 3.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(80.dp)
                            .clip(CircleShape)
                            .background(navy),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "RM",
                            color = Color.White,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Text(
                        text = "Rimas Al-Otaibi",
                        color = navy,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Software Engineering Student\nIAU University",
                        color = textGrey,
                        fontSize = 14.sp,
                        textAlign = TextAlign.Center
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Box(
                        modifier = Modifier
                            .background(chipGreenBg, shape = RoundedCornerShape(50))
                            .padding(horizontal = 16.dp, vertical = 6.dp)
                    ) {
                        Text(
                            text = "Followers: $followersCount",
                            color = chipGreenFg,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Button(
                        onClick = {
                            if (isFollowing) {
                                isFollowing = false
                                followersCount -= 1
                            } else {
                                isFollowing = true
                                followersCount += 1
                            }
                        },
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (isFollowing) textGrey else androidGreen,
                            contentColor = if (isFollowing) Color.White else navy
                        )
                    ) {
                        Text(
                            text = if (isFollowing) "Following" else "Follow",
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }
}