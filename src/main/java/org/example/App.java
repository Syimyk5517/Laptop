package org.example;

import org.example.dao.LaptopDaoImpl;
import org.example.entity.Laptop;
import org.example.service.LaptopService;
import org.example.service.LaptopServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        LaptopService laptopService = new LaptopServiceImpl();
//        System.out.println(laptopService.saveProgrammer(new Laptop("Asus", "bhj", 5, 20000, LocalDate.of(2022,10,22))));
//        System.out.println(laptopService.saveProgrammer(new Laptop("Asus", "bhj", 5, 40000, LocalDate.of(2022,10,22))));
//        System.out.println(laptopService.saveProgrammer(new Laptop("Asus", "bhj", 5, 50000, LocalDate.of(2022,10,22))));
//        System.out.println(laptopService.saveProgrammer(new Laptop("Asus", "bhj", 5, 230000, LocalDate.of(2022,10,22))));
////        laptopService.deleteAll();
//        LaptopDaoImpl laptopDao = new LaptopDaoImpl();

//        laptopDao.saveMy();
        System.out.println(laptopService.sortByDifferentColumn("price", "asc"));
    }
}
