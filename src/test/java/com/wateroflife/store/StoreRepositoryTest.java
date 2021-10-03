package com.wateroflife.store;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class StoreRepositoryTest {

    @Autowired
    StoreRepository storeRepository;

    @Test
    @DisplayName("매장 저장 테스트")
    @Order(1)
    public void saveStoreTest(){

        for (int i = 0; i < 10; i++) {
            Store store = Store.builder()
                    .location("서울 특별시 " + i +"번지")
                    .brand("이마트")
                    .name("name"+i)
                    .tel("010-"+i)
                    .build();

            Store newStore = storeRepository.save(store);

        }

    }

    @Test
    @DisplayName("매장 이름으로 매장 검색")
    @Order(2)
    public void findByStoreName(){
        List<Store> storeList = this.storeRepository.findByBrand("이마트");

        for(Store store : storeList){
            System.out.println(store.toString());

        }

    }

}