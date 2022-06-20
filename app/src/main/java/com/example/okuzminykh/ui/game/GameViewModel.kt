package com.example.okuzminykh.ui.game

import androidx.lifecycle.MutableLiveData
import com.example.okuzminykh.arch.BaseViewModel

enum class MARK {
    CROSS,
    NOUGHT,
    EMPTY
}


class GameViewModel : BaseViewModel() {
    var isUserMove = MutableLiveData<Boolean>()
    var isChangedBoard = MutableLiveData<Boolean>()
    var isUserCross = true

    private val _board: Array<Enum<MARK>> by lazy {
        Array(MAX_NUM_COL * MAX_NUM_ROW) { MARK.EMPTY }
    }

    val board: Array<Enum<MARK>>
        get() = _board

    fun computerMove() {
        var ind: Int
        do {
            ind = (0 until MAX_NUM_COL * MAX_NUM_ROW).random()
        } while (board[ind] != MARK.EMPTY)
        board[ind] = if (isUserCross) MARK.NOUGHT else MARK.CROSS
        isChangedBoard.value=true
    }

    var hasWinner = false
    var isGameStart = false

    private val winningPatterns = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )

    fun isEndOfGame(): Boolean {
        for (pattern in winningPatterns) {
            if (_board[pattern[0]] != MARK.EMPTY &&
                _board[pattern[0]] == _board[pattern[1]] &&
                _board[pattern[1]] == _board[pattern[2]]
            ) {
                hasWinner = true
                return true
            }
        }
        return !_board.contains(MARK.EMPTY)
    }
}