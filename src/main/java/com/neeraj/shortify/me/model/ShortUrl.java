package com.neeraj.shortify.me.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.id.enhanced.SequenceStyleGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShortUrl {

    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            type = SequenceStyleGenerator.class,
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private Long id;

    @Column(name = "SHORT_ID")
    String shortId;
    @Column(name = "REDIRECT_URL")
    String redirectUrl;
    @Column(name = "VISIT_HISTORY")
    List<LocalDateTime> visitHistory;

    @Column(name = "CREATED_ON")
    LocalDateTime createdOn;

    @Column(name = "EXPIRES_ON")
    LocalDateTime expiresOn;

}
