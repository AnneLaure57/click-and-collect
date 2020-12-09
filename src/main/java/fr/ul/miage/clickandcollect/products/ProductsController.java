package fr.ul.miage.clickandcollect.products;

import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService service;

    @GetMapping
    public Iterable<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "50") int size) {

        return service.findPaged(page, size);
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public Product create(@RequestBody Product p) {
        return null;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

    }

    @PutMapping("{id}")
    public Product update(@RequestBody Product p, @PathVariable Long id) {
        return null;
    }
}

