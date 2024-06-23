package com.example.passwormanager.home.pesentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.chaintechnetwork.home.util.CommonInfoBox
import com.example.chaintechnetwork.home.util.CommonTextBox
import com.example.chaintechnetwork.home.util.CommonTextField
import com.example.chaintechnetwork.home.util.PasswordInfoBox
import com.example.chaintechnetwork.home.util.PasswordTextField
import com.example.passwormanager.home.data.PasswordEntity
import com.example.passwormanager.ui.theme.BlueTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {

    var modelSheetbtn by remember { mutableStateOf(false) }
    var editModelSheetbtn by remember { mutableStateOf(false) }
    var alertDiaglog by remember { mutableStateOf(false) }
    var inputAccountName by remember { mutableStateOf("") }
    var inputUserName by remember { mutableStateOf("") }
    var inputPassword by remember { mutableStateOf("") }

    val viewModel = hiltViewModel<MainViewModel>()
    val allPassword = viewModel.passwordList.collectAsState().value
    var currentPasssword = remember {
        mutableStateOf(PasswordEntity("", "", ""))
    }

    var editinputAccountName by remember { mutableStateOf("") }
    var editinputUserName by remember { mutableStateOf("") }
    var editinputPassword by remember { mutableStateOf("") }


    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                modifier = Modifier
                    .padding(bottom = 30.dp)
                    .padding(horizontal = 10.dp),
                containerColor = BlueTheme,
                onClick = { modelSheetbtn = true }
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "add password")
            }
        }, topBar = {
            TopAppBar(title = { Text(text = "Password Manager") })
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier.padding(paddingValues)
        ) {
            items(allPassword) { passswords ->
                CommonTextBox(passswords) {
                    currentPasssword.value = it
                    editModelSheetbtn = true
                    editinputAccountName = viewModel.decrypt(currentPasssword.value.accountName)
                    editinputUserName= viewModel.decrypt( currentPasssword.value.userName)
                    editinputPassword= viewModel.decrypt( currentPasssword.value.password)

                }

            }
        }

        if (viewModel.loading.value){
            Box(
                modifier = Modifier.fillMaxSize().zIndex(1F)
                    .wrapContentSize(Alignment.Center)
            ){
                CircularProgressIndicator()
            }

        }

        if (modelSheetbtn) {
            ModalBottomSheet(onDismissRequest = {
                modelSheetbtn = false
                inputPassword = ""
                inputAccountName = ""
                inputUserName = ""


            }) {
                CommonTextField(
                    inputext = inputAccountName,
                    "Account Name",
                    onChange = { inputAccountName = it })
                CommonTextField(
                    inputext = inputUserName,
                    "Username",
                    onChange = { inputUserName = it })
                PasswordTextField(
                    inputext = inputPassword,
                    "Password",
                    onChange = { inputPassword = it })
                Button(
                    onClick = {
                        val encryptedAccountName = viewModel.encrypt(inputAccountName)
                        val encryptedUserName = viewModel.encrypt(inputUserName)
                        val encryptedPassword = viewModel.encrypt(inputPassword)
                        viewModel.AddPassword(
                            PasswordEntity(
                                encryptedAccountName,
                                encryptedUserName,
                                encryptedPassword

                            )
                        )
                        inputPassword = ""
                        inputAccountName = ""
                        inputUserName = ""

                        modelSheetbtn = false
                    },
                    modifier = Modifier
                        .padding(horizontal = 20.dp, vertical = 10.dp)
                        .padding(bottom = 35.dp)
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = MaterialTheme.shapes.extraLarge,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    )
                ) {
                    Text(
                        text = "Add New Account",
                        color = Color.White,
                        fontWeight = FontWeight.ExtraBold,
                        fontSize = 20.sp
                    )
                }
            }
        }
        if (editModelSheetbtn) {
            ModalBottomSheet(onDismissRequest = { editModelSheetbtn = false }) {

                val decryptedAccountName = viewModel.decrypt( currentPasssword.value.accountName)
                val decryptedUserName = viewModel.decrypt( currentPasssword.value.userName)
                val decryptedPassword = viewModel.decrypt( currentPasssword.value.password)

                Column(
                    modifier = Modifier.padding(horizontal = 40.dp)
                ) {
                    Text(
                        text = "Account Details",
                        fontSize = 20.sp,
                        color = BlueTheme,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    CommonInfoBox("Account Name",decryptedAccountName)
                    CommonInfoBox("Username/Email",decryptedUserName)
                    PasswordInfoBox("Password",decryptedPassword)

                }


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Button(
                        onClick = {
                            alertDiaglog = true
                        },
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                            .padding(bottom = 35.dp)
                            .height(50.dp)
                            .width(150.dp),
                        shape = MaterialTheme.shapes.extraLarge,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Black
                        )
                    ) {
                        Text(
                            text = "Edit",
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp
                        )
                    }
                    Button(
                        onClick = {
                            viewModel.Delete(
                                PasswordEntity(
                                    id = currentPasssword.value.id,
                                    accountName = viewModel.decrypt(currentPasssword.value.accountName),
                                    userName = viewModel.decrypt(currentPasssword.value.userName),
                                    password = viewModel.decrypt(currentPasssword.value.password)
                                )
                            )
                            editModelSheetbtn = false
                        },
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                            .padding(bottom = 35.dp)
                            .width(150.dp)
                            .height(50.dp),
                        shape = MaterialTheme.shapes.extraLarge,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Red
                        )
                    ) {
                        Text(
                            text = "Delete",
                            color = Color.White,
                            fontWeight = FontWeight.ExtraBold,
                            fontSize = 20.sp
                        )
                    }
                }

            }
        }


        if (alertDiaglog) {

            AlertDialog(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(5),
                onDismissRequest = {
                    alertDiaglog = false
                    editinputPassword = ""
                    editinputAccountName = ""
                    editinputUserName = ""
                },
                text = {
                    Column {
                        Text(
                            text = "Account Details",
                            fontSize = 20.sp,
                            color = BlueTheme,
                            fontWeight = FontWeight.ExtraBold
                        )
                        CommonTextField(
                            inputext = editinputAccountName,
                            text = "AccountName",
                            onChange = {
                                editinputAccountName = it
                            })
                        CommonTextField(
                            inputext = editinputUserName,
                            text = "UserName",
                            onChange = {
                                editinputUserName = it
                            })
                        PasswordTextField(
                            inputext = editinputPassword,
                            text = "Password",
                            onChange = {
                                editinputPassword = it
                            })
                    }
                },
                confirmButton = {

                    TextButton(
                        onClick = {
                            alertDiaglog = false
                        },
                    ) {
                        Text(text = "Cancel")
                    }

                    TextButton(
                        onClick = {
                            alertDiaglog = false
                            viewModel.Update(
                                PasswordEntity(
                                    id = currentPasssword.value.id,
                                    accountName = viewModel.encrypt(editinputAccountName),
                                    userName = viewModel.encrypt(editinputUserName),
                                    password = viewModel.encrypt(editinputPassword)
                                )
                            )
                            editModelSheetbtn = false
                        },
                    ) {
                        Text(text = "Confirm")
                    }
                }
            )
        }
    }
}