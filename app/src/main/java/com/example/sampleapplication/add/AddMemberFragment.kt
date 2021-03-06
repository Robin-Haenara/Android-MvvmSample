package com.example.sampleapplication.add

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.classnote.domain.add.AddMemberUseCase
import com.example.sampleapplication.R
import com.example.sampleapplication.databinding.FragmentAddBindingImpl
import com.example.sampleapplication.db.KidsnoteMemberDbImpl


class AddMemberFragment : Fragment() {
    lateinit var mBinding: FragmentAddBindingImpl

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add, container, false)
        mBinding.lifecycleOwner = this
        mBinding.mMemberViewModel =
            SampleViewModelFactory().create(AddMemberViewModel::class.java).apply {
                // 이전 Fragment로 부터 전달받은 파라미터를 넣는다.
                name = arguments?.getString("keyword") ?: ""

                dialogEvent.observe(viewLifecycleOwner, Observer {
                    AlertDialog.Builder(activity as Context)
                        .setMessage(it)
                        .setPositiveButton("확인", DialogInterface.OnClickListener { _, _ -> })
                        .setCancelable(true)
                        .create()
                        .show()
                })
            }
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    inner class SampleViewModelFactory : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return AddMemberViewModel(
                AddMemberUseCase(),
                AddMemberRepoImpl(KidsnoteMemberDbImpl)
            ) as T
        }
    }
}
