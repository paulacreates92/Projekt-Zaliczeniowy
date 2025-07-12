# Projekt-Zaliczeniowy

Projekt zaliczeniowy do kursu **Tester Automatyzujący** w CodersLab.

## Zadanie 1 – Selenium WebDriver + Cucumber

🔗 Strona testowa: [mystore-testlab.coderslab.pl](https://mystore-testlab.coderslab.pl)

### Cel:
Automatyzacja procesu dodania nowego adresu użytkownika oraz jego weryfikacji.

### Scenariusz testowy:
1. Zaloguj się na wcześniej utworzonego ręcznie użytkownika.
2. Kliknij w kafelek **"Addresses"** po zalogowaniu.  
   👉 Docelowy URL: `https://mystore-testlab.coderslab.pl/index.php?controller=addresses`
3. Kliknij przycisk **"+ Create new address"**.
4. Wypełnij formularz **New address** – dane powinny pochodzić z tabeli `Examples` w Gherkinie:
   - Alias
   - Address
   - City
   - Zip/Postal code
   - Country
   - Phone
5. Sprawdź, czy dane w dodanym adresie są poprawne.

### 🔹 Dodatkowe kroki (dla chętnych):
- Usuń dodany adres klikając **"Delete"**.
- Zweryfikuj, czy adres został pomyślnie usunięty.

---

## Zadanie 2 – Proces zakupu produktu

### Cel:
Automatyzacja zakupu produktu oraz weryfikacja poprawności transakcji.

### Scenariusz testowy:
1. Zaloguj się na tego samego użytkownika z Zadania 1.
2. Znajdź produkt **Hummingbird Printed Sweater**.
3. (Opcjonalnie) Sprawdź, czy rabat wynosi **20%**.
4. Wybierz rozmiar **M**.  
   👉 Parametryzacja: umożliw wybór spośród `S`, `M`, `L`, `XL`.
5. Wybierz **5 sztuk** produktu.  
   👉 Parametryzacja: liczba sztuk podawana w teście.
6. Dodaj produkt do koszyka.
7. Przejdź do sekcji **Checkout**.
8. Potwierdź wcześniej dodany adres dostawy.
9. Wybierz metodę odbioru: **Pick up in store** (PrestaShop).
10. Wybierz metodę płatności: **Pay by Check**.
11. Kliknij **"Order with an obligation to pay"**.
12. Zrób **screenshot potwierdzenia zamówienia i kwoty**.

### 🔹 Dodatkowe kroki (dla chętnych):
- Wejdź w **historię zamówień i szczegóły**:
  1. Kliknij nazwę zalogowanego użytkownika.
  2. Przejdź do kafelka **Order history**.
- Zweryfikuj, czy:
  - Zamówienie znajduje się na liście.
  - Status to **"Awaiting check payment"**.
  - Kwota zgadza się z tą z potwierdzenia zamówienia.

---
