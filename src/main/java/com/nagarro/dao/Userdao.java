package com.nagarro.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.entity.Userscred;

public interface Userdao extends JpaRepository<Userscred,Integer> {
	//custom finder mehtods
	public Userscred findByEmailAndPassword(String email,String password);
	public Userscred findByEmail(String email);

}
