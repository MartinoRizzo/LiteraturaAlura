package service;

@Service
public class GutendexService {

    private final String API_URL = "https://gutendex.com/books";

    public BookDto searchBookByTitle(String title) {
        RestTemplate restTemplate = new RestTemplate();
        String url = API_URL + "?title=" + title;
        ResponseEntity<GutendexResponse> response = restTemplate.getForEntity(url, GutendexResponse.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            List<BookDto> books = response.getBody().getResults();
            if (!books.isEmpty()) {
                return books.get(0);
            }
        }
        return null;
    }
}

