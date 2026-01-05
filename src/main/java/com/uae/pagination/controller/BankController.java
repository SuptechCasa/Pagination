package com.uae.pagination.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseCookie;
import org.springframework.web.bind.annotation.*;

@RestController
public class BankController {

    private int balance = 1000;

    // Page de login simulée
    @GetMapping("/login")
    public String login(HttpServletResponse response) {
        // Créer un cookie de session sécurisé
        ResponseCookie cookie = ResponseCookie.from("bankSession", "user123")
                .httpOnly(true)
                .sameSite("None")  // TEST: Changez cette valeur!
                .secure(true)
                .path("/")
                .maxAge(3600)
                .build();

        response.addHeader("Set-Cookie", cookie.toString());
        return "Connecté! Cookie de session créé. Solde: " + balance + "€";
    }

    // Vérifier le solde
    @GetMapping("/balance")
    public String getBalance(@CookieValue(value = "bankSession", required = false) String session) {
        if (session == null) return "Non connecté!";
        return "Solde: " + balance + "€ (Session: " + session + ")";
    }

    // Transfert d'argent (cible CSRF)
    @PostMapping("/transfer")
    public String transferMoney(@RequestParam int amount,
                                @CookieValue(value = "bankSession", required = false) String session) {
        if (session == null) return "Échec: Non authentifié!";

        balance -= amount;
        return "Transfert réussi: " + amount + "€ débités. Nouveau solde: " + balance + "€";
    }
}
