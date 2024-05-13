package com.github.hongbeomi.sample

import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import androidx.viewpager2.widget.CompositePageTransformer
import com.github.hongbeomi.sample.databinding.ActivityMainBinding
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private val mainTabList = listOf(
        MainTab(
            title = "TextView1",
            backgroundColor = Color.RED,
        ),
        MainTab(
            title = "TextView2",
            backgroundColor = Color.BLUE,
        ),
        MainTab(
            title = "TextView3",
            backgroundColor = Color.GREEN,
        )
    )
    private val pagerAdapter by lazy { MainAdapter() }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater).apply {
            setContentView(this.root)
        }
        initViews()
    }

    private fun initViews() = with(binding) {
        vpMain.adapter = pagerAdapter
        pagerAdapter.submitList(mainTabList)
        vpMain.setPageTransformer(getPageTransformer())
        vpMain.addItemDecoration(object : ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                outRect.right = 48
                outRect.left = 48
            }
        })
    }

    private fun getPageTransformer() = CompositePageTransformer().apply {
        addTransformer { page, position -> page.alpha = 1 - abs(position) }
        addTransformer { page, position ->
            val absPosition = abs(position)
            val requestScale = if (absPosition >= 1) {
                MIN_SCALE
            } else {
                MIN_SCALE + (1 - absPosition) * (1 - MIN_SCALE)
            }
            page.scaleY = requestScale
            page.scaleX = requestScale
        }
    }

    companion object {
        private const val MIN_SCALE = 0.5f
    }

}