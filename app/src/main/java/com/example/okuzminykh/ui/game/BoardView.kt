package com.example.okuzminykh.ui.game

import android.content.Context
import android.content.res.Configuration
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.MutableLiveData
import kotlin.math.min


const val STROKE_WIDTH = 12f // has to be float
const val MAX_NUM_ROW = 3
const val MAX_NUM_COL = 3

class BoardView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var lengthOfLine = 0.0f
    private var extraMargin = 0.0f
    private var interval = 0.0f
    lateinit var board: Array<Enum<MARK>>
    var isChangedBoard = MutableLiveData<Boolean>()

    var isUserMove = MutableLiveData<Boolean>()
    var isUserCross = true

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color =
            if (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES) Color.WHITE else Color.BLACK
        strokeWidth = STROKE_WIDTH
    }

    private val noughtPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color =
            if (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES) Color.YELLOW else Color.BLUE
        strokeWidth = STROKE_WIDTH
    }

    private val crossPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.STROKE
        color =
            if (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_YES) Color.MAGENTA else Color.RED
        strokeWidth = STROKE_WIDTH
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        val screenSide = min(width, height)
        interval = screenSide / MAX_NUM_COL.toFloat()
        extraMargin = 0.2f * interval
        lengthOfLine = screenSide - extraMargin
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        drawField(canvas)
        for (ind in 0 until MAX_NUM_ROW * MAX_NUM_COL) {
            val row = ind % MAX_NUM_COL
            val col = ind / MAX_NUM_COL
            when (board[ind]) {
                MARK.NOUGHT -> drawNought(canvas, row, col)
                MARK.CROSS -> drawCross(canvas, row, col)
            }
        }
    }

    private fun drawField(canvas: Canvas?) {
        canvas?.drawLine(interval, extraMargin, interval, lengthOfLine, paint)
        canvas?.drawLine(2 * interval, extraMargin, 2 * interval, lengthOfLine, paint)
        canvas?.drawLine(extraMargin, interval, lengthOfLine, interval, paint)
        canvas?.drawLine(extraMargin, 2 * interval, lengthOfLine, 2 * interval, paint)
    }

    private fun drawCross(canvas: Canvas?, row: Int, col: Int) {
        val x0 = (row + 0.25f) * interval
        val y0 = (col + 0.25f) * interval
        val x1 = (row + 0.75f) * interval
        val y1 = (col + 0.75f) * interval
        val x2 = (row + 0.25f) * interval
        val y2 = (col + 0.75f) * interval
        val x3 = (row + 0.75f) * interval
        val y3 = (col + 0.25f) * interval
        canvas?.drawLines(floatArrayOf(x0, y0, x1, y1, x2, y2, x3, y3), crossPaint)
    }

    private fun drawNought(canvas: Canvas?, row: Int, col: Int) {
        canvas?.drawCircle(
            (row + 0.5f) * interval, (col + 0.5f) * interval,
            0.25f * interval, noughtPaint
        )
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event?.action == MotionEvent.ACTION_DOWN) {
            if (isChangedBoard.value==false) {
                updateGame(event.x, event.y)
            }
        }
        return performClick()
    }

    override fun performClick(): Boolean {
        if (super.performClick()) return true
        return true
    }

    private fun updateGame(x: Float, y: Float) {
        val col = (x / interval).toInt()
        val row = (y / interval).toInt()
        val ind = row * MAX_NUM_COL + col
        if (isUserMove.value == true && row < MAX_NUM_ROW && col < MAX_NUM_COL && board[ind] == MARK.EMPTY) {
            board[ind] = if (isUserCross) MARK.CROSS else MARK.NOUGHT
            isChangedBoard.value = true
        }
    }
}
