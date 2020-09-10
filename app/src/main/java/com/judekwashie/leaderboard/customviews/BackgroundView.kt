package com.judekwashie.leaderboard.customviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.graphics.RectF
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.judekwashie.leaderboard.R

class BackgroundView @JvmOverloads
constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr, defStyleRes) {

    private var backgroundPaint: Paint = Paint()
    private var darkShadowPaint: Paint = Paint()

    private var oval: RectF = RectF()
    private var myPath: Path = Path()

    init {
        setWillNotDraw(false)


        backgroundPaint.apply {
            style = Paint.Style.FILL
            color = ContextCompat.getColor(context, R.color.dark)
            isAntiAlias = true
        }

        darkShadowPaint.apply {
            style = Paint.Style.FILL
            color = ContextCompat.getColor(context, R.color.dark_shadow)
            isAntiAlias = true
        }
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {
            canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), backgroundPaint)
            canvas.drawCircle(
                width.toFloat(),
                (height / 7f) * 9.4f,
                width.toFloat() * 1.22f,
                darkShadowPaint
            )
            canvas.drawCircle(0f, (height / 7f) / 10f , width * 0.3f, darkShadowPaint)

            
        }
    }
}