package dev.bhavindesai.mvvmarch.ui.userlist

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class SpaceItemDecoration(context: Context, @DimenRes private val spaceOffset: Int) : RecyclerView.ItemDecoration() {
    private val space: Int = context.resources.getDimensionPixelSize(spaceOffset)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        if (space == 0) return

        val position = parent.getChildAdapterPosition(view)
        val isFirstItem = position == 0
        val isLastItem = position == parent.adapter!!.itemCount - 1

        val top: Int
        val bottom: Int
        when {
            isFirstItem -> {
                top = 0
                bottom = (space / 2f + 0.5f).toInt()
            }
            isLastItem -> {
                top = (space / 2f + 0.5f).toInt()
                bottom = 0
            }
            else -> {
                top = (space / 2f + 0.5f).toInt()
                bottom = (space / 2f + 0.5f).toInt()
            }
        }

        outRect.set(0, top, 0, bottom)
    }
}
