package edu.yorku.sneaker_store_backend.controller;

import edu.yorku.sneaker_store_backend.model.Sneaker;
import edu.yorku.sneaker_store_backend.service.SneakerService;
<<<<<<< HEAD
=======
import edu.yorku.sneaker_store_backend.service.dto.SneakerQueryParams;
import org.springframework.http.ResponseEntity;
>>>>>>> dev
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sneakers")
@CrossOrigin("*") // allow frontend access
public class SneakerController {

    private final SneakerService service;

    public SneakerController(SneakerService service) {
        this.service = service;
    }

    @GetMapping
<<<<<<< HEAD
    public List<Sneaker> getAll() {
        return service.getAllSneakers();
    }

=======
    public List<Sneaker> list(
            @RequestParam(name = "q", required = false) String keyword,
            @RequestParam(name = "brand", required = false) String brand,
            @RequestParam(name = "colorway", required = false) String colorway,
            @RequestParam(name = "category", required = false) String category,
            @RequestParam(name = "genre", required = false) String genre,
            @RequestParam(name = "sortBy", required = false) String sortBy,
            @RequestParam(name = "direction", required = false) String direction
    ) {
        SneakerQueryParams params = SneakerQueryParams.builder()
                .keyword(keyword)
                .brand(brand)
                .colorway(colorway)
                .category(category)
                .genre(genre)
                .sortBy(sortBy)
                .sortDirection(direction)
                .build();
        return sneakerService.find(params);
    }

    /**
     * GET /api/sneakers/{id}
     * Retrieves a sneaker by its ID.
     */
>>>>>>> dev
    @GetMapping("/{id}")
    public Sneaker getOne(@PathVariable Long id) {
        return service.getById(id);
    }

<<<<<<< HEAD
=======
    /**
     * GET /api/sneakers/brand/{brand}
     * Filters sneakers by brand name.
     */
    @GetMapping("/brand/{brand}")
    public List<Sneaker> byBrand(@PathVariable String brand) {
        return sneakerService.findByBrand(brand);
    }

    /**
     * POST /api/sneakers
     * Creates a new sneaker entry.
     */
>>>>>>> dev
    @PostMapping
    public Sneaker create(@RequestBody Sneaker s) {
        return service.save(s);
    }
}
