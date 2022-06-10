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
import com.example.okuzminykh.assignmentfirstweek.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private val viewModel: FragmentViewModel by navGraphViewModels(R.id.firstFragment)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       val binding = DataBindingUtil.inflate<FragmentFirstBinding>(
            inflater,
            R.layout.fragment_first, container, false
        )
        binding.viewmodel = viewModel
        binding.button1.setOnClickListener {
            val answer1 = binding.answer1.text.toString()
            val answer2 = binding.answer2.text.toString()
            val answer3 = binding.answer3.text.toString()
            val isAnsweredFirst = answer1.isNotBlank()
            val isAnsweredSecond = answer2.isNotBlank()
            val isAnsweredThird = answer3.matches("\\d{1,3}".toRegex())
            if (isAnsweredFirst && isAnsweredSecond && isAnsweredThird) {
                viewModel.answers[1] = answer1
                viewModel.answers[2] = answer2
                viewModel.answers[3] = answer3
                this.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
            }
        }
        return binding.root
    }
}

