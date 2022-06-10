package com.example.okuzminykh.assignmentfirstweek.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.navGraphViewModels
import com.example.okuzminykh.assignmentfirstweek.R
import com.example.okuzminykh.assignmentfirstweek.data.FragmentViewModel
import com.example.okuzminykh.assignmentfirstweek.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private val viewModel: FragmentViewModel by navGraphViewModels(R.id.firstFragment)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<FragmentResultBinding>(inflater,
        R.layout.fragment_result,container,false)
        binding.viewmodel = viewModel
        val answers= viewModel.answers.values.toList()
        binding.resultText.text= getString(R.string.result_message,answers[0],
        answers[1],answers[2],answers[3],answers[4],answers[5],answers[6],
        answers[7],answers[8])

        return binding.root
    }
}