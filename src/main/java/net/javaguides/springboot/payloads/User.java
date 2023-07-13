package net.javaguides.springboot.payloads;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private Long userId;
    private String firstName;
    private String latName;
}
