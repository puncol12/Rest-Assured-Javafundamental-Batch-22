Feature: Authentication feature test

  @PriorityTinggi
  Scenario Outline: Login dengan kredensial yang valid
    Given buka halaman login
    When Masukkan username "<username>" dan password "<password>" valid
    And Klik tombol login
    Then Pengguna berhasil masuk ke halaman produk

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
