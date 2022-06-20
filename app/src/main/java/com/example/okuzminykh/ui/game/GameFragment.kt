package com.example.okuzminykh.ui.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.okuzminykh.R
import com.example.okuzminykh.arch.BaseFragment
import com.example.okuzminykh.databinding.FragmentGameBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class GameFragment : BaseFragment<FragmentGameBinding>(R.layout.fragment_game) {
    private val args: GameFragmentArgs by navArgs()
    override val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState).also {
            binding.gameViewModel = viewModel
            binding.lifecycleOwner = viewLifecycleOwner
            val option1 = args.userInput[0]
            val option2 = args.userInput[1]
            viewModel.run {
                if (!isGameStart) {
                    isUserCross = option1 == 0
                    isUserMove.value = option2 == option1
                }
            }
            setUpGame()
            viewModel.isChangedBoard.observe(viewLifecycleOwner) {
                if (binding.gameView.isChangedBoard.value == true) {
                    binding.gameView.invalidate()
                    binding.gameView.isChangedBoard.value = false
                    binding.gameView.isUserMove.value = binding.gameView.isUserMove.value?.not()
                }
            }

            viewModel.isUserMove.observe(viewLifecycleOwner) {
                if (viewModel.isEndOfGame()) {
                    showFinalScoreDialog()
                } else if (viewModel.isUserMove.value == false) {
                    viewModel.computerMove()
                }
            }
        }
    }


    private fun showFinalScoreDialog() {
        MaterialAlertDialogBuilder(requireContext())
            .setTitle(getString(R.string.congratulations))
            .setMessage(
                if (viewModel.hasWinner) {
                    getString(
                        R.string.winner,
                        if (viewModel.isUserMove.value == true) getString(R.string.computer) else getString(
                            R.string.player
                        )
                    )
                } else {
                    getString(R.string.draw)
                }
            )
            .setCancelable(false)
            .setNegativeButton(getString(R.string.exit)) { _, _ ->
                exitGame()
            }
            .setPositiveButton(getString(R.string.play_again)) { _, _ ->
                restartGame()
            }
            .show()
    }


    private fun restartGame() {
        this.findNavController().navigate(R.id.action_gameFragment_to_settingFragment)
    }

    private fun exitGame() {
        activity?.finish()
    }

    private fun setUpGame() {
        viewModel.isChangedBoard.value = false
        binding.gameView.board = viewModel.board
        binding.gameView.isUserMove = viewModel.isUserMove
        binding.gameView.isUserCross = viewModel.isUserCross
        binding.gameView.isChangedBoard = viewModel.isChangedBoard
        viewModel.isGameStart = true
    }
}
