package com.example.okuzminykh.assignmentfirstweek.ui.splash

import com.example.okuzminykh.assignmentfirstweek.R
import com.example.okuzminykh.assignmentfirstweek.databinding.SplashFragmentBinding
import com.example.okuzminykh.assignmentfirstweek.arch.BaseFragment
import com.example.okuzminykh.assignmentfirstweek.arch.ext.navigate
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : BaseFragment<SplashFragmentBinding>(R.layout.splash_fragment) {

    override val viewModel: SplashViewModel by viewModel()

//    override fun setObservers() {
//        viewModel.initEvent.observe(this) {
//            if (it) showLogInScreen()
//        }
//    }
//
//    private fun showLogInScreen() {
//        navigate(R.id.typeGameFragment, clearStack = true)
//    }

}