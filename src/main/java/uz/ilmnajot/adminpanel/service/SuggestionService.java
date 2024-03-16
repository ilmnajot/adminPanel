package uz.ilmnajot.adminpanel.service;

import uz.ilmnajot.adminpanel.model.common.ApiResponse;
import uz.ilmnajot.adminpanel.model.dto.SuggestionDto;

public interface SuggestionService {

    ApiResponse postSuggestion(SuggestionDto request);

    ApiResponse updateSuggestion(SuggestionDto request, Long id);

    ApiResponse getAllSuggestion(int page,int size);
}
