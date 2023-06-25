package walldrobe.coffecode.com.ui.dashboard

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import walldrobe.coffecode.com.app.util.Resource
import walldrobe.coffecode.com.domain.repository.PhotoRepository
import walldrobe.coffecode.com.domain.repository.TopicRepository
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val photoRepository: PhotoRepository,
    private val topicRepository: TopicRepository
) : ViewModel() {

    private var _uiState = mutableStateOf(DashboardUiState.DEFAULT)
    val uiState get() = _uiState

    init {
        getBannerPhotos()
        getLatestPhotos()
        getCuratedPhotos()
        getTopics()
    }


    private fun getBannerPhotos() {
        viewModelScope.launch {
            photoRepository.getBanners().collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _uiState.value = _uiState.value.copy(
                            isBannerPhotosLoading = false,
                            bannerPhotosError = result.error
                        )
                    }

                    is Resource.Loading -> {
                        _uiState.value = _uiState.value.copy(
                            isBannerPhotosLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _uiState.value = _uiState.value.copy(
                            isBannerPhotosLoading = false,
                            bannerPhotos = result.value
                        )
                    }
                }
            }
        }
    }

    private fun getLatestPhotos() {
        viewModelScope.launch {
            photoRepository.getLatestPhotos().collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _uiState.value =
                            _uiState.value.copy(
                                latestPhotosError = result.error,
                                isLatestPhotosLoading = false
                            )
                    }

                    is Resource.Loading -> {
                        _uiState.value = _uiState.value.copy(isLatestPhotosLoading = true)
                    }

                    is Resource.Success -> {
                        _uiState.value = _uiState.value.copy(
                            isLatestPhotosLoading = false,
                            latestPhotos = result.value
                        )
                    }
                }
            }
        }
    }

    private fun getCuratedPhotos() {
        viewModelScope.launch {
            photoRepository.getCuratedPhotos().collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _uiState.value = _uiState.value.copy(
                            isCuratedPhotosLoading = false,
                            curatedPhotosError = result.error
                        )
                    }

                    is Resource.Loading -> {
                        _uiState.value = _uiState.value.copy(
                            isCuratedPhotosLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _uiState.value = _uiState.value.copy(
                            isCuratedPhotosLoading = false,
                            curatedPhotos = result.value
                        )
                    }
                }
            }
        }
    }

    private fun getTopics() {
        viewModelScope.launch {
            topicRepository.getTopics().collectLatest { result ->
                when (result) {
                    is Resource.Error -> {
                        _uiState.value = _uiState.value.copy(
                            isTopicsLoading = false,
                            topicsError = result.error
                        )
                    }

                    is Resource.Loading -> {
                        _uiState.value = _uiState.value.copy(
                            isTopicsLoading = true
                        )
                    }

                    is Resource.Success -> {
                        _uiState.value = _uiState.value.copy(
                            isTopicsLoading = false,
                            topics = result.value
                        )
                    }
                }
            }
        }
    }
}

