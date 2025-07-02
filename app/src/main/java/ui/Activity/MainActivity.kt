package ui.Activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.hjq.toast.Toaster
import com.huanying.wanandroid.R
import com.huanying.wanandroid.databinding.ActivityMainBinding
import ui.Fragment.HomeFragment
import ui.Fragment.MyFragment
import ui.Fragment.NavigationFragment
import ui.Fragment.ProjectFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var fragments: List<Fragment>
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Toaster.init(application)
        fragments = listOf(
            HomeFragment(),
            ProjectFragment(),
            NavigationFragment(),
            MyFragment()
        )
        showFragment(fragments[0])
        switchFragment()


    }

    private fun showFragment(fragment: Fragment) {
        //方式一:replace方式
//        val transaction = supportFragmentManager.beginTransaction()
//        transaction.replace(R.id.nav_fragment,fragment)
//        transaction.commit()

        //方式二:hide+show方式
        val transaction = supportFragmentManager.beginTransaction()
        if (!fragment.isAdded) {
            transaction.add(R.id.nav_fragment, fragment)
        }
        currentFragment?.let { transaction.hide(it) }
        transaction.show(fragment)
        transaction.commit()
        currentFragment = fragment
    }

    private fun switchFragment() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_home -> {
                    showFragment(fragments[0])
                    Toaster.show("点击了首页")
                    true
                }

                R.id.menu_project -> {
                    showFragment(fragments[1])
                    Toaster.show("点击了项目")
                    true
                }

                R.id.menu_navigation -> {
                    showFragment(fragments[2])
                    Toaster.show("点击了导航")
                    true
                }

                R.id.menu_me -> {
                    showFragment(fragments[3])
                    Toaster.show("点击了我的")
                    true
                }

                else -> {
                    false
                }
            }
        }
    }
}