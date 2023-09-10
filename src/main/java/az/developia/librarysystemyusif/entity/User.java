package az.developia.librarysystemyusif.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String username;
        private String password;
        private String name;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "role_id")
        private Role role;

        @ManyToOne
        @JoinColumn(name = "librarian_id")
        private User librarianId;

        @Column(name = "register_date")
        private LocalDateTime registerDate;

        @PrePersist
        public void prePersist() {
                registerDate = LocalDateTime.now();
        }


}
