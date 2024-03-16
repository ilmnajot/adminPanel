package uz.ilmnajot.adminpanel.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Suggestion {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY )
    private Long id;

    private String fullName;

    private String phoneNumber;//+998911979798

    private String description;

    private boolean read;

    private String telegramLink;//   t.me//+998911979798

    @CreationTimestamp
    private Timestamp createdAt;

}
