package br.com.sublimoon.pi.controller;
import br.com.sublimoon.pi.entity.Item;
import br.com.sublimoon.pi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping(value = "/api/item")
public class ItemController {

    @Autowired
    final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Optional<Item>> findByIdItem(@PathVariable("id") final   Long id) {
        Optional<Item> item = this.itemRepository.findById(id);
        return ResponseEntity.ok(item);
    }
}
