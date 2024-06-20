package com.job.comapany.job.service;

import com.job.comapany.job.domain.MenuItem;
import com.job.comapany.job.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MenuItemServiceItemImp implements MenuItemService {
    @Autowired
    private final MenuRepository repository;

    @Override
    public void addMenuItems(MenuItem menuItem) {
        repository.save(menuItem);
    }

    @Override
    public List fetchMenu() {
        return repository.findAll();
    }
}
