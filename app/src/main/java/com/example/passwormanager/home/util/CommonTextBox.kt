package com.example.chaintechnetwork.home.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.passwormanager.home.data.PasswordEntity
import com.example.passwormanager.home.pesentation.MainViewModel


@Composable
fun CommonTextBox(account: PasswordEntity,onClick:(PasswordEntity)->Unit) {
    val viewModel = hiltViewModel<MainViewModel>()
    val decryptedAccountName = viewModel.decrypt(account.accountName)
    val decryptedUserName = viewModel.decrypt(account.userName)
    val decryptedPassword = viewModel.decrypt(account.password)


    Card (
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .shadow(
                elevation = 8.dp,
                ambientColor = Color.Gray,
                shape = RoundedCornerShape(20),
                spotColor = Color.Blue
            ),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        ),
        content = {

            Row(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Row (
                    modifier = Modifier
                        .padding(25.dp)
                        .wrapContentSize(Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = decryptedAccountName, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold, color = Color.Black)
                    Spacer(modifier = Modifier.padding(8.dp))
                    val textlength = "*".repeat(decryptedPassword.length)
                    Text(text = textlength, fontWeight = FontWeight.ExtraBold, color = Color.DarkGray)
                }
                Box(
                    modifier = Modifier.padding(16.dp),
                    contentAlignment = Alignment.Center,
                ) {
                    IconButton(onClick = { onClick(account) }) {
                        Icon(imageVector = Icons.Default.KeyboardArrowRight, contentDescription = "open", tint = Color.Black)

                    }
                }

            }
        }
    )

}