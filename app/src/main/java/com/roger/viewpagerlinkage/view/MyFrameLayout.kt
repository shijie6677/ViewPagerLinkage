package com.roger.viewpagerlinkage.view

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.widget.FrameLayout

class MyFrameLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private var otherMyFrameLayout: MyFrameLayout? = null

    fun setOtherFrameLayout(_layout: MyFrameLayout) {
        this.otherMyFrameLayout = _layout
    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        val isDispatch = super.dispatchTouchEvent(ev)
        otherMyFrameLayout?.let {
            it.fakeTouchEvent(ev)
        }
        return isDispatch
    }

    /**
     * 调用其他Layout父类的dispatchTouchEvent 以避免 Layout1与Layout2 dispatchTouchEvent事件死锁
     */
    private fun fakeTouchEvent(ev: MotionEvent?) {
        //执行的是其他layout父类的dispatchTouchEvent
        super.dispatchTouchEvent(ev)
    }
}