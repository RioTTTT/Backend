package com.company;


import org.junit.Test;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

public class Main {

    @Test
    void getAccountInfoTest() {
        given()
                .headers(headers)
                .when()
                .get("https://api.imgur.com/3/account/<username>")
                .then()
                .statusCode(200);
    }
}
