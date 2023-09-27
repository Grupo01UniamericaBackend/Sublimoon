package br.com.Sublimoon.pi.controller;
import br.com.Sublimoon.pi.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ItemController {

    @Autowired
    final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }


}
