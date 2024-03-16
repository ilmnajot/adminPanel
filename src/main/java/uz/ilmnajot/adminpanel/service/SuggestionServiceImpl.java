package uz.ilmnajot.adminpanel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.ilmnajot.adminpanel.entity.Suggestion;
import uz.ilmnajot.adminpanel.exception.BaseException;
import uz.ilmnajot.adminpanel.exception.SuggestionException;
import uz.ilmnajot.adminpanel.model.common.ApiResponse;
import uz.ilmnajot.adminpanel.model.dto.SuggestionDto;
import uz.ilmnajot.adminpanel.repository.SuggestionRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

    private final SuggestionRepository suggestionRepository;

    @Override
    public ApiResponse postSuggestion(SuggestionDto request) {
        Suggestion suggestion = new Suggestion();

        suggestion.setFullName(request.getFullName());
        suggestion.setPhoneNumber(request.getPhoneNumber());
        suggestion.setTelegramLink("t.me//" + request.getPhoneNumber());

        suggestionRepository.save(suggestion);
        return new ApiResponse("success", true);
    }

    @Override
    public ApiResponse updateSuggestion(SuggestionDto request, Long id) {
        Optional<Suggestion> optionalSuggestion = suggestionRepository.findById(id);
        if (optionalSuggestion.isEmpty()) {
            throw new SuggestionException("Suggestion with id " + id + " does not exist", HttpStatus.NOT_FOUND);
        }
        Suggestion suggestion = optionalSuggestion.get();
        suggestion.setDescription(request.getDescription());
        suggestion.setRead(request.isRead());
        suggestionRepository.save(suggestion);
        return new ApiResponse("success", true);
    }

    @Override
    public ApiResponse getAllSuggestion(int page, int size) {
        Page<Suggestion> suggestions = suggestionRepository.findAll(PageRequest.of(page, size));
        if (suggestions.isEmpty()) {
            throw new SuggestionException("no comments found", HttpStatus.NOT_FOUND);
        }
        Map<String, Object> response = new HashMap<>();
        response.put("suggestion_list", suggestionDtoList(suggestions.toList()));
        response.put("currentPage", suggestions.getNumber());
        response.put("totalPages", suggestions.getTotalPages());
        response.put("totalItems", suggestions.getTotalElements());
        return new ApiResponse("success", true, response);
    }

    public static SuggestionDto toDto(Suggestion suggestion) {
        SuggestionDto dto = new SuggestionDto();

        dto.setFullName(suggestion.getFullName());
        dto.setPhoneNumber(suggestion.getPhoneNumber());
        dto.setDescription(suggestion.getDescription());
        dto.setRead(suggestion.isRead());
        dto.setCreatedAt(suggestion.getCreatedAt());

        return dto;
    }

    public static List<SuggestionDto> suggestionDtoList(List<Suggestion> suggestions) {
        List<SuggestionDto> suggestionDtoList = new ArrayList<>();

        for (Suggestion suggestion : suggestions) {
            suggestionDtoList.add(toDto(suggestion));
        }
        return suggestionDtoList;
    }

}
