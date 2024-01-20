package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UOMRepositoryTestIT {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void findByUom() {
        Optional<UnitOfMeasure> unitOfMeasureOptional=unitOfMeasureRepository.findByUom("ounce");
        assertEquals("ounce",unitOfMeasureOptional.get().getUom());
    }

    @Test
    public void findByUomPinch() {
        Optional<UnitOfMeasure> unitOfMeasureOptional=unitOfMeasureRepository.findByUom("pinch");
        assertEquals("pinch",unitOfMeasureOptional.get().getUom());
    }
}