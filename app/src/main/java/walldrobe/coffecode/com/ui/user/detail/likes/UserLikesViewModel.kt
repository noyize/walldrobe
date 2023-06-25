package walldrobe.coffecode.com.ui.user.detail.likes

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import walldrobe.coffecode.com.domain.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class UserLikesViewModel @Inject constructor(
    userRepository: UserRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val username = savedStateHandle.get<String>("username").orEmpty()
    val photos = userRepository.getPagedUserLikes(username).cachedIn(viewModelScope)

}