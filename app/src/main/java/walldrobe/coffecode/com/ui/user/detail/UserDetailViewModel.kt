package walldrobe.coffecode.com.ui.user.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import walldrobe.coffecode.com.app.util.Resource
import walldrobe.coffecode.com.domain.model.User
import walldrobe.coffecode.com.domain.repository.UserRepository
import javax.inject.Inject

@HiltViewModel
class UserDetailViewModel @Inject constructor(
    private val userRepository: UserRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    private var _uiState by mutableStateOf(UserDetailUiState.DEFAULT)
    val uiState get() = _uiState

    init {
        val user = savedStateHandle.get<User>("user")
        user?.let {
            _uiState = _uiState.copy(user = it)
            getUserPhotos(username = it.username)
            getUserLikes(username = it.username)
            getUserCollections(username = it.username)
        }
    }

    private fun getUserPhotos(username: String) {
        viewModelScope.launch {
            userRepository.getUserPhotos(username = username).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _uiState = _uiState.copy(
                            photosError = result.error,
                            isPhotosLoading = false
                        )
                    }

                    is Resource.Loading -> {
                        _uiState = _uiState.copy(
                            isPhotosLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _uiState = _uiState.copy(
                            photos = result.value,
                            isPhotosLoading = false
                        )
                    }
                }
            }
        }
    }

    private fun getUserLikes(username: String) {
        viewModelScope.launch {
            userRepository.getUserLikes(username = username).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _uiState = _uiState.copy(
                            likesError = result.error,
                            isLikesLoading = false
                        )
                    }

                    is Resource.Loading -> {
                        _uiState = _uiState.copy(
                            isLikesLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _uiState = _uiState.copy(
                            likes = result.value,
                            isLikesLoading = false
                        )
                    }
                }
            }
        }
    }

    private fun getUserCollections(username: String) {
        viewModelScope.launch {
            userRepository.getUserCollections(username = username).collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _uiState = _uiState.copy(
                            collectionsError = result.error,
                            isCollectionsLoading = false
                        )
                    }

                    is Resource.Loading -> {
                        _uiState = _uiState.copy(
                            isCollectionsLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _uiState = _uiState.copy(
                            collections = result.value,
                            isCollectionsLoading = false
                        )
                    }
                }
            }
        }
    }


}