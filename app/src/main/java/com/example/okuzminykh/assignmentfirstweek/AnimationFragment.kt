package com.example.okuzminykh.assignmentfirstweek

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.okuzminykh.assignmentfirstweek.databinding.FragmentAnimationBinding

const val SECONDS = "seconds"
const val RUNNING = "running"
const val WAS_RUNNING = "was running"

class AnimationFragment : Fragment() {
    var seconds = 5.0
    var running = true
    private var wasRunning = true
    private lateinit var binding: FragmentAnimationBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimationBinding.inflate(layoutInflater, container, false)
        binding.root.setOnClickListener { startAndStopTimer() }

        savedInstanceState?.run {
            seconds = getDouble(SECONDS)
            running = getBoolean(RUNNING)
            wasRunning = getBoolean(WAS_RUNNING)
        }
        updateTime()
        return binding.root
    }

    private fun runTimer() {
        val handler = Handler(Looper.getMainLooper())
        val runnable = object : Runnable {
            override fun run() {
                updateTime()
                if (running) {
                    if (seconds > 0) {
                        seconds -= 0.1
                        handler.postDelayed(this, 100)
                    } else {
                        findNavController().navigate(R.id.action_animationFragment_to_loginFragment)
                    }
                }
            }
        }
        handler.post(runnable)
    }

    fun updateTime() {
        val minutes = (seconds.toInt() % 3600) / 60
        val secs = seconds.toInt() % 60
        val decisecond = (seconds * 10).toInt() % 10
        binding.timerView.text = String.format("%02d:%02d.%d", minutes, secs, decisecond)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putDouble(SECONDS, seconds)
            putBoolean(RUNNING, running)
            putBoolean(WAS_RUNNING, wasRunning)
        }
    }

    override fun onStop() {
        super.onStop()
        wasRunning = running
        running = false
    }

    override fun onStart() {
        super.onStart()
        if (wasRunning) {
            running = true
        }
    }

    override fun onResume() {
        super.onResume()
        if (running) {
            runTimer()
        }
    }

    private fun startAndStopTimer() {
        if (!running) {
            wasRunning = true
            running = true
            runTimer()
        } else {
            running = false
        }
    }
}