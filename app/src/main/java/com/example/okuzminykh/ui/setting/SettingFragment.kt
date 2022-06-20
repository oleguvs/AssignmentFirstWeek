package com.example.okuzminykh.ui.setting

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.okuzminykh.R
import com.example.okuzminykh.arch.BaseFragment
import com.example.okuzminykh.databinding.FragmentSettingBinding

class SettingFragment : BaseFragment<FragmentSettingBinding>(R.layout.fragment_setting) {
    override val viewModel: SettingViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState).also {

            binding.button1.setOnClickListener {
                val option1 = binding.typeGameSpinner.selectedItemPosition
                val option2 = binding.firstMoveSpinner.selectedItemPosition
                val options = intArrayOf(option1, option2)
                this.findNavController().navigate(
                    SettingFragmentDirections.actionSettingFragmentToGameFragment(options)
                )
            }
        }
    }
}