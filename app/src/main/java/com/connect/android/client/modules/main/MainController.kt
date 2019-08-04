package com.connect.android.client.modules.main

import android.content.Context
import android.os.Bundle
import com.connect.android.client.extensions.Do
import com.connect.android.client.extensions.buildRouterTransaction
import com.connect.android.client.extensions.with
import com.connect.android.client.model.chats.Chat
import com.connect.android.client.modules.base.BaseMviController
import com.connect.android.client.modules.chat.ChatController
import com.connect.android.client.modules.recommendations.RecommendationsController

class MainController(bundle: Bundle? = null) : BaseMviController<MainView, MainVIA, MainVOA>(bundle), ChatOpener {
    override fun openChat(chat: Chat) {
        router.pushController(ChatController.newInstance(chat).buildRouterTransaction())
    }

    override fun buildView(context: Context) = MainView(context, MainVS())

    override fun handleViewEvents(action: MainVOA) {
        val childController = (Do exhaustive when (action) {
            MainVOA.Chats -> MainController()
            MainVOA.Contacts -> MainController()
            MainVOA.Events -> MainController()
            MainVOA.Profile -> MainController()
            MainVOA.Recommendations -> RecommendationsController()
        })
        getChildRouter()?.setRoot(childController!!.with(this).buildRouterTransaction(childControllerTag()))
    }
}

interface ChatOpener {
    fun openChat(chat: Chat)
}