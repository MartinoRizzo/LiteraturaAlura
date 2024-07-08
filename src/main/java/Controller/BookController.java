package Controller;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/find")
    public ResponseEntity<?> findBookByTitle(@RequestParam String title) {
        Book book = bookService.findBookByTitle(title);
        if (book == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
        return ResponseEntity.ok(book);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        if (bookService.bookExists(book.getTitle())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Book already exists");
        }
        bookService.saveBook(book);
        return ResponseEntity.status(HttpStatus.CREATED).body("Book added");
    }

    @GetMapping("/list")
    public List<Book> listAllBooks() {
        return bookService.findAllBooks();
    }

    @GetMapping("/authors")
    public List<Author> listAllAuthors() {
        return bookService.findAllAuthors();
    }

    @GetMapping("/authors/alive")
    public List<Author> listAuthorsAliveInYear(@RequestParam int year) {
        return bookService.findAuthorsAliveInYear(year);
    }

    @GetMapping("/language")
    public List<Book> listBooksByLanguage(@RequestParam String language) {
        return bookService.findBooksByLanguage(language);
    }
}

