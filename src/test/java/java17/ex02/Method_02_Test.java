package java17.ex02;

import java.util.List;

import org.junit.Test;

import java17.data.Data;
import java17.data.Person;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

    // tag::IDao[]
    interface IDao {

        List<Person> findAll();

        // Retourne par exemple : "[20 persons]"
        default String format() {
            return "[" + findAll().size() + " persons]";
        }
    }
    // end::IDao[]

    // tag::DaoA[]
    class DaoA implements IDao {

        List<Person> people = Data.buildPersonList(20);

        @Override
        public List<Person> findAll() {
            return people;
        }

        // Retourne par exemple : "DaoA[20 persons]"
        // en réutilisant la méthode default de l'interface
        @Override
        public String format() {
            return getClass().getSimpleName() + IDao.super.format();
        }
    }
    // end::DaoA[]

    @Test
    public void test_daoA_format() throws Exception {

        DaoA daoA = new DaoA();

        String result = daoA.format();

        assert "DaoA[20 persons]".equals(result);
    }
}