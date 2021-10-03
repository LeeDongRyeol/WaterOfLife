package com.wateroflife.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StoreService {

    private final StoreRepository storeRepository;

    public Store findById(Long storeId) {

        return storeRepository.findById(storeId).orElse(null);
    }


    public Store saveStore(Store newStore) {

        return storeRepository.save(newStore);
    }
}
