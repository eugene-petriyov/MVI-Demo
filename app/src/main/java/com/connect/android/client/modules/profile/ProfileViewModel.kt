package com.connect.android.client.modules.profile

import com.connect.android.client.model.chats.ChatsRepository
import com.connect.android.client.model.recommendations.RecommendationsRepository
import com.connect.android.client.modules.base.BaseMviViewModel
import com.freeletics.rxredux.SideEffect
import kotlin.reflect.KClass

class ProfileViewModel(
    private val recommendationsRepository: RecommendationsRepository,
    private val chatsRepository: ChatsRepository,
    initialState: ProfileVS
) : BaseMviViewModel<ProfileVIA, ProfileVS>(initialState) {
    override fun filterActions(): List<KClass<out ProfileVIA>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun reducer(state: ProfileVS, action: ProfileVIA): ProfileVS {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun sideEffects(): List<SideEffect<ProfileVS, ProfileVIA>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}