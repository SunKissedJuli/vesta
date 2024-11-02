package com.example.vesta.domain.manager

import cafe.adriel.voyager.navigator.tab.Tab
import com.example.vesta.platform.Either
import com.example.vesta.platform.Failure
import com.example.vesta.screen.tabs.HomeTab
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
    val isTabNavigator: StateFlow<Boolean>
    val bottomBarVisible: StateFlow<Boolean>
    val tabStack: StateFlow<MutableList<Tab>>

    fun setBottomBarVisibility(visible: Boolean)
    fun isBottomBarVisible(): Boolean
    fun setIsTabNavigator(visible: Boolean)
    fun isTabNavigator(): Boolean
    fun observeBottomBarVisibility(observer: (Boolean) -> Unit)
    fun addTabStack(tab: Tab)
    fun popTab(): Either<Failure, Unit>

}

class ObserverManagerImpl: ObserverManager, KoinComponent {
    private val _bottomBarVisible = MutableStateFlow(false)
    override val bottomBarVisible: StateFlow<Boolean> = _bottomBarVisible.asStateFlow()
    val _tabStack = MutableStateFlow<MutableList<Tab>>(mutableListOf(HomeTab))
    override val tabStack: StateFlow<MutableList<Tab>> = _tabStack.asStateFlow()
    private val _isTabNavigator = MutableStateFlow(false)
    override val isTabNavigator: StateFlow<Boolean> = _isTabNavigator.asStateFlow()

    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun setBottomBarVisibility(visible: Boolean) {
        _bottomBarVisible.value = visible
    }

    override fun isBottomBarVisible(): Boolean {
        return _bottomBarVisible.value
    }

    override fun setIsTabNavigator(visible: Boolean) {
        _isTabNavigator.value = visible
    }

    override fun isTabNavigator(): Boolean {
        return _isTabNavigator.value
    }

    override fun observeBottomBarVisibility(observer: (Boolean) -> Unit) {
        coroutineScope.launch {
            bottomBarVisible.collect { isVisible ->
                observer(isVisible)
            }
        }
    }

    override fun addTabStack(tab: Tab) {
        _tabStack.value.add(tab)
    }

    override fun popTab(): Either<Failure, Unit> {
        return try {
            if(_tabStack.value.size == 1) {
                return Either.Left(Failure.Message("Стэк навигации пуст"))
            }
            coroutineScope.launch {
                _tabStack.emit(_tabStack.value.dropLast(1).toMutableList())
            }
            Either.Right(Unit)
        } catch (
            e: Exception
        ) {
            Either.Left(Failure.Message("Ошибка"))
        }
    }

}