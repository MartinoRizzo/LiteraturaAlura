package service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public Book findBookByTitle(String title) {
        return bookRepository.findByTitle(title).orElse(null);
    }

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> findAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> findBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    public List<Author> findAuthorsAliveInYear(int year) {
        LocalDate startOfYear = LocalDate.of(year, 1, 1);
        LocalDate endOfYear = LocalDate.of(year, 12, 31);
        return authorRepository.findByBirthDateBeforeAndDeathDateAfter(startOfYear, endOfYear);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public boolean bookExists(String title) {
        return bookRepository.findByTitle(title).isPresent();
    }
}

