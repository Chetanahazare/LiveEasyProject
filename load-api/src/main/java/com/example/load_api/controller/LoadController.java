package com.example.load_api.controller;

import com.example.load_api.model.Load;
import com.example.load_api.service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/load")
public class LoadController {

    @Autowired
    private LoadService loadService;

    @PostMapping (path="/{loadId}")
    public ResponseEntity<String> addLoad(@RequestBody Load load) {
        loadService.addLoad(load);
        return ResponseEntity.ok("Load details added successfully");
    }

    @GetMapping
    public ResponseEntity<List<Load>> getLoads(@RequestParam Long shipperId) {
        return ResponseEntity.ok(loadService.getLoadsByShipperId(shipperId));
    }
    
    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable Long loadId) {
        Load load = loadService.getLoadById(loadId);
        if (load != null) {
            return ResponseEntity.ok(load);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{loadId}")
    public ResponseEntity<Load> updateLoad(@PathVariable Long loadId, @RequestBody Load loadDetails) {
        Load updatedLoad = loadService.updateLoad(loadId, loadDetails);
        if (updatedLoad != null) {
            return ResponseEntity.ok(updatedLoad);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable Long loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.ok("Load deleted successfully");
    }
}
