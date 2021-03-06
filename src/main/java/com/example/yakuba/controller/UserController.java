package com.example.yakuba.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.yakuba.entity.Customer;
import com.example.yakuba.model.CustomerForm;
import com.example.yakuba.service.AccountService;
import com.example.yakuba.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class UserController {
    @Autowired
    private CustomerService customerService;
    @Autowired
    AccountService accountService;

    /** 顧客一覧画面 */
    @GetMapping("/index")
    public String getIndex(Model model) {
        List<Customer> customer = accountService.findCreateUser();
        String userName = accountService.displayUserName();
        model.addAttribute("userName", "アカウント" + userName + "さん");
        model.addAttribute("customer", customer);
        return "customer/index";
    }

    /** 新規登録画面 */
    @GetMapping("/new")
    public String newCustomer(Model model, CustomerForm customerForm) {
        Customer customer = new Customer();
        String userName = accountService.displayUserName();
        model.addAttribute("userName", "アカウント" + userName + "さん");
        model.addAttribute("customer", customer);
        return "customer/new";
    }

    /** 編集画面 */
    @GetMapping("{id}/edit")
    public String edit(@PathVariable Long id, Model model, CustomerForm customerForm) {
        Customer customer = customerService.findById(id);
        customerForm = convertModelToForm(customerForm, customer);
        String userName = accountService.displayUserName();
        model.addAttribute("userName", "アカウント" + userName + "さん");

        return "customer/edit";
    }

    /** 詳細画面 */
    @GetMapping("{id}")
    public String show(@PathVariable Long id, Model model) {
        Customer customer = customerService.findById(id);
        String userName = accountService.displayUserName();
        model.addAttribute("userName", "アカウント" + userName + "さん");
        model.addAttribute("customer", customer);
        return "customer/show";
    }

    /** 保存処理 */
    @PostMapping("/create")
    public String create(@Valid @ModelAttribute CustomerForm customerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "customer/new";

        Customer customer = convertFormToModel(customerForm, new Customer());
        customerService.saveAndFlush(customer);
        return "redirect:/customer/index";
    }

    /** 更新処理 */
    @PutMapping("{id}")
    public String update(@PathVariable Long id, @ModelAttribute Customer customer) {
        customer.setId(id);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        customer.setUserName(userName);
        customerService.saveAndFlush(customer);

        return "redirect:/customer/index";
    }

    /** 削除処理 */
    @DeleteMapping("{id}")
    public String destroy(@PathVariable Long id) {
        customerService.deleteById(id);
        return "redirect:/customer/index";
    }

    /** 顧客検索画面 */
    @PostMapping("/search")
    public ModelAndView seach(Model model, @RequestParam String keyword) {
        ModelAndView mv = new ModelAndView();
        List<Customer> list = customerService.findCustomers(keyword);
        String userName = accountService.displayUserName();
        model.addAttribute("userName", "アカウント" + userName + "さん");

        mv.addObject("list", list);
        mv.setViewName("customer/search");

        return mv;
    }

    /** 検索画面初期表示 */
    @GetMapping("/search")
    public ModelAndView seach(Model model) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("customer/search");
        String userName = accountService.displayUserName();
        model.addAttribute("userName", "アカウント" + userName + "さん");

        return mv;
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
        /* ログインしているuserName保存 */
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String userName = auth.getName();
        customer.setUserName(userName);

        return customer;
    }

    /** Entity -> Form */
    private CustomerForm convertModelToForm(CustomerForm customerForm, Customer customer) {
        customerForm.setId(customer.getId());
        customerForm.setNameSei(customer.getNameSei());
        customerForm.setNameMei(customer.getNameMei());
        customerForm.setNameMei(customer.getNameMei());
        customerForm.setPrefecture(customer.getPrefecture());
        customerForm.setBirthDay(customer.getBirthDay());
        customerForm.setResidence(customer.getResidence());
        customerForm.setGender(customer.getGender());

        return customerForm;
    }
}