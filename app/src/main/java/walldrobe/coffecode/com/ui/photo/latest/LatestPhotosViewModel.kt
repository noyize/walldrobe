package walldrobe.coffecode.com.ui.photo.latest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import walldrobe.coffecode.com.domain.repository.PhotoRepository
import javax.inject.Inject

@HiltViewModel()
class LatestPhotosViewModel @Inject constructor(
     photoRepository: PhotoRepository
): ViewModel() {
    
    val latestPhotosPaging = photoRepository.getPaginatedLatestPhotos().cachedIn(viewModelScope)
}