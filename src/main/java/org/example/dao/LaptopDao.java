package org.example.dao;

import org.example.entity.Laptop;

import java.util.List;
import java.util.Map;

public interface LaptopDao extends AutoCloseable {
    Laptop saveProgrammer(Laptop laptop);

    public List<Laptop> saveAll(List<Laptop> laptops);

    public Laptop deleteById(Long id);

    public void deleteAll();

    public List<Laptop> findAll();

    public Laptop update(Long id, Laptop laptop);

    Map<String, List<Laptop>> groupBy();

    List<Laptop> sortByDifferentColumn(String column, String ascOrDesc);
}
