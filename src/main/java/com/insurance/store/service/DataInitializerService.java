package com.insurance.store.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.insurance.store.model.Comment;
import com.insurance.store.model.CommentVotePolicy;
import com.insurance.store.model.CommenttVoteApprovalStatus;
import com.insurance.store.model.Order;
import com.insurance.store.model.Product;
import com.insurance.store.model.Provider;
import com.insurance.store.model.User;
import com.insurance.store.model.Vote;
import com.insurance.store.repository.CommentRepository;
import com.insurance.store.repository.OrderRepository;
import com.insurance.store.repository.ProductRepository;
import com.insurance.store.repository.ProviderRepository;
import com.insurance.store.repository.UserRepository;
import com.insurance.store.repository.VoteRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataInitializerService {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final ProviderRepository providerRepository;
    private final CommentRepository commentRepository;
    private final VoteRepository voteRepository;
    private final OrderRepository orderRepository;

    private final List<User> users = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();
    private final List<Provider> providers = new ArrayList<>();
    private final List<Comment> comments = new ArrayList<>();
    private final List<Vote> votes = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    @PostConstruct
    public void initializeData() {
        initializeUsers();
        initializeProviders();
        initializeProducts();
        initializeComments();
        initializeVotes();
        initializeOrders();
    }

    private void initializeUsers() {
        User user1 = new User();
        user1.setName("User 1");
        user1.setUsername("user1");
        user1.setPassword("password1");
        user1.setEmail("user1@example.com");
        users.add(userRepository.save(user1));

        User user2 = new User();
        user2.setName("User 2");
        user2.setUsername("user2");
        user2.setPassword("password2");
        user2.setEmail("user2@example.com");
        users.add(userRepository.save(user2));

        // Add more users as needed
    }

    private void initializeProviders() {
        Provider provider1 = new Provider();
        provider1.setName("Provider 1");
        provider1.setAddress("Provider 1 Address");
        providers.add(providerRepository.save(provider1));

        Provider provider2 = new Provider();
        provider2.setName("Provider 2");
        provider2.setAddress("Provider 2 Address");
        providers.add(providerRepository.save(provider2));

        // Add more providers as needed
    }

    private void initializeProducts() {
        Product product1 = new Product();
        product1.setName("Product 1");
        product1.setDescription("Sample product 1");
        product1.setVisible(true);
        product1.setCommentPolicy(CommentVotePolicy.ENABLED_AFTER_PURCHASE_CONFIRMATION);
        product1.setVotePolicy(CommentVotePolicy.ENABLED_FOR_ALL);
        product1.setImageUrl("sample_image_url_1");
        products.add(productRepository.save(product1));

        Product product2 = new Product();
        product2.setName("Product 2");
        product2.setDescription("Sample product 2");
        product2.setVisible(true);
        product2.setCommentPolicy(CommentVotePolicy.DISABLED);
        product2.setVotePolicy(CommentVotePolicy.ENABLED_AFTER_PURCHASE_CONFIRMATION);
        product2.setImageUrl("sample_image_url_2");
        products.add(productRepository.save(product2));

        // Add more products as needed
    }

    private void initializeComments() {
        for (Product product : products) {
            for (int i = 1; i <= 10; i++) {
                Comment comment = new Comment();
                comment.setUser(getRandomUser());
                comment.setProduct(product);
                comment.setText("Comment " + i);
                comment.setStatus(CommenttVoteApprovalStatus.APPROVED );
                comments.add(commentRepository.save(comment));
            }
        }

        // Add more comments as needed
    }

    private void initializeVotes() {
        for (Product product : products) {
            for (int i = 1; i <= 10; i++) {
                Vote vote = new Vote();
                vote.setUser(getRandomUser());
                vote.setProduct(product);
                vote.setRating(4.5f);
                vote.setApprovalStatus(CommenttVoteApprovalStatus.APPROVED );
                votes.add(voteRepository.save(vote));
            }
        }

        // Add more votes as needed
    }

    private void initializeOrders() {
        for (Product product : products) {
            for (int i = 1; i <= 10; i++) {
                Order order = new Order();
                order.setUser(getRandomUser());
                order.setProduct(product);
                order.setPurchaseDate(getRandomPurchaseDate());
                orders.add(orderRepository.save(order));
            }
        }

        // Add more orders as needed
    }

    private User getRandomUser() {
        // Retrieve a random user from the saved users list
        // Modify this method implementation according to your requirements
        return users.get(getRandomIndex(users.size()));
    }

    private LocalDateTime getRandomPurchaseDate() {
        // Generate a random purchase date for orders
        // Modify this method implementation according to your requirements
        return LocalDateTime.now();
    }

    private int getRandomIndex(int size) {
        return (int) (Math.random() * size);
    }
}
