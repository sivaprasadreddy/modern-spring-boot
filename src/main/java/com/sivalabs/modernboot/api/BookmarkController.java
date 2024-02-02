package com.sivalabs.modernboot.api;

import com.sivalabs.modernboot.jdbcclient.BookmarkRepository;
import com.sivalabs.modernboot.models.Bookmark;
import com.sivalabs.modernboot.models.CreateBookmarkRequest;
import com.sivalabs.modernboot.models.UpdateBookmarkRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/bookmarks")
class BookmarkController {
    private final BookmarkRepository repository;

    BookmarkController(BookmarkRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Bookmark> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bookmark> getById(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody CreateBookmarkRequest bookmark) {
        var b = new Bookmark(null, bookmark.title(), bookmark.url(), Instant.now());
        repository.save(b);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody UpdateBookmarkRequest request) {
        var bookmark = repository.findById(id);
        if (bookmark.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        repository.update(new Bookmark(id, request.title(), request.url(), bookmark.get().createdAt()));
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.delete(id);
    }
}
