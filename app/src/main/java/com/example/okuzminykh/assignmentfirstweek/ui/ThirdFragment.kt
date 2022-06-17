package com.example.okuzminykh.assignmentfirstweek.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.okuzminykh.assignmentfirstweek.R
import com.example.okuzminykh.assignmentfirstweek.data.FragmentViewModel
import com.example.okuzminykh.assignmentfirstweek.databinding.FragmentThirdBinding

class ThirdFragment : Fragment() {
    private val viewModel: FragmentViewModel by navGraphViewModels(R.id.firstFragment)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentThirdBinding>(
            inflater,
            R.layout.fragment_third, container, false
        )
        binding.viewmodel = viewModel
        binding.constrainLayout.setOnClickListener {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
        }
        binding.answer8Option1.setOnClickListener {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
        }
        binding.answer8Option2.setOnClickListener {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
        }
        binding.answer9Option1.setOnClickListener {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
        }
        binding.answer9Option2.setOnClickListener {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
        }
        binding.answer9Option3.setOnClickListener {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view?.windowToken, 0)
        }
        binding.button3.setOnClickListener {
            val answer7 = binding.answer7.text.toString()
            val isAnsweredFirst = answer7.isNotBlank()
            val isAnsweredSecond = binding.answer8Options.checkedRadioButtonId != -1
            val isAnsweredThird = binding.answer9Options.checkedRadioButtonId != -1
            if (isAnsweredFirst && isAnsweredSecond && isAnsweredThird) {
                val answer8 = when (binding.answer8Options.checkedRadioButtonId) {
                    R.id.answer8_option1 -> ""
                    else -> getString(R.string.never)
                }
                val answer9 = when (binding.answer9Options.checkedRadioButtonId) {
                    R.id.answer9_option1 -> binding.answer9Option1.text.toString().lowercase()
                    R.id.answer9_option2 -> binding.answer9Option2.text.toString().lowercase()
                    else -> binding.answer9Option3.text.toString().lowercase()
                }
                viewModel.answers[7] = answer7
                viewModel.answers[8] = answer8
                viewModel.answers[9] = answer9
                this.findNavController().navigate(R.id.action_thirdFragment_to_resultFragment)
            }
        }
        return binding.root
    }
}