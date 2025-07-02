package ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huanying.wanandroid.R
import com.huanying.wanandroid.databinding.FragmentMyBinding
import com.huanying.wanandroid.databinding.FragmentNavigationBinding


class NavigationFragment : Fragment() {

    private lateinit var binding: FragmentNavigationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNavigationBinding.inflate(inflater, container, false)
        return binding.root
    }


}