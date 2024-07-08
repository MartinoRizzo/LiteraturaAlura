package model;

@Entity
@Data // Si usas Lombok
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private String language;

    private int downloads;

    // Otros campos relevantes
}

