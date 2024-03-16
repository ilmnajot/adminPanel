package uz.ilmnajot.adminpanel.model.dto;

import lombok.*;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuggestionDto {

    private String fullName;

    private String phoneNumber;

    private String description;

    private boolean read;

    private Timestamp createdAt;


}
