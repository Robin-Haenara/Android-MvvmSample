package com.example.sampleapplication.random

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.classnote.domain.random.RandomMemberUseCase
import com.example.sampleapplication.R
import com.example.sampleapplication.databinding.FragmentRandomBinding
import com.example.sampleapplication.db.KidsnoteMemberDbImpl

class RandomFragment : Fragment() {
    lateinit var mBinding: FragmentRandomBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_random, container, false)
        mBinding.lifecycleOwner = this
        mBinding.mMemberViewModel = SampleViewModelFactory().create(RandomMemberViewModel::class.java)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    inner class SampleViewModelFactory : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return RandomMemberViewModel(
                usecase = RandomMemberUseCase(),
                repo = RandomMemberRepoImpl(
                    db = KidsnoteMemberDbImpl()
                )
            ) as T
        }
    }
}
