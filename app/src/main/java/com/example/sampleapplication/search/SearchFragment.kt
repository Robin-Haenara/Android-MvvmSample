package com.example.sampleapplication.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.classnote.domain.search.SearchUseCase
import com.example.sampleapplication.R
import com.example.sampleapplication.databinding.FragmentSearchBinding
import com.example.sampleapplication.db.KidsnoteMemberDbImpl

class SearchFragment : Fragment() {
    private lateinit var mBinding: FragmentSearchBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)
        mBinding.lifecycleOwner = this
        mBinding.mViewModel = SearchViewModelFactory().create(SearchViewModel::class.java)
        return mBinding.root
    }

    inner class SearchViewModelFactory : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SearchViewModel(SearchRepoImpl(KidsnoteMemberDbImpl()), SearchUseCase()) as T
        }
    }
}