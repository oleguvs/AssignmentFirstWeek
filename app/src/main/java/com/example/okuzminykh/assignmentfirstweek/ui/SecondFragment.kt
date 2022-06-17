package com.example.okuzminykh.assignmentfirstweek.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.example.okuzminykh.assignmentfirstweek.R
import com.example.okuzminykh.assignmentfirstweek.data.FragmentViewModel
import com.example.okuzminykh.assignmentfirstweek.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private val viewModel: FragmentViewModel by navGraphViewModels(R.id.firstFragment)
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_second, container, false
        )
        binding.viewmodel = viewModel
        binding.button2.setOnClickListener {
            val isAnsweredFirst = binding.answer4Options.checkedRadioButtonId != -1
            val isAnsweredSecond = binding.answer5Options.checkedRadioButtonId != -1
            val isAnsweredThird = binding.run {
                answer6Option1.isChecked || answer6Option2.isChecked ||
                        answer6Option3.isChecked || answer6Option4.isChecked
                        || answer6Option5.isChecked || answer6Option6.isChecked
                        || answer6Option7.isChecked || answer6Option8.isChecked
                        || answer6Option9.isChecked
            }
            if (isAnsweredFirst && isAnsweredSecond && isAnsweredThird) {
                val answer4 = when (binding.answer4Options.checkedRadioButtonId) {
                    R.id.answer4_option1 -> binding.answer4Option1.text.toString()
                    else -> binding.answer4Option2.text.toString()
                }
                val answer5 = when (binding.answer5Options.checkedRadioButtonId) {
                    R.id.answer5_option1 -> "" //if yes
                    else -> "not" //if no
                }
                val answer6 = getCheckedAnswers()
                viewModel.answers[4] = answer4
                viewModel.answers[5] = answer5
                viewModel.answers[6] = answer6
                this.findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
            }
        }
        return binding.root
    }

    private fun getCheckedAnswers(): String {
        val sb = StringBuilder()
        if (binding.answer6Option1.isChecked) sb.append(", ").append(binding.answer6Option1.text)
        if (binding.answer6Option2.isChecked) sb.append(", ").append(binding.answer6Option2.text)
        if (binding.answer6Option3.isChecked) sb.append(", ").append(binding.answer6Option3.text)
        if (binding.answer6Option4.isChecked) sb.append(", ").append(binding.answer6Option4.text)
        if (binding.answer6Option5.isChecked) sb.append(", ").append(binding.answer6Option5.text)
        if (binding.answer6Option6.isChecked) sb.append(", ").append(binding.answer6Option6.text)
        if (binding.answer6Option7.isChecked) sb.append(", ").append(binding.answer6Option7.text)
        if (binding.answer6Option8.isChecked) sb.append(", ").append(binding.answer6Option8.text)
        if (binding.answer6Option9.isChecked) sb.append(", ").append(binding.answer6Option9.text)
        return sb.substring(2)
    }
}