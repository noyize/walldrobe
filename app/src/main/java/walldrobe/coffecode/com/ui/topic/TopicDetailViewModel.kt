package walldrobe.coffecode.com.ui.topic

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import walldrobe.coffecode.com.domain.repository.PhotoRepository
import walldrobe.coffecode.com.domain.model.Topic
import javax.inject.Inject

@HiltViewModel
class TopicDetailViewModel @Inject constructor(
    photoRepository: PhotoRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val id = savedStateHandle.get<Topic>("topic")?.id.orEmpty()
    val topicPhotosPaging = photoRepository.getTopicPhotos(id).cachedIn(viewModelScope)
}