package com.orleans.univ.microservices.servicecatalogue.infrastructure.service;

import com.orleans.univ.microservices.servicecatalogue.domain.Item;
import com.orleans.univ.microservices.servicecatalogue.domain.ItemRepository;
import com.orleans.univ.microservices.servicecatalogue.infrastructure.exception.ResourseNotFoundException;
import com.orleans.univ.microservices.servicecatalogue.infrastructure.mapper.ItemMapper;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemDto;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemFilterRequest;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemListDto;
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
        return this.itemMapper.map(savedItem);
    }

    @Override
    public void delete(long id) throws ResourseNotFoundException {
        var item = this.itemRepository.findById(id);
        if (!item.isPresent()){
            throw new ResourseNotFoundException("Item not found");
        }
        this.itemRepository.delete(item.get());

    }

    @Override
    public ItemDto update(long id , ItemDto itemDto) throws ResourseNotFoundException {
        var item = this.itemRepository.findById(id);
        if (!item.isPresent()){
            throw new ResourseNotFoundException("Item not found");
        }
        item.get().setItemName(itemDto.getItemName());
        item.get().setItemType(itemDto.getItemType());
        item.get().setQuantity(itemDto.getQuantity());
        item.get().setBlob(itemDto.getBlob());
        var updatedItem = this.itemRepository.save(item.get());
        return this.itemMapper.map(updatedItem);

    }

    @Override
    public ItemDto getItem(long id) throws ResourseNotFoundException {
        var item = this.itemRepository.findById(id);
        if (!item.isPresent()){
            throw new ResourseNotFoundException("Item not found");
        }
        return this.itemMapper.map(item.get());

    }

    @Override
    public ItemListDto getAllItem() {
        var items = this.itemRepository.findAll();
        var itemListDto = this.itemMapper.mapItems(items);
        return new ItemListDto(itemListDto);
    }

    @Override
    public ItemListDto filter(ItemFilterRequest itemFilterRequest) {

        var items = this.itemRepository.findByIdIn(itemFilterRequest.getItemIds());
        var itemListDto = this.itemMapper.mapItems(items);
        return new ItemListDto(itemListDto);

    }
}
