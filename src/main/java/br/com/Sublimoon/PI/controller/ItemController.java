package br.com.Sublimoon.PI.controller;

import br.com.Sublimoon.PI.entity.Produto;
import br.com.Sublimoon.PI.repository.ItemRepository;
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
