package com.example.tugashadiahtask.Model

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class DividerItemDecoration : RecyclerView.ItemDecoration() {
    private val dividerHeight = 2
    private val paint = Paint()

    init {
        paint.color = Color.GRAY
    }

    override fun getItemOffsets(
        outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State,
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val position = parent.getChildAdapterPosition(view)
        if (position > 0) {
            outRect.top = dividerHeight
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val left = parent.paddingLeft
        val right = parent.width - parent.paddingRight

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            val position = parent.getChildAdapterPosition(child)

            var top: Float
            var bottom: Float

            if (position == 0) {
                top = child.top.toFloat()
                bottom = top + dividerHeight
                c.drawRect(left.toFloat(), top, right.toFloat(), bottom, paint)
            }

            if (position == parent.adapter!!.itemCount - 1) {
                top = child.bottom.toFloat()
                bottom = top + dividerHeight
                c.drawRect(left.toFloat(), top, right.toFloat(), bottom, paint)
            } else {
                top = child.bottom.toFloat()
                bottom = top + dividerHeight
                c.drawRect(left.toFloat(), top, right.toFloat(), bottom, paint)
            }
        }
    }
}
