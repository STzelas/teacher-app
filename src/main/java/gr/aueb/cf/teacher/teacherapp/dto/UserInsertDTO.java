package gr.aueb.cf.teacher.teacherapp.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserInsertDTO {

    @NotEmpty(message = "Το username δεν μπορεί να είναι κενό")
    @Size(min = 4, max = 15, message = "Το username πρέπει να είναι μεταξύ 4 και 15 χαρακτήρων")
    private String username;

    @NotEmpty(message = "Το password δεν μπορεί να είναι κενό")
    @Size(min = 4, max = 15, message = "Το password πρέπει να είναι τουλάχιστον 6 χαρακτήρες")
    private String password;

    private String role;
}
