package walldrobe.coffecode.com.ui.photo.detail

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
import walldrobe.coffecode.com.domain.model.Photo
import walldrobe.coffecode.com.domain.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel
class PhotoDetailViewModel @Inject constructor(
    private val photoRepository: PhotoRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _uiState by mutableStateOf(PhotoDetailState.DEFAULT)
    val uiState get() = _uiState

    init {
       savedStateHandle.get<Photo>("photo")?.let {
           getPhoto(it.id)
       }
    }

    private fun getPhoto(id: String) = viewModelScope.launch {
        photoRepository.getPhoto(id).collectLatest { result ->
            when (result) {
                is Resource.Error -> {
                    _uiState = _uiState.copy(
                        isPhotoLoading = false,
                        error = result.error
                    )
                }

                is Resource.Loading -> {
                    _uiState = _uiState.copy(
                        isPhotoLoading = true
                    )
                }

                is Resource.Success -> {
                    _uiState = _uiState.copy(
                        isPhotoLoading = false,
                        photo = result.value
                    )
                }
            }
        }
    }
}