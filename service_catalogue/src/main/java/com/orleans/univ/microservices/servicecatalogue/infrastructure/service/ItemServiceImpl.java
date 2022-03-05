package com.orleans.univ.microservices.servicecatalogue.infrastructure.service;

import com.orleans.univ.microservices.servicecatalogue.domain.ItemRepository;
import com.orleans.univ.microservices.servicecatalogue.infrastructure.mapper.ItemMapper;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemDto;
import org.springframework.stereotype.Service;


@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;


    public ItemServiceImpl(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    @Override
    public ItemDto create(ItemDto itemDto) {
        var item = this.itemMapper.map(itemDto);
        var savedItem=  this.itemRepository.save(item);
        System.out.println("zebbiiii");

        return this.itemMapper.map(savedItem);

    }
}
