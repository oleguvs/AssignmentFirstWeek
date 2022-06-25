package com.example.okuzminykh.ui.splash

import com.example.okuzminykh.R
import com.example.okuzminykh.databinding.SplashFragmentBinding
import com.example.okuzminykh.arch.BaseFragment
import com.example.okuzminykh.arch.ext.navigate
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<SplashFragmentBinding>(R.layout.splash_fragment) {

    override val viewModel: SplashViewModel by viewModel()

    override fun setObservers() {
        viewModel.initEvent.observe(this) {
            if (it) showLogInScreen()
        }
    }

    private fun showLogInScreen() {
        navigate(R.id.settingFragment, clearStack = true)
    }

}
