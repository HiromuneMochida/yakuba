package com.example.yakuba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.yakuba.entity.Customer;
import com.example.yakuba.model.CustomerForm;
import com.example.yakuba.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class UserController {
	@Autowired
	private CustomerService customerService;

	/*顧客一覧画面**/
	@GetMapping("/index")
	public String getIndex(Model model) {
		List<Customer> customer = customerService.findAll();
		model.addAttribute("customer", customer);
		return "index";
	}

	/*新規登録画面**/
	@GetMapping("/new")
	public String newCustomer(Model model, CustomerForm customerForm) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "new";
	}

	/*ToDo編集画面**/
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model, CustomerForm customerForm) {
		Customer customer = customerService.findById(id);
		model.addAttribute("customer", customer);
		return "edit";
	}

	/**ToDo詳細画面*/
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		Customer customer = customerService.findById(id);
		model.addAttribute("customer", customer);
		return "show";
	}

	/**保存処理*/
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute CustomerForm customerForm, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "new";
		//add
		Customer customer = convertFormToModel(customerForm, new Customer());
		customerService.saveAndFlush(customer);
		return "redirect:/customer/index";
	}

	/*更新処理**/
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Customer customer) {
		customer.setId(id);
		customerService.saveAndFlush(customer);
		return "redirect:/customer/index";
	}

	/*削除処理**/
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		customerService.deleteById(id);
		return "redirect:/customer/index";
	}

	/** Form -> Entity */
	private Customer convertFormToModel(CustomerForm customerForm, Customer customer) {
		customer.setId(customerForm.getId());
		customer.setNameSei(customerForm.getNameSei());
		customer.setNameMei(customerForm.getNameMei());
		customer.setPrefecture(customerForm.getPrefecture());
		customer.setBirthDay(customerForm.getBirthDay());
		customer.setResidence(customerForm.getResidence());
		customer.setGender(customerForm.getGender());

		return customer;
	}
	/** Entity -> Form */
}