package peaksoft.service;

import peaksoft.OperationSystem;
import peaksoft.dao.LaptopDao;
import peaksoft.dao.LaptopDaoImpl;
import peaksoft.model.Laptop;

import java.util.List;
import java.util.Map;

public class LaptopServiceImpl implements LaptopService{
    LaptopDao laptopDao=new LaptopDaoImpl();
    @Override
    public Laptop saveProgrammer(Laptop laptop) {
       return laptopDao.saveProgrammer(laptop);

    }

    @Override
    public List<Laptop> saveAll(List<Laptop> laptops) {
       return laptopDao.saveAll(laptops);

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
       return laptopDao.findAll();

    }

    @Override
    public Laptop update(Long id, Laptop laptop) {

        return laptopDao.update(id,laptop);
    }

    @Override
    public Map<OperationSystem, List<Laptop>> groupBy() {
        return laptopDao.groupBy();
    }

    @Override
    public List<Laptop> sortByDifferentColumn(String column, String ascOrDesc) {
        return null;
    }
}
