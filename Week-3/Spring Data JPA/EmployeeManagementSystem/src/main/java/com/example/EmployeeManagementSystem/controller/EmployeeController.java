package com.example.EmployeeManagementSystem.controller;
import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.query.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepo;

    @PostMapping
    public Employee save(@RequestBody Employee e) {
        return employeeRepo.save(e);
    }

    @GetMapping
    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id) {
        return employeeRepo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee emp) {
        return employeeRepo.findById(id).map(existing -> {
            existing.setName(emp.getName());
            existing.setEmail(emp.getEmail());
            existing.setDepartment(emp.getDepartment());
            return ResponseEntity.ok(employeeRepo.save(existing));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeRepo.deleteById(id);
    }

    @GetMapping("/page")
    public Page<Employee> getEmployeesPage(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy) {
        return employeeRepo.findAll(PageRequest.of(page, size, Sort.by(sortBy)));
    }

}
