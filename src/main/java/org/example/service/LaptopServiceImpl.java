package org.example.service;

import org.example.dao.LaptopDao;
import org.example.dao.LaptopDaoImpl;
import org.example.entity.Laptop;

import java.util.List;
import java.util.Map;

public class LaptopServiceImpl implements LaptopService{
private final LaptopDao laptopDao = new LaptopDaoImpl();

    @Override
    public Laptop saveProgrammer(Laptop laptop) {
     return laptopDao.saveProgrammer(laptop);
    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
        return null;
    }

    @Override
    public Laptop deleteById(Long id) {
        return laptopDao.deleteById(id);
    }

    @Override
    public void deleteAll() {
        laptopDao.deleteAll();

    }

    @Override
    public List<Laptop> findAll() {
        return null;
    }

    @Override
    public Laptop update(Long id, Laptop laptop) {
        return null;
    }

    @Override
    public Map<String, List<Laptop>> groupBy() {
        return null;
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        return null;
    }
}
