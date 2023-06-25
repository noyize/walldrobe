package walldrobe.coffecode.com.ui.user.detail.photos

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import walldrobe.coffecode.com.domain.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class UserPhotosViewModel @Inject constructor(
    userRepository: UserRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val username = savedStateHandle.get<String>("username").orEmpty()
    val photos = userRepository.getPagedUserPhotos(username).cachedIn(viewModelScope)

}