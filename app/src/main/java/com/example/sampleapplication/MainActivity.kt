package com.example.sampleapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sampleapplication.databinding.ActivityMainBinding
import com.example.sampleapplication.random.KidsNoteMemberDbImpl
import com.example.sampleapplication.random.RepoRandomMember
import com.example.sampleapplication.random.UseCaseRandomMember
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var mBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mBinding.mMemberViewModel = SampleViewModelFactory().create(ViewModelRandomMember::class.java).apply{
            member.observe(this@MainActivity, Observer { data ->
                tvMember.text = data.toString()
                Log.v("TEST", data.toString())
            })
        }
    }

    inner class SampleViewModelFactory : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ViewModelRandomMember(
                usecase = UseCaseRandomMember(),
                repo = RepoRandomMember(
                    db = KidsNoteMemberDbImpl()
                )
            ) as T
        }
    }
}
