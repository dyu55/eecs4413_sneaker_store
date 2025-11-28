package edu.yorku.sneaker_store_backend.service;

import edu.yorku.sneaker_store_backend.dto.AuthResponseDto;
import edu.yorku.sneaker_store_backend.dto.LoginRequestDto;
import edu.yorku.sneaker_store_backend.dto.RegisterRequestDto;
import edu.yorku.sneaker_store_backend.model.Customer;
import edu.yorku.sneaker_store_backend.repository.CustomerRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Contains the primary registration and login workflows for customers.
 */
@Service
public class AuthService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(CustomerRepository customerRepository, PasswordEncoder passwordEncoder) {
        this.customerRepository = customerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registers a brand-new customer account.
     * <p>
     * Usage: populate {@link RegisterRequestDto} from the signup form and call this method.
     * It validates unique email addresses, hashes the provided password with BCrypt, stores
     * address/phone metadata, then returns {@link AuthResponseDto} describing the created account.
     */
    public AuthResponseDto register(RegisterRequestDto request) {
        if (!hasText(request.getEmail()) || !hasText(request.getPassword())) {
            throw new IllegalArgumentException("Email and password are required");
        }
        if (customerRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }

        Customer customer = Customer.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .addressLine1(request.getAddressLine1())
                .addressLine2(request.getAddressLine2())
                .city(request.getCity())
                .province(request.getProvince())
                .postalCode(request.getPostalCode())
                .country(request.getCountry())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .build();

        Customer saved = customerRepository.save(customer);
        return successResponse(saved, "Registration successful");
    }

    /**
     * Authenticates an existing customer by email+password combination.
     * <p>
     * Usage: populate {@link LoginRequestDto} from the login form, call this method, and act on the
     * returned {@link AuthResponseDto}. Consumers should handle {@link IllegalArgumentException}
     * to detect invalid credentials and translate them into HTTP 401/400 responses.
     */
    public AuthResponseDto login(LoginRequestDto request) {
        if (!hasText(request.getEmail()) || !hasText(request.getPassword())) {
            throw new IllegalArgumentException("Email and password are required");
        }

        Customer customer = customerRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));

        if (!passwordEncoder.matches(request.getPassword(), customer.getPasswordHash())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        return successResponse(customer, "Login successful");
    }

    private AuthResponseDto successResponse(Customer customer, String message) {
        return AuthResponseDto.builder()
                .success(true)
                .message(message)
                .customerId(customer.getId())
                .token(generateToken())
                .build();
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }

    private boolean hasText(String value) {
        return value != null && !value.isBlank();
    }
}
