Feature: Authentication feature test

  @PriorityTinggi
  Scenario Outline: Login dengan kredensial yang valid
    Given buka halaman login untuk pengujian valid
    When Masukkan username "<username>" dan password "<password>" valid
    And Klik tombol login valid
    Then Pengguna berhasil masuk ke halaman produk

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |

  Scenario Outline: Login dengan kredensial yang tidak valid
    Given buka halaman login untuk pengujian tidak valid
    When Masukkan username "<username>" dan password "<password>" tidak valid
    And Klik tombol login tidak valid
    Then muncul pesan error login gagal

    Examples:
      | username      | password     |
      | standard_user | standard_user |
