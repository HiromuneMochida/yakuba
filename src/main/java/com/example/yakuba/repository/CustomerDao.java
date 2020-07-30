package com.example.yakuba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.yakuba.entity.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {
	/* 顧客キーワード検索 */
	@Query("select c from Customer c where c.userName=:userName and concat(c.nameSei,c.nameMei) like %:keyword% order by c.id asc")
	List<Customer> findCustomers(@Param("keyword") String keyword, @Param("userName") String userName);
	/* そのうち使う予定 */
	List<Customer> findByUserName(String userName);

}
