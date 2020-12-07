package practiceOL.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import practiceOL.Beans.Item;

/**
 * Item repository JPA
 * 
 * @author alons
 *
 */
public interface ItemDBrepository extends JpaRepository<Item, Integer> {

}
