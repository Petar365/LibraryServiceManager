//package com.example.libraryservicemanager.model.DataInitializer;
//
//import com.example.libraryservicemanager.model.Book;
//import com.example.libraryservicemanager.model.BorrowedBooks;
//import com.example.libraryservicemanager.model.User;
//import com.example.libraryservicemanager.model.enumeration.Role;
//import com.example.libraryservicemanager.model.enumeration.Status;
//import com.example.libraryservicemanager.repository.BookRepository;
//import com.example.libraryservicemanager.repository.BorrowedBooksRepository;
//import com.example.libraryservicemanager.repository.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//
//@Component
//public class DataInitializer implements CommandLineRunner {
//
//    private final BookRepository bookRepository;
//    private final UserRepository userRepository;
//    private final BorrowedBooksRepository borrowedBooksRepository;
//
//    public DataInitializer(BookRepository bookRepository, UserRepository userRepository, BorrowedBooksRepository borrowedBooksRepository) {
//        this.bookRepository = bookRepository;
//        this.userRepository = userRepository;
//        this.borrowedBooksRepository = borrowedBooksRepository;
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        // Initialize users if the database is empty
//        if (userRepository.count() == 0) {
//            User user1 = new User(null, "John Doe", "john.doe@example.com", Role.USER, LocalDateTime.now(), LocalDateTime.now(), null);
//            User user2 = new User(null, "Jane Smith", "jane.smith@example.com", Role.USER, LocalDateTime.now(), LocalDateTime.now(), null);
//            User user3 = new User(null, "Robert Brown", "robert.brown@example.com", Role.USER, LocalDateTime.now(), LocalDateTime.now(), null);
//            User user4 = new User(null, "Emily White", "emily.white@example.com", Role.USER_ADMIN, LocalDateTime.now(), LocalDateTime.now(), null);
//            userRepository.save(user1);
//            userRepository.save(user2);
//            userRepository.save(user3);
//            userRepository.save(user4);
//        }
//
//        // Initialize books if the database is empty
//        if (bookRepository.count() == 0) {
//            Book book1 = new Book(null, "Spring Boot in Action", "Craig Walls", "9781617292545", 10, LocalDateTime.now(), null);
//            Book book2 = new Book(null, "Learning Java", "Patrick Niemeyer", "9781449365035", 5, LocalDateTime.now(), null);
//            Book book3 = new Book(null, "To Kill a Mockingbird", "Harper Lee", "9780061120084", 5, LocalDateTime.now(), null);
//            Book book4 = new Book(null, "Moby Dick", "Herman Melville", "9781503280786", 3, LocalDateTime.now(), null);
//            Book book5 = new Book(null, "War and Peace", "Leo Tolstoy", "9781420954303", 7, LocalDateTime.now(), null);
//
//            bookRepository.save(book1);
//            bookRepository.save(book2);
//            bookRepository.save(book3);
//            bookRepository.save(book4);
//            bookRepository.save(book5);
//        }
//
//        // Initialize borrowed books (now that books are saved and we can fetch them by ID)
//        if (borrowedBooksRepository.count() == 0) {
//            // Retrieve saved books and users
//            Book book1 = bookRepository.findById(1L).orElseThrow(() -> new RuntimeException("Book not found"));
//            Book book2 = bookRepository.findById(2L).orElseThrow(() -> new RuntimeException("Book not found"));
//            User user1 = userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));
//            User user2 = userRepository.findById(2L).orElseThrow(() -> new RuntimeException("User not found"));
//
//            BorrowedBooks borrowedBooks1 = new BorrowedBooks(null, user1, book1, LocalDate.now().minusDays(2), LocalDate.now().plusDays(5), Status.BORROWED);
//            BorrowedBooks borrowedBooks2 = new BorrowedBooks(null, user2, book2, LocalDate.now().minusDays(1), LocalDate.now().plusDays(3), Status.BORROWED);
//
//            borrowedBooksRepository.save(borrowedBooks1);
//            borrowedBooksRepository.save(borrowedBooks2);
//        }
//    }
//}
