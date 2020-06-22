package com.example.sampleapplication.nav

import androidx.navigation.NavDirections
import com.classnote.domain.const.Navigation
import com.classnote.domain.const.Navigation.AddFragment
import com.example.sampleapplication.search.SearchFragmentDirections

object NavigationMapper {
    fun map(nav : Navigation) : NavDirections {
        return when (nav) {
            is AddFragment -> SearchFragmentDirections.actionSearchFragmentToAddFragment(nav.keyword)
        }
    }
}