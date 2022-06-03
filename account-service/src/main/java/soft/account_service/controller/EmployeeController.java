package soft.account_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import soft.account_service.document.EmployeeDoc;
import soft.account_service.repository.EmployeeRepository;
import soft.account_service.utility.EmployeeMapper;
import soft.ecommercelib.dto.account.EmployeeDto;

import javax.annotation.PostConstruct;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeRepository employeeRepository;

    @PostConstruct
    public void init() {
        employeeRepository.deleteAll();
        employeeRepository.save(
                EmployeeDoc.builder()
                        .username("adam")
                        .address("employee address")
                        .email("employee email")
                        .mobileNumber("employee mobileNumber")
                        .build()
        );
    }

    @GetMapping("/employees/{username}")
    public EmployeeDto findByUsername(@PathVariable String username) {
        return employeeRepository.findByUsername(username)
                .map(EmployeeMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }
}
