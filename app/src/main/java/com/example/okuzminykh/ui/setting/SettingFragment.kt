package com.example.okuzminykh.ui.setting

import androidx.fragment.app.viewModels
import com.example.okuzminykh.R
import com.example.okuzminykh.arch.BaseFragment
import com.example.okuzminykh.databinding.FragmentSettingBinding

class SettingFragment : BaseFragment<FragmentSettingBinding>(R.layout.fragment_setting) {
    override val viewModel: SettingViewModel by viewModels()


}