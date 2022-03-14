package com.orleans.univ.microservices.servicecatalogue.web;



import com.orleans.univ.microservices.servicecatalogue.infrastructure.exception.ResourseNotFoundException;
import com.orleans.univ.microservices.servicecatalogue.infrastructure.service.ItemService;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemDto;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemFilterRequest;
import com.orleans.univ.microservices.servicecatalogue.web.dto.ItemListDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/items")
public class ItemController {

    private final ItemService itemService;


    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;

    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto){
         var savedItemDto = this.itemService.create(itemDto);
         return ResponseEntity.status(HttpStatus.CREATED).body(savedItemDto);

    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable long id){
        try {
            var itemDto  = this.itemService.getItem(id);
            return ResponseEntity.status(HttpStatus.OK).body(itemDto);
        } catch (ResourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ItemListDto> getAllItem(){
            var itemListDto  = this.itemService.getAllItem();
            return ResponseEntity.status(HttpStatus.OK).body(itemListDto);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping(value = "/filterItems")
    public ResponseEntity<ItemListDto> getFilterItem(@ModelAttribute ItemFilterRequest itemFilterRequest){
        var itemListDto  = this.itemService.filter(itemFilterRequest);
        return ResponseEntity.status(HttpStatus.OK).body(itemListDto);
    }


    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "{id}")
    public ResponseEntity<Void> updateItem(@PathVariable( value = "id" ) long id, @RequestBody ItemDto itemDto){
        try {
            this.itemService.update(id,itemDto);
            return ResponseEntity.noContent().build();
        } catch (ResourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/{id}/")
    public ResponseEntity<Void> deleteItem(@PathVariable( value = "id" ) long id){
        try {
            this.itemService.delete(id);
            return ResponseEntity.noContent().build();
        } catch (ResourseNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }


}
