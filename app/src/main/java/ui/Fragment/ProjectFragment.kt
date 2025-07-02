package ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.huanying.wanandroid.R
import com.huanying.wanandroid.databinding.FragmentNavigationBinding
import com.huanying.wanandroid.databinding.FragmentProjectBinding


class ProjectFragment : Fragment() {

    private lateinit var binding: FragmentProjectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProjectBinding.inflate(inflater, container, false)
        return binding.root
    }
}