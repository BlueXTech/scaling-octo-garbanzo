package com.example.demo.controller;

import com.example.demo.model.Tale;
import com.example.demo.model.TaleMetadata;
import com.example.demo.service.TaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tale")
public class TaleController {

    @Autowired
    private TaleService taleService;

    @GetMapping("/{taleId}")
    public Tale getTaleByTaleId(@PathVariable String taleId) {
        return taleService.getTaleByTaleId(taleId);
    }

    @GetMapping("/metadata/{cursor}")
    public List<TaleMetadata> getTalesMetadataPage(@PathVariable String cursor) {
        return taleService.getTalesMetadataPage(cursor);
    }

    @GetMapping("/metadata/{userId}")
    public List<TaleMetadata> getTalesMetadataPageByUserId(@PathVariable String userId) {
        return taleService.getTalesMetadataPageByUserId(userId);
    }

    @PostMapping("/new")
    public Tale createTale(@RequestBody Tale tale) {
        return taleService.createTale(tale);
    }

    @PutMapping("/edit")
    public Tale updateTale(@RequestBody Tale tale) {
        return taleService.updateTale(tale);
    }

    @DeleteMapping("/{taleId}")
    public String deleteTaleByTaleId(@PathVariable String taleId) {
        return taleService.deleteTaleByTaleId(taleId);
    }

}
