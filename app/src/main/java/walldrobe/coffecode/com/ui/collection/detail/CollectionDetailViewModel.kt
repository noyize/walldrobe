package walldrobe.coffecode.com.ui.collection.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import walldrobe.coffecode.com.domain.model.Collection
import walldrobe.coffecode.com.domain.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel
class CollectionDetailViewModel @Inject constructor(
    photoRepository: PhotoRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val collectionId = savedStateHandle.get<Collection>("collection")?.id.orEmpty()
    val photos = photoRepository.getCollectionPhotos(id = collectionId)
}