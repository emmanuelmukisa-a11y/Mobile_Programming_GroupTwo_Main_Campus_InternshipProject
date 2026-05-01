package com.ndejje.momo.ourinternship.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ndejje.momo.ourinternship.R
import com.ndejje.momo.ourinternship.ui.viewmodel.AuthState
import com.ndejje.momo.ourinternship.ui.viewmodel.AuthViewModel

@Composable
fun RegisterScreen(
    viewModel: AuthViewModel,
    onRegisterSuccess: (String) -> Unit,
    onNavigateToLogin: () -> Unit
) {
    val authState by viewModel.authState
    var fullNameInput    by remember { mutableStateOf("") }
    var emailInput       by remember { mutableStateOf("") }
    var passwordInput    by remember { mutableStateOf("") }
    var confirmPassInput by remember { mutableStateOf("") }

    LaunchedEffect(authState) {
        if (authState is AuthState.Success) {
            onRegisterSuccess((authState as AuthState.Success).user.name)
            viewModel.resetState()
        }
    }

    Column(modifier = Modifier.fillMaxSize()
        .verticalScroll(rememberScrollState())
        .padding(dimensionResource(R.dimen.padding_medium)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Text(stringResource(R.string.register_title),
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center)
        Spacer(Modifier.height(dimensionResource(R.dimen.padding_large)))

        OutlinedTextField(value = fullNameInput,
            onValueChange = { fullNameInput = it },
            label = { Text(stringResource(R.string.name_label)) },
            modifier = Modifier.fillMaxWidth(), singleLine = true)
        Spacer(Modifier.height(dimensionResource(R.dimen.padding_medium)))

        OutlinedTextField(value = emailInput,
            onValueChange = { emailInput = it },
            label = { Text(stringResource(R.string.email_label)) },
            modifier = Modifier.fillMaxWidth(), singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email))
        Spacer(Modifier.height(dimensionResource(R.dimen.padding_medium)))

        OutlinedTextField(value = passwordInput,
            onValueChange = { passwordInput = it },
            label = { Text(stringResource(R.string.password_label)) },
            modifier = Modifier.fillMaxWidth(), singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))
        Spacer(Modifier.height(dimensionResource(R.dimen.padding_medium)))

        OutlinedTextField(value = confirmPassInput,
            onValueChange = { confirmPassInput = it },
            label = { Text(stringResource(R.string.password_label) + " (Confirm)") },
            modifier = Modifier.fillMaxWidth(), singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password))
        Spacer(Modifier.height(dimensionResource(R.dimen.padding_small)))

        if (authState is AuthState.Error) {
            Text((authState as AuthState.Error).message,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall)
            Spacer(Modifier.height(dimensionResource(R.dimen.padding_small)))
        }

        Button(onClick = {
            if (passwordInput == confirmPassInput && fullNameInput.isNotBlank() && emailInput.isNotBlank()) {
                viewModel.register(fullNameInput, emailInput, passwordInput, "STUDENT")
            }
        }, modifier = Modifier.fillMaxWidth()
            .height(dimensionResource(R.dimen.button_height)),
            enabled = authState !is AuthState.Loading) {
            if (authState is AuthState.Loading)
                CircularProgressIndicator(
                    modifier = Modifier.size(24.dp),
                    color = MaterialTheme.colorScheme.onPrimary)
            else Text(stringResource(R.string.register_button))
        }
        Spacer(Modifier.height(dimensionResource(R.dimen.padding_medium)))
        TextButton(onClick = { viewModel.resetState(); onNavigateToLogin() }) {
            Text(stringResource(R.string.already_account))
        }
    }
}
