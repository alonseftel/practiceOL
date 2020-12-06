package practiceOL.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import practiceOL.Beans.Item;


public interface ItemDBrepository extends JpaRepository<Item, Integer>{
	
	

}
