package walldrobe.coffecode.com.ui.search

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import walldrobe.coffecode.com.domain.repository.CollectionRepository
import walldrobe.coffecode.com.domain.repository.PhotoRepository
import walldrobe.coffecode.com.domain.repository.SearchRepository
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchRepository: SearchRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private var _uiState by mutableStateOf(SearchUiState.DEFAULT)
    val uiState get() = _uiState


    init {
        savedStateHandle.get<String>("query")?.let {
            _uiState = _uiState.copy(query = it)
            search()
        }
    }

    fun updateQuery(query: String) {
        _uiState = _uiState.copy(query = query)
    }

    fun search() {
        viewModelScope.launch {
            val query = _uiState.query
            searchPhotos(query = query)
            searchCollections(query = query)
            searchUsers(query = query)
        }
    }

    private fun searchPhotos(query: String) {
        _uiState = _uiState.copy(
            photos = searchRepository.searchPhotos(query).cachedIn(viewModelScope)
        )
    }

    private fun searchCollections(query: String) {
        _uiState = _uiState.copy(
            collections = searchRepository.searchCollections(query).cachedIn(viewModelScope)
        )
    }

    private fun searchUsers(query: String) {
        _uiState = _uiState.copy(
            users = searchRepository.searchUsers(query).cachedIn(viewModelScope)
        )
    }

    fun clearSearch() {
        _uiState = SearchUiState.DEFAULT
    }

}