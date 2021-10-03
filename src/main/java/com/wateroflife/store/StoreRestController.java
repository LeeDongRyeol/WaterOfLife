package com.wateroflife.store;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/store")
@RequiredArgsConstructor
public class StoreRestController {

    private final StoreService storeService;


    @GetMapping("/{storeId}")
    public ResponseEntity getStore(@PathVariable Long storeId){

        Store store = storeService.findById(storeId);


        return ResponseEntity.ok(store);
    }

    @PostMapping
    public ResponseEntity saveStore(@RequestBody Store newStore){

        storeService.saveStore(newStore);

        return ResponseEntity.ok(newStore);

    }
}
