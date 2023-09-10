package az.developia.librarysystemyusif.entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name = "librarians")
//@Data
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//public class Librarian {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    private String username;
//    private String password;
//    private String name;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "librarian_roles",
//            joinColumns = @JoinColumn(name = "librarian_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private List<Role> roles = new ArrayList<>();
//}
