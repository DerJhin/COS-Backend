package com.cos.capybara.Benutzer.Records;

import java.sql.Blob;

public record CreateBenutzer(String username, String email, Blob profilePicture) {
}
