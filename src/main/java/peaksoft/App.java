package peaksoft;

import peaksoft.config.DatabaseConnection;
import peaksoft.model.Laptop;
import peaksoft.service.LaptopService;
import peaksoft.service.LaptopServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        DatabaseConnection.createEntityManagerFactory();
        LaptopService laptopService = new LaptopServiceImpl();

        System.out.println(laptopService.saveProgrammer(new Laptop("Asus", OperationSystem.WINDOWS, 64, 15000, LocalDate.of(2022, 4, 3))));

        List<Laptop> laptops = new ArrayList<>(Collections.singletonList(new Laptop("Mac Book", OperationSystem.MACOS, 132, 20000, LocalDate.of(2022, 4, 5))));
        laptopService.saveAll(laptops).forEach(System.out::println);
        System.out.println(laptopService.deleteById(1L));
        laptopService.deleteById(1L);
        laptopService.deleteAll();
        System.out.println(laptopService.findAll());
        System.out.println(laptopService.update(52L, new Laptop("Asus", OperationSystem.WINDOWS, 232, 30000, LocalDate.of(2023, 3, 4))));
        System.out.println(laptopService.groupBy());

    }

}
