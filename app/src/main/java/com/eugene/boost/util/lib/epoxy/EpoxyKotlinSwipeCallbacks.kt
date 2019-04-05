package com.eugene.boost.util.lib.epoxy

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.RectF
import android.graphics.drawable.Drawable
import android.view.View
import androidx.annotation.ColorInt
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyTouchHelper
import com.google.android.material.math.MathUtils.lerp
import kotlin.math.roundToInt


abstract class EpoxyKotlinSwipeCallbacks<T : EpoxyModel<*>>(
    private val _rightIcon: Drawable? = null,
    @ColorInt private val _rightIconColor: Int? = null,
    private val _leftIcon: Drawable? = null,
    @ColorInt private val _leftIconColor: Int? = null,
    private val _padding: Int,
    @ColorInt private val _backgroundColor: Int,
    @ColorInt private val _foregroundRightColor: Int? = null,
    @ColorInt private val _foregroundLeftColor: Int? = null
) : EpoxyTouchHelper.SwipeCallbacks<T>() {

    private val _rect = RectF()
    private val _iconBounds = Rect()

    private val _rightIconHeight = _rightIcon?.intrinsicHeight ?: 0
    private val _rightIconWidth = _rightIcon?.intrinsicWidth ?: 0

    private val _leftIconHeight = _leftIcon?.intrinsicHeight ?: 0
    private val _leftIconWidth = _leftIcon?.intrinsicWidth ?: 0

    private val _backgroundPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = _backgroundColor
    }

    private val _foregroundRightPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = _foregroundRightColor ?: 0
    }

    private val _foregroundLeftPaint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = _foregroundLeftColor ?: 0
    }

    override fun onSwipeProgressChanged(model: T, itemView: View, swipeProgress: Float, canvas: Canvas) {

        _rect.set(
            itemView.left.toFloat(),
            itemView.top.toFloat(),
            itemView.right.toFloat(),
            itemView.bottom.toFloat()
        )

        _rect.offset(itemView.translationX, itemView.translationY)

        if (_rect.left == 0f || _rect.right == canvas.width.toFloat()) {
            return
        }

        var radius = 0f

        val save = canvas.save()

        if (_rect.left > 0) {
            // Swipe Left to Right
            _rect.right = _rect.left
            _rect.left = 0f

            canvas.clipRect(_rect)

            val startValue = _iconBounds.right + _padding / 2
            val endValue = _rect.left + itemView.width / 2

            if (_rect.right >= startValue) {
                val fraction = ((_rect.right - startValue) / (endValue - startValue)).coerceIn(0f, 1f)
                val maxRadius = Math.hypot(
                    _rect.right.toDouble() - _iconBounds.centerX(),
                    _iconBounds.centerY().toDouble()
                )
                radius = lerp(0f, maxRadius.toFloat(), fraction)
            }

            val left = _rect.left.roundToInt() + _padding
            val top = (_rect.top + (_rect.height() - _rightIconHeight) / 2).roundToInt()

            _iconBounds.set(left, top, left + _rightIconWidth, top + _rightIconHeight)
            _rightIcon?.bounds = _iconBounds

            // Draw the Background Color
            canvas.drawRect(_rect, _backgroundPaint)

            if (radius > 0) {
                canvas.drawCircle(
                    _iconBounds.centerX().toFloat(),
                    _iconBounds.centerY().toFloat(),
                    radius,
                    _foregroundRightPaint
                )
            }

            if (_rightIconColor != null) {
                _rightIcon?.setTint(_rightIconColor)
            }

            // Draw the Icon
            _rightIcon?.draw(canvas)
        } else if (_rect.right < canvas.width) {
            // Swipe Right to Left
            _rect.left = _rect.right
            _rect.right = canvas.width.toFloat()

            canvas.clipRect(_rect)

            val startValue = _iconBounds.left - _padding / 2
            val endValue = _rect.right - itemView.width / 2

            if (_rect.left <= startValue) {
                val fraction = ((_rect.left - startValue) / (endValue - startValue)).coerceIn(0f, 1f)
                val maxRadius = Math.hypot(
                    _iconBounds.centerX() - _rect.left.toDouble(),
                    _iconBounds.centerY().toDouble()
                )
                radius = lerp(0f, maxRadius.toFloat(), fraction)
            }

            val right = _rect.right.roundToInt() - _padding
            val top = (_rect.top + (_rect.height() - _leftIconHeight) / 2).roundToInt()

            _iconBounds.set(right - _leftIconWidth, top, right, top + _leftIconHeight)
            _leftIcon?.bounds = _iconBounds

            // Draw the Background Color
            canvas.drawRect(_rect, _backgroundPaint)

            if (radius > 0) {
                canvas.drawCircle(
                    _iconBounds.centerX().toFloat(),
                    _iconBounds.centerY().toFloat(),
                    radius,
                    _foregroundLeftPaint
                )
            }

            if (_leftIconColor != null) {
                _leftIcon?.setTint(_leftIconColor)
            }

            // Draw the Icon
            _leftIcon?.draw(canvas)
        }

        canvas.restoreToCount(save)
    }
}
