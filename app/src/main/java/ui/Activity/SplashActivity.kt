package ui.Activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.huanying.wanandroid.R
import com.huanying.wanandroid.databinding.ActivityMainBinding
import com.huanying.wanandroid.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private lateinit var countDownTimer: CountDownTimer
    private val jump: String = "跳过"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        jumpTime()


    }

    private fun jumpTime() {
        countDownTimer = object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = jump + (millisUntilFinished / 1000 + 1).toInt()
                binding.btnJump.text = secondsRemaining.toString()
            }

            override fun onFinish() {
                startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                finish()
            }
        }.start()
        binding.btnJump.setOnClickListener {
            countDownTimer.cancel() //取消倒计时
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }
}