package com.mbakara.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // For building final Objects.
@AllArgsConstructor
@NoArgsConstructor
public class EmailDetails { // This emailDetails is just to contain number of properties.


    private String recipient; // Here is the recipient of the Email.
    private String messageBody; // Here Message itself that is to be sent.
    private String subject;
}
