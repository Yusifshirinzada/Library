package az.developia.librarysystemyusif.request;

import az.developia.librarysystemyusif.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDetailsRequest {
    private Long id;
    private String username;
    private String password;
    private String name;
    private User librarianId;
}
