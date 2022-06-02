package com.example.okuzminykh.assignmentfirstweek

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import com.example.okuzminykh.assignmentfirstweek.databinding.FragmentLoginBinding

const val REGEXP_FOR_PASSWORD = "^(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}\$"
const val REGEXP_FOR_USER_NAME = "^[a-zA-z0-9]+\$"

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)

        binding.userNameEditText.setOnFocusChangeListener { view, hasFocus ->
            binding.userName.error = null
            if (!hasFocus) {
                val text = binding.userNameEditText.text.toString()
                if (text.isNotEmpty()) validateUserNameContent(text)
            }
        }

        binding.passwordEditText.setOnFocusChangeListener { view, b ->
            binding.password.error = null
            if (!b) {
                val text = binding.passwordEditText.text.toString()
                if (text.isNotEmpty()) validatePasswordContent(text)
            }
        }
        binding.signInButton.setOnClickListener { singIn() }
        binding.passwordEditText.setOnEditorActionListener { v, actionId, event ->
            return@setOnEditorActionListener when (actionId) {
                EditorInfo.IME_ACTION_GO -> {
                    binding.passwordEditText.clearFocus()
                    binding.signInButton.requestFocus()
                    singIn()
                    true
                }
                else -> false
            }
        }
        return binding.root
    }

    private fun singIn() {
        val userName = binding.userNameEditText.text.toString()
        val password = binding.passwordEditText.text.toString()
        if (validateUserNameContent(userName) && validatePasswordContent(password)) {
            binding.signInButton.isEnabled = false
            binding.userNameEditText.isEnabled = false
            binding.passwordEditText.isEnabled = false
        }
    }

    private fun validateUserNameContent(text: String): Boolean {
        return if (!text.matches(REGEXP_FOR_USER_NAME.toRegex())) {
            if (binding.signInButton.isPressed) {
                binding.passwordEditText.clearFocus()
            }
            binding.userName.error = getString(R.string.user_name_error)
            false
        } else {
            binding.userNameEditText.clearFocus()
            binding.passwordEditText.requestFocus()
            true
        }
    }

    private fun validatePasswordContent(text: String): Boolean {
        if (!text.matches(REGEXP_FOR_PASSWORD.toRegex())) {
            binding.password.error = getString(R.string.password_error)
            return false
        }
        binding.passwordEditText.clearFocus()
        binding.userNameEditText.requestFocus()
        return true
    }
}