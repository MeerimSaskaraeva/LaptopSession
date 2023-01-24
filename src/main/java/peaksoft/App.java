package peaksoft;

import peaksoft.config.DatabaseConnection;
import peaksoft.model.Laptop;
import peaksoft.service.LaptopService;
import peaksoft.service.LaptopServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       // DatabaseConnection.createEntityManagerFactory();
        LaptopService laptopService=new LaptopServiceImpl();

//        System.out.println(laptopService.saveProgrammer( new Laptop("Asus", OperationSystem.WINDOWS, 64, 15000, LocalDate.of(2022, 04, 03))));
////
//  List<Laptop>laptops=new ArrayList<>(Arrays.asList(new Laptop("Mac Book",OperationSystem.MACOS,132,20000,LocalDate.of(2022,04,05))));
//       laptopService.saveAll(laptops).forEach(System.out::println);
//        System.out.println(laptopService.deleteById(1L));
//       laptopService.deleteById(1L);
//        laptopService.deleteAll();
//        System.out.println(laptopService.findAll());
//        System.out.println(laptopService.update(52L, new Laptop("Asus", OperationSystem.WINDOWS, 232, 30000, LocalDate.of(2023, 03, 04))));
        System.out.println(laptopService.groupBy());
    }

}
