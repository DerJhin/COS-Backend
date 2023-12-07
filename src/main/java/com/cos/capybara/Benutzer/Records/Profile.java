package com.cos.capybara.Benutzer.Records;

import java.sql.Blob;

public record Profile(long id, String username, String email, double balance, Blob profilePicture) {
}
