package com.docvault.controller;

import com.docvault.dto.*;
import com.docvault.service.AzureSearchService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/search")
@Tag(name = "Search", description = "Azure AI Search document search and indexing")
public class SearchController {

    private final AzureSearchService searchService;

    public SearchController(AzureSearchService searchService) {
        this.searchService = searchService;
    }

    @GetMapping
    @Operation(summary = "Search documents with semantic ranking and facets")
    public ResponseEntity<SearchResponseDto> search(
            @RequestParam(defaultValue = "*") String q,
            @RequestParam(required = false)   String department,
            @RequestParam(required = false)   String tier,
            @RequestParam(required = false)   String dateFrom,
            @RequestParam(required = false)   String dateTo,
            @RequestParam(defaultValue = "0") int from,
            @RequestParam(defaultValue = "20")int size) {

        SearchRequestDto req = new SearchRequestDto();
        req.setQ(q); req.setDepartment(department); req.setTier(tier);
        req.setDateFrom(dateFrom); req.setDateTo(dateTo);
        req.setFrom(from); req.setSize(size);

        return ResponseEntity.ok(searchService.search(req));
    }

    @GetMapping("/suggest")
    @Operation(summary = "Autocomplete suggestions")
    public ResponseEntity<Map<String, List<String>>> suggest(@RequestParam String q) {
        return ResponseEntity.ok(Map.of("suggestions", searchService.suggest(q)));
    }

    @PostMapping("/index")
    @Operation(summary = "Index or re-index a document")
    public ResponseEntity<Void> index(@RequestBody Map<String, Object> doc) {
        searchService.indexDocument(doc);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove a document from the search index")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        searchService.deleteDocument(id);
        return ResponseEntity.noContent().build();
    }
}
