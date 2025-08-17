# 🎬 Aplikasi Android Pencarian Film

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android_Studio-3DDC84?style=for-the-badge&logo=androidstudio&logoColor=white)
![OMDB API](https://img.shields.io/badge/OMDb_API-black?style=for-the-badge&logo=api&logoColor=white)

Aplikasi Android untuk pencarian film menggunakan **API OMDb**, dibuat dengan **Android Studio** dan bahasa pemrograman **Kotlin**. Aplikasi ini memiliki fitur lengkap mulai dari splash screen, login, pencarian film/TV show, hingga menyimpan film favorit.

---

## 📸 Tampilan Aplikasi
<table>
  <tr>
    <td><img src="screenshot-aplikasi/foto1.jpg" alt="Screenshot 1" width="100%" height="250"></td>
    <td><img src="screenshot-aplikasi/foto2.jpg" alt="Screenshot 2" width="100%" height="250"></td>
    <td><img src="screenshot-aplikasi/foto3.jpg" alt="Screenshot 3" width="100%" height="250"></td>
  </tr>
  <tr>
    <td><img src="screenshot-aplikasi/foto4.jpg" alt="Screenshot 4" width="100%" height="250"></td>
    <td><img src="screenshot-aplikasi/foto5.jpg" alt="Screenshot 5" width="100%" height="250"></td>
    <td><img src="screenshot-aplikasi/foto6.jpg" alt="Screenshot 6" width="100%" height="250"></td>
  </tr>
  <tr>
    <td><img src="screenshot-aplikasi/foto7.jpg" alt="Screenshot 7" width="100%" height="250"></td>
    <td><img src="screenshot-aplikasi/foto8.jpg" alt="Screenshot 8" width="100%" height="250"></td>
    <td><img src="screenshot-aplikasi/foto9.jpg" alt="Screenshot 9" width="100%" height="250"></td>
  </tr>
</table>

---

## ✨ Fitur Utama
- **Splash Screen** → Tampilan awal aplikasi sebelum masuk ke menu utama.  
- **Login** → Autentikasi sederhana agar pengguna bisa mengakses fitur aplikasi.  
- **Home (Popular Movies)** → Menampilkan daftar film populer.  
- **Detail Film** → Menampilkan informasi lengkap tentang film/TV show yang dipilih.  
- **Like Film Favourite** → Simpan film atau TV show ke daftar favorit.  
- **Pencarian Film & TV Show** → Cari berdasarkan judul dengan dukungan filter Movies atau TV Show.  
- **Favourite** → Halaman khusus untuk melihat daftar film/TV show yang telah disukai.  
- **Profile** → Menampilkan profil pengguna.

---

## 🛠 Teknologi yang Digunakan
- **Kotlin** (Bahasa Pemrograman)
- **Android Studio** (IDE)
- **OMDb API** (Sumber Data Film & TV Show)
- **MVVM Architecture** (opsional, jika dipakai)
- **Room Database** (untuk menyimpan data favorit secara lokal)
- **Retrofit** (untuk konsumsi API)
- **Glide/Picasso** (untuk load gambar poster film)

---

## 🚀 Instalasi
1. Clone repositori:
   ```bash
   git clone https://github.com/reykamr/bangrey-movies-trailer.git
2. Buka di Android Studio
3. Pastikan sudah memiliki API Key dari OMDb API.
4. Masukkan API Key ke dalam file gradle.properties atau langsung di Retrofit config:
   const val API_KEY = "YOUR_API_KEY"
5. Jalankan aplikasi di emulator atau perangkat Android.

---

## 📌 Catatan
- Aplikasi ini membutuhkan koneksi internet untuk melakukan pencarian film & TV show.
- Data favorit tersimpan secara lokal di perangkat menggunakan Room Database.
