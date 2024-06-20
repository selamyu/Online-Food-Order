package com.job.comapany.job.service;

import com.job.comapany.job.domain.MenuItem;

import java.util.List;

public interface MenuItemService {
    void addMenuItems(MenuItem menuItem);

    List fetchMenu();
}
