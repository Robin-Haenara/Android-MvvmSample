package com.example.sampleapplication.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.classnote.domain.model.KidsnoteMember
import com.example.sampleapplication.R
import com.example.sampleapplication.databinding.ItemSearchBinding

class SearchRecyclerViewAdapter(var memberList: List<KidsnoteMember>) :
    RecyclerView.Adapter<SearchRecyclerViewAdapter.SearchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_search,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = memberList.size

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(memberList[position])
    }

    inner class SearchViewHolder(private val mBinding: ItemSearchBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun bind(member: KidsnoteMember) {
            mBinding.member = member
        }
    }

}

@BindingAdapter("recyclerViewBindingAdapter")
fun setRecyclerViewBindingAdapter(view: RecyclerView, viewModel: SearchViewModel) {
    if (view.adapter == null) {
        view.adapter = SearchRecyclerViewAdapter(viewModel.memberList.value!!)
    }
    view.adapter?.notifyDataSetChanged()
}

@BindingAdapter("filterdList")
fun setSearchRecyclerViewList(view: RecyclerView, list: List<KidsnoteMember>) {
    (view.adapter as SearchRecyclerViewAdapter).memberList = list
    view.adapter?.notifyDataSetChanged()
}