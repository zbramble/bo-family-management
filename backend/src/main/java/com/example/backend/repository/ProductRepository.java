package com.example.backend.repository;


import com.example.backend.model.Product;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class ProductRepository {

    private static void sleepExecution(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public List<Product> getAllProducts() {
        return IntStream.rangeClosed(1, 5).
                peek(ProductRepository::sleepExecution).
                peek(i -> System.out.println("processing count: " + i)).
                mapToObj(i -> new Product(i, "Customer" + i)).toList();
    }

    public Flux<Product> getAllProductsStream() {
        return Flux.range(1, 5).
                delayElements(Duration.ofSeconds(1)).
                doOnNext(i -> System.out.println("processing count in stream flow: " + i)).
                map(i -> new Product(i, "customer" + i));
    }

}
