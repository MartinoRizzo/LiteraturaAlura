package model;


@Entity
@Data // Si usas Lombok
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String lastName;

    private String firstName;

    private LocalDate birthDate;

    private LocalDate deathDate;

    // Otros campos relevantes
}

