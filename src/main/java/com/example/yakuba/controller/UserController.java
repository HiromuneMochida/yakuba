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

import com.example.yakuba.entity.Custmoer;
import com.example.yakuba.service.CustmoerService;

@Controller
@RequestMapping("/custmoer")
public class UserController {
	@Autowired
	private CustmoerService custmoerService;

	/*顧客一覧画面**/
	@GetMapping("/index")
	public String getIndex(Model model) {
		List<Custmoer> custmoer = custmoerService.findAll();
		model.addAttribute("custmoer", custmoer);
		return "index";
	}

	/*新規登録画面**/
	@GetMapping("/new")
	public String newCustmoer(Model model) {
		Custmoer custmoer = new Custmoer();
		model.addAttribute("custmoer", custmoer);
		return "new";
	}

	/*ToDo編集画面**/
	@GetMapping("{id}/edit")
	public String edit(@PathVariable Long id, Model model) {
		Custmoer custmoer = custmoerService.findById(id);
		model.addAttribute("custmoer", custmoer);
		return "edit";
	}

	/**ToDo詳細画面*/
	@GetMapping("{id}")
	public String show(@PathVariable Long id, Model model) {
		Custmoer custmoer = custmoerService.findById(id);
		model.addAttribute("custmoer", custmoer);
		return "show";
	}

	/**保存処理*/
	@PostMapping("/create")
	public String create(@Valid @ModelAttribute Custmoer custmoer, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "new";
		custmoerService.saveAndFlush(custmoer);
		return "redirect:/custmoer/index";
	}

	/*更新処理**/
	@PutMapping("{id}")
	public String update(@PathVariable Long id, @ModelAttribute Custmoer custmoer) {
		custmoer.setId(id);
		custmoerService.saveAndFlush(custmoer);
		return "redirect:/custmoer/index";
	}

	/*削除処理**/
	@DeleteMapping("{id}")
	public String destroy(@PathVariable Long id) {
		custmoerService.deleteById(id);
		return "redirect:/custmoer/index";
	}
}