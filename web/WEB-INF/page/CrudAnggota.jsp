<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="san" %>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Perpustakaan Smart</title>
        <link rel="stylesheet" href="css/style.css" type="text/css" media="screen"/>
    </head>
    <body>
        <center>
            <marquee behavior="scroll" direction="left"><font face="Arial Black, Gadget, sans-serif" size="+3">SELAMAT DATANG
                    DIPERPUSTAKAAN SMART</font></marquee>
            <img style="width: 1005px; height: 213px;" src="img/perpustakaan.jpg" align="top" border="1" />
            <br />
            <table style="width: 1007px; height: 254px;" bgcolor="#333333" border="0">
                <!--MENU--> <tbody>
                    <tr valign="top">
                        <td align="left" height="28" width="861">
                            <table style="width: 999px; height: 35px; background-color: rgb(102, 102, 102);" border="1">
                                <tbody>
                                    <tr valign="top">
                                        <td width="259">
                                            <div align="center"> <a href="controler?/san/jmat/perpus/action=homeAdmin"><font color="#ff0000" size="+1">
                                                        <b>HOME</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="321"><div align="center"><a href="controler?/san/jmat/perpus/action=daftarAnggota"><b><font color="#ff0000" size="+1">ANGGOTA</font></b></a> </div></td>
                                        <td width="321"><div align="center"><a href="controler?/san/jmat/perpus/action=daftarPeminjaman"><b><font color="#ff0000" size="+1">TRANSAKSI</font></b></a></div></td>
                                        <td width="321">
                                            <div align="center"> 
                                                <a href="controler?/san/jmat/perpus/action=daftarBukuAdmin"><font color="#ff0000" size="+1">
                                                        <b>BUKU</b>
                                                    </font></a></div>
                                        </td>
                                        <td width="262">
                                            <div align="center"><a href="controler?/san/jmat/perpus/action=daftarPengembalian"><b><font color="#ff0000" size="+1">MANAGER MENU</font></b></a></div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                    <tr>
                    </tr>
                    <tr valign="top">
                        <td height="161">
                            <table style="width: 995px; height: 201px;" border="0" cellpadding="1" cellspacing="2">
                                <tbody>
                                    <tr>
                                        <td height="157" valign="top" width="318">
                                            <form id="form1" name="form1" method="post" action="">
                                                <table style="width: 417px; height: 189px;">
                                                    <tbody>
                                                        <tr valign="top">
                                                            <td style="width: 282px; background-color: rgb(51, 51, 51);"><br />
                                                                <table style="width: 400px; height: 193px;" border="1">
                                                                    <tbody><tr valign="top"><td style="width: 282px; background-color: rgb(51, 51, 51);"><br />

                                                                                <table style="width: 381px; height: 163px; background-color: rgb(65, 65, 65); text-align: left; margin-left: auto; margin-right: auto;">
                                                                                    <tbody>
                                                                                        <tr style="color: yellow; font-weight: bold;">
                                                                                            <td colspan="3" style="text-align: center;">PROFILE</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td style="color: yellow; font-weight: bold;" width="78">User Name</td>
                                                                                            <td style="color: rgb(255, 255, 51); font-weight: bold;" width="3">:</td>
                                                                                            <td style="color: darkorange; font-weight: bold;"width="213">${login.userName}</td>
                                                                                        </tr>
                                                                                        <tr>
                                                                                            <td></td>
                                                                                            <td></td>
                                                                                            <td>
                                                                                                <table width="262" border="0">
                                                                                                    <tr>
                                                                                                        <td width="91"><a href=""><dir align="center"><strong><font color="#FFFF00">Edit</font></strong></dir></a></td>
                                                                                                        <td width="82"><a href=""><dir align="center"><strong><font color="#FFFF00">Tambah</font></strong></dir></a></td>
                                                                                                        <td width="75"><a href="controler?/san/jmat/perpus/action=loginFinish"><dir align="center"><strong><font color="#FFFF00">Keluar</font></strong></dir></a></td>
                                                                                                    </tr> 
                                                                                                </table>
                                                                                            </td>
                                                                                        </tr>
                                                                                        <tr style="color: red;">
                                                                                            <td colspan="3" align="center">Enjoy Login</td>
                                                                                        </tr>
                                                                                    </tbody>
                                                                                </table>
                                                                            </td></tr></tbody>
                                                                </table>
                                                                <br />
                                                            </td>
                                                            <!--Akhir Login--> </tr>
                                                    </tbody>
                                                </table>
                                                <center> </center>
                                            </form>
                                        </td>
                                        <td valign="top" width="511"><br />
                                            <table style="width: 553px; height: 62px;" border="0" cellpadding="0" cellspacing="2">
                                                <tbody>
                                                    <tr>
                                                        <td align="center" valign="top" width="519"> <font color="yellow"><font style="color: yellow;" size="+1"><span style="font-family: Nimbus Sans L;">PERPUSTAKAAN
                                                                        SMART</span><br />
                                                                </font></font>
                                                            <div style="text-align: left;">
                                                                <form action="controler?/san/jmat/perpus/action=simpanAnggotaFinish&seleksi=${seleksi}" method="post">
                                                                    <table width="445" border="0" style="color:#FF0">
                                                                        <san:if test="${msg2!=null}">
                                                                            <tr>
                                                                                <td colspan="3" > <div align="center" style="color: red"><font size="+1">${msg2}</font></div> </td>
                                                                            </tr>
                                                                        </san:if>
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td>&nbsp;</td>
                                                                            <td><input type="hidden" name="idAnggota" id="idAnggota" value="${Anggota.idAnggota}" /></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td width="122">No. Anggota</td>
                                                                            <td width="9"><div align="center">:</div></td>
                                                                            <td width="300"><label for="noAnggota"></label>
                                                                                <input name="noAnggota" type="text" id="noAnggota" maxlength="30" size="35" value="${Anggota.nomorAnggota}"/></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>Nama</td>
                                                                            <td><div align="center">:</div></td>
                                                                            <td><label for="nama"></label>
                                                                                <input name="nama" type="text" id="nama" size="35" maxlength="50" value="${Anggota.nama}"/> </td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>No. Identitas</td>
                                                                            <td><div align="center">:</div></td>
                                                                            <td><label for="noIdentitas"></label>
                                                                                <input name="noIdentitas" type="text" id="noIdentitas" maxlength="30" size="35" value="${Anggota.noIdentitas}"/></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>Jenis Identias</td>
                                                                            <td><div align="center">:</div></td>
                                                                            <td><label for="jenisIdentitas"></label>
                                                                                <input name="jenisIdentitas" type="text" id="jenisIdentitas" size="20" maxlength="10" value="${Anggota.jenisIdentitas}"/></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>Kategori</td>
                                                                            <td><div align="center">:</div></td>
                                                                            <td><label for="kategori"></label>
                                                                                <select name="kategoriAnggotaId" id="kategori">
                                                                                    <option value="0">Pilih Kategori</option>

                                                                                    <san:forEach items="${kategoriAnggota}" var="katAnggota">
                                                                                        <option value="${katAnggota.idKategoriAnggota}">${katAnggota.nama}</option>
                                                                                    </san:forEach>
                                                                                </select></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td>Alamat</td>
                                                                            <td><div align="center">:</div></td>
                                                                            <td></td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td><textarea name="alamat" id="keterangan" cols="45" rows="5">${Anggota.alamat}</textarea></td>
                                                                        </tr
                                                                        <tr>
                                                                            <td>Keterangan</td>
                                                                            <td><div align="center">:</div></td>
                                                                            <td>&nbsp;</td>
                                                                        </tr>
                                                                        <tr>
                                                                            <td></td>
                                                                            <td></td>
                                                                            <td><textarea name="keterangan" id="keterangan" cols="45" rows="5">${Anggota.keterangan}</textarea></td>
                                                                        </tr
                                                                        <tr>
                                                                            <td>&nbsp;</td>
                                                                            <td><div align="center"></div></td>
                                                                            <td>

                                                                                <table width="200" border="0">
                                                                                    <tr>

                                                                                        <td width="68">
                                                                                            <input type="submit" name="btn1" id="button" value="Simpan" />
                                                                                        </td>
                                                                                        <san:if test="${seleksi==null}">
                                                                                            <td width="33">
                                                                                                <input type="reset" name="button3" id="button3" value="Bersihkan" />
                                                                                            </td>
                                                                                        </san:if>
                                                                                    </tr>
                                                                                </table>

                                                                            </td>
                                                                        </tr>
                                                                    </table>
                                                                </form>
                                                                <font style="font-family: Comic Sans MS;" color="yellow"><font style="color: yellow;" size="+1"><br />
                                                                    </font></font>
                                                                <div style="text-align: center;"><br />
                                                                    <font style="font-family: Comic Sans MS;" color="yellow"><font style="color: yellow;" size="+1">
                                                                        </font></font></div>
                                                            </div>
                                                            <font color="yellow">
                                                            </font></td>
                                                    </tr>
                                                </tbody>
                                            </table>
                                            &nbsp;
                                            <br />
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </td>
                    </tr>
                </tbody>
            </table><br />

        </center>

    </body></html>