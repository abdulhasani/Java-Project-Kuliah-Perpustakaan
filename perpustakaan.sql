-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Waktu pembuatan: 23. Desember 2012 jam 13:13
-- Versi Server: 5.5.16
-- Versi PHP: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `perpustakaan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `anggota`
--

CREATE TABLE IF NOT EXISTS `anggota` (
  `idAnggota` int(11) NOT NULL AUTO_INCREMENT,
  `nomorAnggota` varchar(30) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `noIdentitas` varchar(30) NOT NULL,
  `jenisIdentitas` varchar(10) NOT NULL,
  `alamat` text NOT NULL,
  `idKategotiAnggota` int(11) DEFAULT NULL,
  `keterangan` text NOT NULL,
  PRIMARY KEY (`idAnggota`),
  KEY `idKategotiAnggota` (`idKategotiAnggota`),
  KEY `nomorAnggota` (`nomorAnggota`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

--
-- Dumping data untuk tabel `anggota`
--

INSERT INTO `anggota` (`idAnggota`, `nomorAnggota`, `nama`, `noIdentitas`, `jenisIdentitas`, `alamat`, `idKategotiAnggota`, `keterangan`) VALUES
(1, '0001', 'Abdul Kadir Hasani', '100304046', 'KTM', 'langkap', 3, 'Free'),
(2, '0002', 'Mamet', '1003040040', 'KTM', 'Brebes', 2, 'Free'),
(3, '0003', 'Arif Ardian Riza S', '1003040045', 'KTM', 'Bumiayu', 4, 'Free'),
(4, '0004', 'Tegar Utomo', '1003040035', 'KTM', 'Cilacap', 3, 'Free'),
(5, '0005', 'Dede Rubi Yanto', '54321', 'KTP', 'Wangon', 4, 'Free'),
(6, '0006', 'Budi Sudarsono', '12344321', 'KTP', 'Cilacap', 5, 'Free');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE IF NOT EXISTS `buku` (
  `idBuku` int(11) NOT NULL AUTO_INCREMENT,
  `judul` varchar(50) NOT NULL,
  `pengarang` varchar(50) NOT NULL,
  `penerbit` varchar(50) NOT NULL,
  `tahunTerbit` varchar(5) NOT NULL,
  `idKategoriBuku` int(11) DEFAULT NULL,
  `sinopsis` text NOT NULL,
  `jumlahStok` int(11) NOT NULL,
  `jumlahTersedia` int(11) NOT NULL,
  `keterangan` text NOT NULL,
  PRIMARY KEY (`idBuku`),
  KEY `idKategoriBuku` (`idKategoriBuku`),
  KEY `judul` (`judul`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`idBuku`, `judul`, `pengarang`, `penerbit`, `tahunTerbit`, `idKategoriBuku`, `sinopsis`, `jumlahStok`, `jumlahTersedia`, `keterangan`) VALUES
(1, ' Java Dasar', 'JMat', 'JMat', '2012', 1, 'Free', 5, 5, 'Bla Bla'),
(2, 'Java Fundamental', 'JMat', 'JMat', '2012', 1, 'Bla Bla', 5, 5, 'Bla Bla'),
(3, 'Semar Mesem', 'Pringgading', 'Pringgading', '2012', 5, 'Bla', 5, 5, 'Bla'),
(4, 'Biologi', 'Hero', 'Laborat Biologi', '2012', 3, 'Bla', 5, 5, 'Bla'),
(5, 'Anatomi Tubuh', 'Tubuh', 'UMP', '2012', 3, 'Bla', 10, 10, 'Bla'),
(6, 'Sastra Indonesia', 'Moh Hatta', 'Djaya Karta', '1992', 5, 'Bla Bla', 10, 10, 'Bla Bla'),
(7, 'Basis Data', 'Mamet', 'JMat', '2012', 1, 'Bla bla', 5, 5, 'Bla Bla');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detilKeuanganPeminjaman`
--

CREATE TABLE IF NOT EXISTS `detilKeuanganPeminjaman` (
  `nomorAnggota` varchar(30) NOT NULL,
  `IdBuku` int(11) NOT NULL,
  KEY `nomorAnggota` (`nomorAnggota`),
  KEY `IdBuku` (`IdBuku`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detilKeuanganPeminjaman`
--

INSERT INTO `detilKeuanganPeminjaman` (`nomorAnggota`, `IdBuku`) VALUES
('0006', 1),
('0006', 2),
('0006', 3),
('0001', 1),
('0001', 2),
('0001', 4);

-- --------------------------------------------------------

--
-- Struktur dari tabel `detilKeUanganPendendaan`
--

CREATE TABLE IF NOT EXISTS `detilKeUanganPendendaan` (
  `id` bigint(20) NOT NULL,
  `keterangan` text NOT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `detilKeUanganPendendaan`
--

INSERT INTO `detilKeUanganPendendaan` (`id`, `keterangan`) VALUES
(1354823027819, ' Java Dasar, Telat 1 Hari '),
(1354823027819, 'Java Fundamental, Telat 1 Hari '),
(1354949190810, ' Java Dasar, Telat 1 Hari '),
(1354949190810, 'Java Fundamental, Telat 1 Hari ');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detilPeminjaman`
--

CREATE TABLE IF NOT EXISTS `detilPeminjaman` (
  `peminjamanId` bigint(20) unsigned NOT NULL,
  `bukuId` int(11) NOT NULL,
  `status` varchar(20) DEFAULT NULL,
  KEY `bukuId` (`bukuId`),
  KEY `peminjamanId` (`peminjamanId`,`bukuId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategorianggota`
--

CREATE TABLE IF NOT EXISTS `kategorianggota` (
  `IdKategoriAnggota` int(11) NOT NULL AUTO_INCREMENT,
  `Nama` varchar(30) NOT NULL,
  `keterangan` text NOT NULL,
  PRIMARY KEY (`IdKategoriAnggota`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data untuk tabel `kategorianggota`
--

INSERT INTO `kategorianggota` (`IdKategoriAnggota`, `Nama`, `keterangan`) VALUES
(2, 'Karyawan', 'Bla bla'),
(3, 'Dosen', 'Bla bla'),
(4, 'Guru', 'Bla bla'),
(5, 'Pelajar', 'Bla Bla Bla');

-- --------------------------------------------------------

--
-- Struktur dari tabel `kategori_buku`
--

CREATE TABLE IF NOT EXISTS `kategori_buku` (
  `IdKategoriBuku` int(11) NOT NULL AUTO_INCREMENT,
  `Nama` varchar(30) NOT NULL,
  `Keterangan` text NOT NULL,
  PRIMARY KEY (`IdKategoriBuku`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data untuk tabel `kategori_buku`
--

INSERT INTO `kategori_buku` (`IdKategoriBuku`, `Nama`, `Keterangan`) VALUES
(1, 'Komputer', 'Bla Bla'),
(2, 'Kimia', 'Bla Bla'),
(3, 'Ilmu Pengetahuan Alam', 'Bla Bla'),
(4, 'Ilmu Pengetahuan Sosial', 'Bla Bla'),
(5, 'Sastra', 'Bla Bla Bla');

-- --------------------------------------------------------

--
-- Struktur dari tabel `keuanganDenda`
--

CREATE TABLE IF NOT EXISTS `keuanganDenda` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nomorAnggota` varchar(30) NOT NULL,
  `tanggalPendendaan` varchar(20) NOT NULL,
  `nominalDenda` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nomorAnggota` (`nomorAnggota`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1354949190811 ;

--
-- Dumping data untuk tabel `keuanganDenda`
--

INSERT INTO `keuanganDenda` (`id`, `nomorAnggota`, `tanggalPendendaan`, `nominalDenda`) VALUES
(1354823027819, '0006', '2012-12-14', 4000),
(1354949190810, '0001', '2012-12-15', 4000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `keuanganPeminjaman`
--

CREATE TABLE IF NOT EXISTS `keuanganPeminjaman` (
  `id` bigint(20) NOT NULL,
  `nomorAnggota` varchar(30) NOT NULL,
  `jumlahItem` int(11) NOT NULL,
  `tanggalPemasukan` varchar(20) NOT NULL,
  `nominalPemasukan` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `nomorAnggota` (`nomorAnggota`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `keuanganPeminjaman`
--

INSERT INTO `keuanganPeminjaman` (`id`, `nomorAnggota`, `jumlahItem`, `tanggalPemasukan`, `nominalPemasukan`) VALUES
(1354822944607, '0006', 3, '2012-12-07', 21000),
(1354948936339, '0001', 2, '2012-12-08', 14000),
(1354949088943, '0001', 1, '2012-12-08', 7000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `peminjaman`
--

CREATE TABLE IF NOT EXISTS `peminjaman` (
  `idPeminjaman` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `tglPinjam` date NOT NULL,
  `tglHarusKembali` date NOT NULL,
  `nomorAnggota` varchar(30) NOT NULL,
  `keterangan` text,
  PRIMARY KEY (`idPeminjaman`),
  KEY `nomorAnggota` (`nomorAnggota`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengembalian`
--

CREATE TABLE IF NOT EXISTS `pengembalian` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nomorAnggota` varchar(30) NOT NULL,
  `judulBuku` varchar(50) NOT NULL,
  `ketentuanTglKembali` date NOT NULL,
  `tanggalKembali` date NOT NULL,
  KEY `idPeminjam` (`id`,`judulBuku`),
  KEY `nomorAnggota` (`nomorAnggota`),
  KEY `judulBuku` (`judulBuku`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=1354949164784 ;

--
-- Dumping data untuk tabel `pengembalian`
--

INSERT INTO `pengembalian` (`id`, `nomorAnggota`, `judulBuku`, `ketentuanTglKembali`, `tanggalKembali`) VALUES
(1354949148160, '0001', 'Biologi', '2012-12-14', '2012-12-08'),
(1354949164694, '0001', ' Java Dasar', '2012-12-14', '2012-12-15'),
(1354949164783, '0001', 'Java Fundamental', '2012-12-14', '2012-12-15');

-- --------------------------------------------------------

--
-- Struktur dari tabel `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `Id_User` int(11) NOT NULL AUTO_INCREMENT,
  `Nama_User` varchar(20) NOT NULL,
  `Password` varchar(15) NOT NULL,
  PRIMARY KEY (`Id_User`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data untuk tabel `user`
--

INSERT INTO `user` (`Id_User`, `Nama_User`, `Password`) VALUES
(1, 'sani', 'inas'),
(2, 'Fikri', 'fikri');

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `anggota`
--
ALTER TABLE `anggota`
  ADD CONSTRAINT `anggota_ibfk_1` FOREIGN KEY (`idKategotiAnggota`) REFERENCES `kategorianggota` (`IdKategoriAnggota`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD CONSTRAINT `buku_ibfk_1` FOREIGN KEY (`idKategoriBuku`) REFERENCES `kategori_buku` (`IdKategoriBuku`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `detilKeuanganPeminjaman`
--
ALTER TABLE `detilKeuanganPeminjaman`
  ADD CONSTRAINT `detilKeuanganPeminjaman_ibfk_2` FOREIGN KEY (`IdBuku`) REFERENCES `buku` (`idBuku`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `detilKeuanganPeminjaman_ibfk_3` FOREIGN KEY (`nomorAnggota`) REFERENCES `keuanganPeminjaman` (`nomorAnggota`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `detilKeUanganPendendaan`
--
ALTER TABLE `detilKeUanganPendendaan`
  ADD CONSTRAINT `detilKeUanganPendendaan_ibfk_1` FOREIGN KEY (`id`) REFERENCES `keuanganDenda` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `detilPeminjaman`
--
ALTER TABLE `detilPeminjaman`
  ADD CONSTRAINT `detilPeminjaman_ibfk_4` FOREIGN KEY (`bukuId`) REFERENCES `buku` (`idBuku`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `detilPeminjaman_ibfk_5` FOREIGN KEY (`peminjamanId`) REFERENCES `peminjaman` (`idPeminjaman`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `keuanganPeminjaman`
--
ALTER TABLE `keuanganPeminjaman`
  ADD CONSTRAINT `keuanganPeminjaman_ibfk_3` FOREIGN KEY (`nomorAnggota`) REFERENCES `anggota` (`nomorAnggota`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_ibfk_1` FOREIGN KEY (`nomorAnggota`) REFERENCES `anggota` (`nomorAnggota`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Ketidakleluasaan untuk tabel `pengembalian`
--
ALTER TABLE `pengembalian`
  ADD CONSTRAINT `pengembalian_ibfk_1` FOREIGN KEY (`nomorAnggota`) REFERENCES `anggota` (`nomorAnggota`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `pengembalian_ibfk_2` FOREIGN KEY (`judulBuku`) REFERENCES `buku` (`judul`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
