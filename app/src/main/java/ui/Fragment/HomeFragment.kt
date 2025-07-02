package ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huanying.wanandroid.R
import com.huanying.wanandroid.databinding.FragmentHomeBinding
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        //设置标题
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //初始化Banner
        initBanner()


        binding.includeTitle.tvTitle.text = "首页"
        return binding.root
    }

    private fun initBanner() {
        val banner = binding.homeBanner
        val imageList = listOf(R.mipmap.test_meidusha, R.mipmap.test_xiaoyixian, R.mipmap.test_xuner)

        // 设置适配器
        banner.setAdapter(object : BannerImageAdapter<Int>(imageList) {
            override fun onBindView(holder: BannerImageHolder, data: Int, position: Int, size: Int) {
                // 设置本地图片
                holder.imageView.setImageResource(data) // 直接加载本地资源
            }
        })

        // 设置指示器（可选）
        banner.setIndicator(CircleIndicator(requireContext()))



        banner.isAutoLoop(true)

        // 设置延迟时间（自动滚动的时间间隔）
        banner.setLoopTime(1000)

        // 启动轮播图
        banner.start()
    }



}