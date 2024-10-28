package com.example.vesta.domain.manager

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

interface ObserverManager {
    val bottomBarVisible: StateFlow<Boolean>

    fun setBottomBarVisibility(visible: Boolean)
    fun isBottomBarVisible(): Boolean
    fun observeBottomBarVisibility(observer: (Boolean) -> Unit)
}

class ObserverManagerImpl: ObserverManager, KoinComponent {
    private val _bottomBarVisible = MutableStateFlow(true)
    override val bottomBarVisible: StateFlow<Boolean> = _bottomBarVisible.asStateFlow()


    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun setBottomBarVisibility(visible: Boolean) {
        _bottomBarVisible.value = visible
    }

    override fun isBottomBarVisible(): Boolean {
        return _bottomBarVisible.value
    }

    override fun observeBottomBarVisibility(observer: (Boolean) -> Unit) {
        coroutineScope.launch {
            bottomBarVisible.collect { isVisible ->
                observer(isVisible)
            }
        }
    }

}