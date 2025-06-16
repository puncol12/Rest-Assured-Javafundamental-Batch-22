Feature: Proses Checkout

  Scenario: Tambah produk ke keranjang
    Given Login dengan user valid
    When Klik tombol Add to Cart pada salah satu produk
    Then Klik ikon keranjang

  Scenario: Lanjut ke proses checkout
    Given Klik Checkout
    When Masukkan informasi pelanggan firt name "yusuf" dan last name "nur" dan postal code "123456"
    Then Klik Continue

  Scenario: Selesaikan proses checkout
    Given Lanjut dari ringkasan pembelian
    When Klik tombol Finish
    Then Muncul pesan "THANK YOU FOR YOUR ORDER"
