Feature: Proses Checkout

  Scenario: Lanjut ke proses checkout
    Given Login user valid
    When Tambah produk ke keranjang
    And Klik keranjang
    And Klik Checkout
    And Masukkan informasi pelanggan firt name "<first-name>" dan last name "<last-name>" dan postal code "<postal-code>"
    Then Klik Continue

    Examples:
    |   first-name  |   last-name   |   postal-code |
    |   yusuf       |   nur         |   12345       |