package com.nisum.NisumAssignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

@Service
public class InventoryService {
    private final Map<Long, Item> items = new ConcurrentHashMap<>();
    private final AtomicLong nextId = new AtomicLong(1);

    public List<Item> getAllItems() {
        return new ArrayList<>(items.values());
    }

    public Item getItemById(Long id) {
        Item item = items.get(id);
        if (item == null) {
            throw new ResourceNotFoundException("Item not found with id: " + id);
        }
        return item;
    }

    public Item createItem(Item item) {
        item.setId(nextId.getAndIncrement());
        items.put(item.getId(), item);
        return item;
    }

    public Item updateItem(Long id, Item item) {
        if (!items.containsKey(id)) {
            throw new ResourceNotFoundException("Item not found with id: " + id);
        }
        item.setId(id);
        items.put(id, item);
        return item;
    }

    public void deleteItem(Long id) {
        if (!items.containsKey(id)) {
            throw new ResourceNotFoundException("Item not found with id: " + id);
        }
        items.remove(id);
    }
}
