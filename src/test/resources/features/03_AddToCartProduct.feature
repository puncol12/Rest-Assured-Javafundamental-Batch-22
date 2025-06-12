Feature: Keranjang Belanja

  Scenario: Tambah produk ke keranjang
    Given Login dengan user valid
    When Klik tombol Add to Cart pada salah satu produk
    Then Klik ikon keranjang
