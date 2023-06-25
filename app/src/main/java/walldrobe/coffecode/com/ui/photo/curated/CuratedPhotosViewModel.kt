package walldrobe.coffecode.com.ui.photo.curated

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import walldrobe.coffecode.com.domain.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel
class CuratedPhotosViewModel @Inject constructor(
     photoRepository: PhotoRepository
): ViewModel() {


    val curatedPhotosPaging = photoRepository.getTopicPhotos("wallpapers").cachedIn(viewModelScope)
}