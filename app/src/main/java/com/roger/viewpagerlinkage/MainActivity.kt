package com.roger.viewpagerlinkage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.roger.viewpagerlinkage.adapter.MyPagerAdapter
import com.roger.viewpagerlinkage.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mBinding: ActivityMainBinding

    private val adapter1: MyPagerAdapter by lazy { MyPagerAdapter() }
    private val adapter2: MyPagerAdapter by lazy { MyPagerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mBinding.mViewPage1.adapter = adapter1
        mBinding.mViewPage2.adapter = adapter2

        mBinding.mFrameLayout1.setOtherFrameLayout(mBinding.mFrameLayout2)
        mBinding.mFrameLayout2.setOtherFrameLayout(mBinding.mFrameLayout1)
    }
}