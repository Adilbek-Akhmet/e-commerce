package soft.account_service.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import soft.account_service.repository.CustomerRepository;
import soft.account_service.utility.CustomerMapper;
import soft.ecommercelib.dto.account.CustomerDto;

import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerRepository customerRepository;

    @GetMapping("/customers/{username}")
    public CustomerDto findByUsername(@PathVariable String username) {
        return customerRepository.findByUsername(username)
                .map(CustomerMapper::toDto)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

}
