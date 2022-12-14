package Project_book.demo.Service;

import Project_book.demo.BookRepository.BookRepository;
import Project_book.demo.Model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements BookServiceInterface{

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Booking createBooking(Booking booking) {
        return this.bookRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        this.bookRepository.deleteById(id);

    }

    @Override
    public List<Booking> getAllBooking() {
        return bookRepository.findAll();
    }
}
