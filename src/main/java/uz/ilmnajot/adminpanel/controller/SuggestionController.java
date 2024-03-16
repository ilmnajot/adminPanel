package uz.ilmnajot.adminpanel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.ilmnajot.adminpanel.model.common.ApiResponse;
import uz.ilmnajot.adminpanel.model.dto.SuggestionDto;
import uz.ilmnajot.adminpanel.service.SuggestionService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/suggestions")
public class SuggestionController {

    private final SuggestionService suggestionService;


    @GetMapping("/getAll")
    public HttpEntity<ApiResponse> getAllSuggestion(@RequestParam(name = "page", defaultValue = "0") int page,
                                                     @RequestParam(name = "size", defaultValue = "9") int size){
        ApiResponse suggestion = suggestionService.getAllSuggestion(page, size);
        return suggestion != null
                ? ResponseEntity.status(HttpStatus.OK).body(suggestion)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @PostMapping("/post")
    public HttpEntity<ApiResponse> postSuggestion(@RequestBody SuggestionDto dto){
        ApiResponse suggestion = suggestionService.postSuggestion(dto);
        return suggestion != null
                ? ResponseEntity.status(HttpStatus.OK).body(suggestion)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    @PutMapping("/updateSuggestion/{id}")
    public HttpEntity<ApiResponse> updateSuggestion(@RequestBody SuggestionDto request, @PathVariable Long id){
        ApiResponse suggestion = suggestionService.updateSuggestion(request, id);
        return suggestion != null
                ? ResponseEntity.status(HttpStatus.OK).body(suggestion)
                : ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
